package com.chachadeveloper.equitymobile.presentation.register_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.chachadeveloper.equitymobile.presentation.util.Country
import com.chachadeveloper.equitymobile.presentation.util.getCountriesList

class RegisterViewModel : ViewModel() {
    var mobileNumber by mutableStateOf("")
    var mobileCountryCode by mutableStateOf("")

    val countriesList = getCountriesList()
    var mobileCountry by mutableStateOf<Country?>(null)

    private val _usernameText = mutableStateOf("")
    val usernameText: State<String> = _usernameText

    private val _emailText = mutableStateOf("")
    val emailText: State<String> = _emailText

    private val _passwordText = mutableStateOf("")
    val passwordText: State<String> = _passwordText

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _usernameError = mutableStateOf("")
    val usernameError: State<String> = _usernameError

    private val _emailError = mutableStateOf("")
    val emailError: State<String> = _emailError

    private val _passwordError = mutableStateOf("")
    val passwordError: State<String> = _passwordError

    private val _rememberMeState = mutableStateOf(false)
    val rememberMeState: State<Boolean> = _rememberMeState
    fun setRememberMe(value: Boolean) {
        _rememberMeState.value = value
    }

    fun setUsernameText(username: String) {
        _usernameText.value = username
    }

    fun setEmailText(email: String) {
        _emailText.value = email
    }

}