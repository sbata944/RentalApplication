package siva.carrental.agency.demo.core.carowner.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import siva.carrental.agency.demo.api.data.OwnerLoginRepository
import siva.carrental.agency.demo.api.model.CustomerDetailsModel

/**
 *
 * Created by
 * @author Siva Kumar Bata
 * @Date 7/12/2024.
 *
 */
class CustomerDetailsViewModel(private val loginRepository: OwnerLoginRepository) : ViewModel() {

    private val _loginResult = MutableLiveData<ArrayList<CustomerDetailsModel>>()
    val loginResult: LiveData<ArrayList<CustomerDetailsModel>> = _loginResult

    fun getCarRentedCustomersDetailsList(
        emailAddress: String,
        phoneNumber: String,
        uniqueIDNumber: Int,
        password: String
    ) {
        val result = loginRepository.getCarRentedCustomersDetailsList(
            emailAddress = emailAddress,
            phoneNumber = phoneNumber,
            uniqueIDNumber = uniqueIDNumber,
            password = password
        )
    }

    fun setCarSpeedLimitToCustomer(
        uniqueIDNumber: Int,
        customerID: Int,
        speedLimit: Int
    ) {
        val result = loginRepository.setCarSpeedLimitToUser(
            uniqueIDNumber = uniqueIDNumber,
            customerID = customerID,
            speedLimit = speedLimit
        )
    }
}