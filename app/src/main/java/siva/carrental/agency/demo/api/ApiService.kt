package siva.carrental.agency.demo.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
/**
 *
 * Created by
 * @author Siva Kumar Bata
 * @Date 7/12/2024.
 *
 */
interface ApiService {

                    /*-----------------------------------Car Rental Owner APIs------------------------------------*/

    // This API will give Unique Car owner ID
    @GET("posts/{id}")
    fun carRentalOwnerRegistration(@Path("id") userName: String, emailAddress:String,phoneNumber: String ,password: String ): Call<Int>

    // This API will give owner login success or failure
    @GET("posts/{id}")
    fun carRentalOwnerLogin(@Path("id") emailAddress: String, phoneNumber:String, uniqueIDNumber: Int, password: String): Call<Boolean>

    // This API will update the password in case car rental owner forgot
    @GET("posts/{id}")
    fun carRentalOwnerUpdatePassword(@Path("id")emailAddress: String, phoneNumber:String, uniqueIDNumber: Int, password: String ): Call<Boolean>

    // This API will give list of car rented customer details list
    // For this API we are getting JSON List along with the details
    @GET("GET/{id}")
    fun getCarRentedCustomersDetailsList(@Path("id")emailAddress: String, phoneNumber:String, uniqueIDNumber: Int, password: String ): Call<String>

    // This API will will set the speed limit to any of the customer along with his customer ID
    @GET("posts/{id}")
    fun setCarSpeedLimitToUser(@Path("id")uniqueIDNumber: Int, customerID: Int, speedLimit: Int): Call<Boolean>



                    /*-----------------------------------Customer APIs------------------------------------*/


    // This API will give Unique customer ID
    @GET("posts/{id}")
    fun carCustomerRegistration(@Path("id") userName: String, emailAddress:String,phoneNumber: String ,password: String ): Call<Int>

    // This API will give owner login success or failure
    @GET("posts/{id}")
    fun carCustomerLogin(@Path("id") emailAddress: String, phoneNumber:String, customerID: Int, password: String): Call<Boolean>

    // This API will update the password in case car customer forgot
    @GET("posts/{id}")
    fun carCustomerUpdatePassword(@Path("id")emailAddress: String, phoneNumber:String, customerID: Int, password: String ): Call<Boolean>

    // This API will give list of car rented customer details
    // For this API we are getting JSON format output along with the details
    @GET("GET/{id}")
    fun getCarCustomersDetails(@Path("id")emailAddress: String, phoneNumber:String, customerID: Int, password: String ): Call<String>

    // This API will will update the
    @GET("posts/{id}")
    fun notifyToOwnerCrossedSpeedLimit(@Path("id")emailAddress: String, phoneNumber:String, customerID: Int, speed: Int): Call<Boolean>
}