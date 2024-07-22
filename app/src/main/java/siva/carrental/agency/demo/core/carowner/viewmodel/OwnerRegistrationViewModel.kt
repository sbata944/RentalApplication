package siva.carrental.agency.demo.core.carowner.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import siva.carrental.agency.demo.api.data.OwnerLoginRepository
import siva.carrental.agency.demo.api.states.LoginFormState
import siva.carrental.agency.demo.api.states.LoginResult

/**
 *
 * Created by
 * @author Siva Kumar Bata
 * @Date 7/13/2024.
 *
 */
class OwnerRegistrationViewModel (private val loginRepository: OwnerLoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun carRentalOwnerRegistration(
        userName: String,
        emailAddress: String,
        phoneNumber: String,
        password: String
    ){
        val result = loginRepository.carRentalOwnerRegistration(
            userName = userName,
            emailAddress = emailAddress,
            phoneNumber = phoneNumber,
            password = password
        )
    }
}