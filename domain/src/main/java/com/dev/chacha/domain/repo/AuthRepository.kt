package com.dev.chacha.domain.repo

import android.app.Activity
import com.dev.chacha.domain.util.Resource
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun loginUser(email: String,password: String): Flow<Resource<AuthResult>>

    fun registerUser(name: String ,email: String,password: String): Flow<Resource<AuthResult>>

    fun createUserWithPhone(phone:String, activity:Activity) : Flow<Resource<String>>

    fun signWithCredential(otp:String): Flow<Resource<String>>


    suspend fun forgotPassword(email: String): Resource<Any>

    suspend fun userAutologin(): Boolean


    fun signOut()


}