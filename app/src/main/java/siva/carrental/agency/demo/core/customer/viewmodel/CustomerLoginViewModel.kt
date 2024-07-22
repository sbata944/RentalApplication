package siva.carrental.agency.demo.core.customer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import siva.carrental.agency.demo.api.data.CustomerLoginRepository
import siva.carrental.agency.demo.api.states.LoginFormState
import siva.carrental.agency.demo.api.states.LoginResult

/**
 *
 * Created by
 * @author Siva Kumar Bata
 * @Date 7/13/2024.
 *
 */
class CustomerLoginViewModel(private val loginRepository: CustomerLoginRepository) :
    ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun carCustomerLogin(
        userName: String,
        emailAddress: String,
        phoneNumber: String,
        customerID: Int,
        password: String
    ) {
        val result = loginRepository.carCustomerLogin(
            userName = userName,
            emailAddress = emailAddress,
            phoneNumber = phoneNumber,
            customerID = customerID,
            password = password
        )
    }
}