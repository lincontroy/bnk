package com.dev.chacha.data.repo

import android.app.Activity
import com.dev.chacha.domain.repo.AuthRepository
import com.dev.chacha.domain.util.Resource
import com.google.firebase.FirebaseException
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.util.concurrent.TimeUnit

class AuthRepositoryImpl(private val firebaseAuth: FirebaseAuth) : AuthRepository {
    private lateinit var omVerificationCode: String
    override fun loginUser(email: String, password: String): Flow<Resource<AuthResult>> {
        return flow {
            emit(value = Resource.Loading())
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            emit(value = Resource.Success(data = result))
        }.catch {
            emit(value = Resource.Error(it.message.toString()))
        }
    }

    override fun registerUser(
        name: String,
        email: String,
        password: String
    ): Flow<Resource<AuthResult>> {
        return flow {
            emit(value = Resource.Loading())
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val profileUpdates = UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .build()

            result.user?.updateProfile(profileUpdates)?.await()
            firebaseAuth.currentUser?.sendEmailVerification()?.await()
            emit(value = Resource.Success(data = result))
        }.catch {
            emit(value = Resource.Error(it.message.toString()))
        }

    }

    override suspend fun forgotPassword(email: String): Resource<Any> {
        return try {
            firebaseAuth.sendPasswordResetEmail(email).await()
            Resource.Success("Success")
        } catch (e: Exception) {
            return Resource.Error(e.localizedMessage ?: "Unknown error occurred")
        }
    }

    override suspend fun userAutologin(): Boolean {
        val uid = firebaseAuth.currentUser?.uid
        return uid != null
    }

    override fun createUserWithPhone(phone: String, activity: Activity): Flow<Resource<String>> =
        callbackFlow {
            trySend(Resource.Loading())

            val onVerificationCallback =
                object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    override fun onVerificationCompleted(p0: PhoneAuthCredential) {

                    }

                    override fun onVerificationFailed(p0: FirebaseException) {
                        trySend(Resource.Error(p0.message.toString()))

                    }

                    override fun onCodeSent(
                        verificationCode: String,
                        p1: PhoneAuthProvider.ForceResendingToken
                    ) {
                        super.onCodeSent(verificationCode, p1)
                        trySend(Resource.Success("OTP Sent Successfully"))
                        omVerificationCode = verificationCode
                    }

                }

            val options = PhoneAuthOptions.newBuilder(firebaseAuth)
                .setPhoneNumber("+254$phone")
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(activity)
                .setCallbacks(onVerificationCallback)
                .build()
            PhoneAuthProvider.verifyPhoneNumber(options)
            awaitClose {
                close()
            }
        }

    override fun signWithCredential(otp: String): Flow<Resource<String>> = callbackFlow {
        trySend(Resource.Loading())
        val credential = PhoneAuthProvider.getCredential(omVerificationCode, otp)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener {
                if (it.isSuccessful)
                    trySend(Resource.Success("otp verified"))
            }.addOnFailureListener {
                trySend(Resource.Error(it.message.toString()))
            }
        awaitClose {
            close()
        }
    }

    override fun signOut() {
        firebaseAuth.signOut()
    }
}