package siva.carrental.agency.demo.core.carowner.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import siva.android.car.agency.R
import siva.carrental.agency.demo.api.data.OwnerLoginRepository
import siva.carrental.agency.demo.api.states.LoginFormState
import siva.carrental.agency.demo.api.states.LoginResult


class ResetPasswordViewModel(private val loginRepository: OwnerLoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun carRentalOwnerUpdatePassword(
        emailAddress: String,
        phoneNumber: String,
        uniqueIDNumber: Int,
        password: String
    ) {
        val result = loginRepository.carRentalOwnerUpdatePassword(
            emailAddress = emailAddress,
            phoneNumber = phoneNumber,
            uniqueIDNumber = uniqueIDNumber,
            password = password
        )
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}