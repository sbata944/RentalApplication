package siva.carrental.agency.demo.api.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import siva.carrental.agency.demo.api.ApiClient
import siva.carrental.agency.demo.api.model.CustomerDetailsModel
import siva.carrental.agency.demo.api.model.CustomerRegistrationData
import java.util.UUID

/**
 *
 * Created by
 * @author Siva Kumar Bata
 * @Date 7/13/2024.
 *
 */
class CustomerLoginDataSource {
    // CUSTOMER API List

    fun carCustomerRegistration(userName: String, emailAddress:String, phoneNumber: String, password: String ): Result<CustomerRegistrationData> {
        val call = ApiClient.apiService.carCustomerRegistration(userName = userName, emailAddress = emailAddress, phoneNumber = phoneNumber, password = password)
        call.enqueue(object : Callback<Int> {
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {
                    val post = response.body()
                    // Store all the data into Share Preference for next user login.
                } else {
                    // Handle error
                }
            }
            override fun onFailure(call: Call<Int>, t: Throwable) {
                // Handle failure
            }
        })
        val fakeOwner = CustomerRegistrationData(userName, emailAddress,phoneNumber, password,
            UUID.randomUUID().toString().toInt() )
        return Result.Success(fakeOwner)
    }
    fun carCustomerLogin(userName: String,emailAddress: String, phoneNumber:String, customerID: Int, password: String): Result<CustomerRegistrationData> {
        val call = ApiClient.apiService.carCustomerLogin(emailAddress = emailAddress, phoneNumber = phoneNumber, customerID = customerID, password = password)
        call.enqueue(object : Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                if (response.isSuccessful) {
                    val post = response.body()
                    // Store all the data into Share Preference for next user login.
                } else {
                    // Handle error
                }
            }
            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                // Handle failure
            }
        })
        val fakeOwner = CustomerRegistrationData(userName, emailAddress,phoneNumber, password,
            UUID.randomUUID().toString().toInt() )
        return Result.Success(fakeOwner)
    }

    fun carCustomerUpdatePassword(emailAddress: String, phoneNumber:String, customerID: Int, password: String ): Result<CustomerRegistrationData> {
        val call = ApiClient.apiService.carCustomerUpdatePassword(emailAddress = emailAddress, phoneNumber = phoneNumber, customerID = customerID, password = password)
        call.enqueue(object : Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                if (response.isSuccessful) {
                    val post = response.body()
                    // Store all the data into Share Preference for next user login.
                } else {
                    // Handle error
                }
            }
            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                // Handle failure
            }
        })
        val fakeOwner = CustomerRegistrationData("", emailAddress,phoneNumber, password,
            UUID.randomUUID().toString().toInt() )
        return Result.Success(fakeOwner)
    }

    fun getCarCustomersDetails(emailAddress: String, phoneNumber:String, customerID: Int, password: String ): Result<ArrayList<CustomerDetailsModel>> {
        val call = ApiClient.apiService.getCarCustomersDetails(
            emailAddress = emailAddress,
            phoneNumber = phoneNumber,
            customerID = customerID,
            password = password
        )
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    val post = response.body()
                    // Store all the data into Share Preference for next user login.
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                // Handle failure
            }
        })
        return Result.Success(prepareCustomerDetails())
    }
    fun notifyToOwnerCrossedSpeedLimit(emailAddress: String, phoneNumber:String, customerID: Int, speed: Int): Result<Boolean> {
        val call = ApiClient.apiService.notifyToOwnerCrossedSpeedLimit(
            emailAddress =emailAddress,
            phoneNumber= phoneNumber,
            customerID =customerID,
            speed= speed
        )
        call.enqueue(object : Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                if (response.isSuccessful) {
                    val post = response.body()
                    // Store all the data into Share Preference for next user login.
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                // Handle failure
            }
        })
        return Result.Success(true)
    }

    private fun prepareCustomerDetails(): ArrayList<CustomerDetailsModel> {

        val customerDetailsList = ArrayList<CustomerDetailsModel>()
        val details = CustomerDetailsModel("Siva ", 100, "Male", 143, "ABC", true)
        customerDetailsList.add(details)
        return customerDetailsList
    }

}