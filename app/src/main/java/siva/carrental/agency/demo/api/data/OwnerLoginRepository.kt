package siva.carrental.agency.demo.api.data

import siva.carrental.agency.demo.api.model.CustomerDetailsModel
import siva.carrental.agency.demo.api.model.OwnerRegistrationData

class OwnerLoginRepository(val dataSource: OwnerLoginDataSource) {


    fun carRentalOwnerRegistration(
        userName: String,
        emailAddress: String,
        phoneNumber: String,
        password: String
    ): Result<OwnerRegistrationData> {
        val result =
            dataSource.carRentalOwnerRegistration(
                userName = userName,
                emailAddress = emailAddress,
                phoneNumber = phoneNumber,
                password = password
            )

        if (result is Result.Success) {
            //Store in the DB or Preference
        }

        return result
    }

    fun carRentalOwnerLogin(
        userName: String,
        emailAddress: String,
        phoneNumber: String,
        uniqueIDNumber: Int,
        password: String
    ): Result<OwnerRegistrationData> {
        val result = dataSource.carRentalOwnerLogin(
            userName = userName,
            emailAddress = emailAddress,
            phoneNumber = phoneNumber,
            uniqueIDNumber = uniqueIDNumber,
            password = password
        )

        if (result is Result.Success) {
            //Store in the DB or Preference
        }

        return result
    }

    fun carRentalOwnerUpdatePassword(
        emailAddress: String,
        phoneNumber: String,
        uniqueIDNumber: Int,
        password: String
    ): Result<OwnerRegistrationData> {
        val result = dataSource.carRentalOwnerUpdatePassword(
            emailAddress = emailAddress,
            phoneNumber = phoneNumber,
            uniqueIDNumber = uniqueIDNumber,
            password = password
        )

        if (result is Result.Success) {
            //Store in the DB or Preference
        }

        return result
    }

    fun getCarRentedCustomersDetailsList(
        emailAddress: String,
        phoneNumber: String,
        uniqueIDNumber: Int,
        password: String
    ): Result<ArrayList<CustomerDetailsModel>> {
        val result = dataSource.getCarRentedCustomersDetailsList(
            emailAddress = emailAddress,
            phoneNumber = phoneNumber,
            uniqueIDNumber = uniqueIDNumber,
            password = password
        )

        if (result is Result.Success) {
            //Store in the DB or Preference
        }

        return result
    }

    fun setCarSpeedLimitToUser(
        uniqueIDNumber: Int,
        customerID: Int,
        speedLimit: Int
    ): Result<Boolean> {
        val result = dataSource.setCarSpeedLimitToUser(
            uniqueIDNumber = uniqueIDNumber,
            customerID = customerID,
            speedLimit = speedLimit
        )

        if (result is Result.Success) {
            //Store in the DB or Preference
        }

        return result
    }
}