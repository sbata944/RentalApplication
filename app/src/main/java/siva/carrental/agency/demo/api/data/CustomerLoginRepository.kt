package siva.carrental.agency.demo.api.data

import siva.carrental.agency.demo.api.model.CustomerDetailsModel
import siva.carrental.agency.demo.api.model.CustomerRegistrationData

/**
 *
 * Created by
 * @author Siva Kumar Bata
 * @Date 7/13/2024.
 *
 */
class CustomerLoginRepository(val dataSource: CustomerLoginDataSource) {

    fun carCustomerRegistration(
        userName: String,
        emailAddress: String,
        phoneNumber: String,
        password: String
    ): Result<CustomerRegistrationData> {
        val result =
            dataSource.carCustomerRegistration(
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

    fun carCustomerLogin(
        userName: String,
        emailAddress: String,
        phoneNumber: String,
        customerID: Int,
        password: String
    ): Result<CustomerRegistrationData> {
        val result = dataSource.carCustomerLogin(
            userName = userName,
            emailAddress = emailAddress,
            phoneNumber = phoneNumber,
            customerID = customerID,
            password = password
        )

        if (result is Result.Success) {
            //Store in the DB or Preference
        }

        return result
    }

    fun carCustomerUpdatePassword(
        emailAddress: String,
        phoneNumber: String,
        customerID: Int,
        password: String
    ): Result<CustomerRegistrationData> {
        val result =
            dataSource.carCustomerUpdatePassword(emailAddress, phoneNumber, customerID, password)

        if (result is Result.Success) {
            //Store in the DB or Preference
        }

        return result
    }

    fun getCarCustomersDetails(
        emailAddress: String,
        phoneNumber: String,
        customerID: Int,
        password: String
    ): Result<ArrayList<CustomerDetailsModel>> {
        val result = dataSource.getCarCustomersDetails(
            emailAddress,
            phoneNumber,
            customerID,
            password
        )

        if (result is Result.Success) {
            //Store in the DB or Preference
        }

        return result
    }

    fun notifyToOwnerCrossedSpeedLimit(
        emailAddress: String,
        phoneNumber: String,
        customerID: Int,
        speed: Int
    ): Result<Boolean> {
        val result = dataSource.notifyToOwnerCrossedSpeedLimit(
            emailAddress,
            phoneNumber,
            customerID,
            speed
        )

        if (result is Result.Success) {
            //Store in the DB or Preference
        }

        return result
    }
}