package siva.carrental.agency.demo.api.model

/**
 *
 * Created by
 * @author Siva Kumar Bata
 * @Date 7/12/2024.
 *
 */
class CustomerDetailsModel(
    userName: String?,
    userID: Int?,
    gender: String?,
    speedLimit: Int?,
    carModel: String,
    crossedLimit: Boolean?
) {

    private var userName: String
    private var gender: String
    private var speedLimit: Int
    private var carModel: String
    private var userID: Int
    private var crossedLimit: Boolean

    init {
        this.userName = userName!!
        this.gender = gender!!
        this.speedLimit = speedLimit!!
        this.carModel = carModel
        this.userID = userID!!
        this.crossedLimit = crossedLimit!!
    }

    fun getUserName(): String? {
        return userName
    }

    fun setUserName(name: String?) {
        userName = name!!
    }

    fun getGender(): String? {
        return gender
    }

    fun setGender(gend: String?) {
        gender = gend!!
    }

    fun getSpeedLimit(): Int? {
        return speedLimit
    }

    fun setSpeedLimit(speed: Int?) {
        speedLimit = speed!!
    }

    fun getCarModel(): String? {
        return carModel
    }

    fun setCarModel(model: String?) {
        carModel = model!!
    }

    fun getUserID(): Int? {
        return userID
    }

    fun setCarModel(id: Int?) {
        userID = id!!
    }

    fun getCrossedLimit(): Boolean? {
        return crossedLimit
    }

    fun setCrossedLimit(limit: Boolean?) {
        crossedLimit = limit!!
    }
}