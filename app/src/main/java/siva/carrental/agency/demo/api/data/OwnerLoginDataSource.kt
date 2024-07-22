package siva.carrental.agency.demo.api.data

import siva.carrental.agency.demo.api.ApiClient
import java.util.UUID
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import siva.carrental.agency.demo.api.model.CustomerDetailsModel
import siva.carrental.agency.demo.api.model.OwnerRegistrationData

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class OwnerLoginDataSource {

    // OWNER API List

    fun carRentalOwnerRegistration(userName: String, emailAddress:String, phoneNumber: String, password: String ): Result<OwnerRegistrationData> {
        val call = ApiClient.apiService.carRentalOwnerRegistration(userName = userName, emailAddress = emailAddress, phoneNumber = phoneNumber, password = password)
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
        val fakeOwner = OwnerRegistrationData(userName, emailAddress,phoneNumber, password,UUID.randomUUID().toString().toInt() )
        return Result.Success(fakeOwner)
    }
    fun carRentalOwnerLogin(userName: String,emailAddress: String, phoneNumber:String, uniqueIDNumber: Int, password: String): Result<OwnerRegistrationData> {
        val call = ApiClient.apiService.carRentalOwnerLogin(emailAddress = emailAddress, phoneNumber = phoneNumber, uniqueIDNumber = uniqueIDNumber, password = password)
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
        val fakeOwner = OwnerRegistrationData(userName, emailAddress,phoneNumber, password,UUID.randomUUID().toString().toInt() )
        return Result.Success(fakeOwner)
    }

    fun carRentalOwnerUpdatePassword(emailAddress: String, phoneNumber:String, uniqueIDNumber: Int, password: String ): Result<OwnerRegistrationData> {
        val call = ApiClient.apiService.carRentalOwnerUpdatePassword(emailAddress = emailAddress, phoneNumber = phoneNumber, uniqueIDNumber = uniqueIDNumber, password = password)
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
        val fakeOwner = OwnerRegistrationData("", emailAddress,phoneNumber, password,UUID.randomUUID().toString().toInt() )
        return Result.Success(fakeOwner)
    }

    fun getCarRentedCustomersDetailsList(emailAddress: String, phoneNumber:String, uniqueIDNumber: Int, password: String ): Result<ArrayList<CustomerDetailsModel>> {
        val call = ApiClient.apiService.getCarRentedCustomersDetailsList(
            emailAddress = emailAddress,
            phoneNumber = phoneNumber,
            uniqueIDNumber = uniqueIDNumber,
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
        return Result.Success(prepareCustomerDetailsListData())
    }
    fun setCarSpeedLimitToUser(uniqueIDNumber: Int, customerID: Int, speedLimit: Int): Result<Boolean>
    {
        val call = ApiClient.apiService.setCarSpeedLimitToUser(
            uniqueIDNumber = uniqueIDNumber,
            customerID = customerID,
            speedLimit=speedLimit,
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

    private fun prepareCustomerDetailsListData(): ArrayList<CustomerDetailsModel> {

        var customerDetailsList = ArrayList<CustomerDetailsModel>()
        for(i in 1..50){
            if(i % 2 ==0){
                var movie = CustomerDetailsModel("Siva $i", i, "Male", 100+i, "ABC", true)
                customerDetailsList.add(movie)
            }else if(i % 3==0){
                var movie = CustomerDetailsModel("Siva $i", i, "Male", 100+i, "ABC", true)
                customerDetailsList.add(movie)
            }else {
                var movie = CustomerDetailsModel("Siva $i", i, "Male", 100+i, "ABC", false)
                customerDetailsList.add(movie)
            }
        }
        return customerDetailsList
    }
}