package com.example.composeinstagram.login.presentation

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeinstagram.login.domain.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel(){

    private val loginUseCase = LoginUseCase()

    //Para que la vista pueda leer pero no modificar el valor
    private val _email = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()
    private val _isLoginEnable = MutableLiveData<Boolean>()
    private val _isLoading = MutableLiveData<Boolean>()


    val email: LiveData<String> = _email
    val password: LiveData<String> = _password
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable
    val isLoading: LiveData<Boolean> = _isLoading

    fun onLoginChange(email: String, password:String) {
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLoginButton(email, password)
    }

    fun enableLoginButton(email: String, password: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 8
    }

    fun onLoginSelected() {
        viewModelScope.launch {
            _isLoading.value = true
            val result = loginUseCase(email.value!!, password.value!!)
            if (result) {
                Log.i("LoginViewModel", "Login success")
            }
            _isLoading.value = false
        }
    }
}