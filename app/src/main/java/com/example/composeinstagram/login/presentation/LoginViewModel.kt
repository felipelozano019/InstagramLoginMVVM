package com.example.composeinstagram.login.presentation

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){

    //Para que la vista pueda leer pero no modificar el valor
    private val _email = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()
    private val _isLoginEnable = MutableLiveData<Boolean>()


    val email: LiveData<String> = _email
    val password: LiveData<String> = _password
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable

    fun onLoginChange(email: String, password:String) {
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLoginButton(email, password)
    }

    fun enableLoginButton(email: String, password: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 8
    }
}