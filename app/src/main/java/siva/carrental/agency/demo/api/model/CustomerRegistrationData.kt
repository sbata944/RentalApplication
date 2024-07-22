package siva.carrental.agency.demo.api.model

/**
 *
 * Created by
 * @author Siva Kumar Bata
 * @Date 7/13/2024.
 *
 */
data class CustomerRegistrationData(val userName: String,
                                    val emailAddress: String,
                                    val phoneNumber: String,
                                    val password: String,
                                    val customerID: Int)