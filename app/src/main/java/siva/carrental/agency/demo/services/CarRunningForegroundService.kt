package siva.carrental.agency.demo.services

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.localbroadcastmanager.content.LocalBroadcastManager


/**
 *
 * Created by
 * @author Siva Kumar Bata
 * @Date 7/14/2024.
 *
 */
class CarRunningForegroundService: Service() {

    companion object{
        public const val SPEED_LIMIT_CROSSED_ALERT = "SpeedLimitCrossed"
        public const val CHANNEL_ID = "CarRentalServiceID"
        public const val RENTAL_CAR_SERVICE_RUNNING = "Rental Car is running"
        public const val RENTAL_CAR_SERVICE_MESSAGE = "Siva Rental Car Agency"
        public const val SPEED_LIMIT_CROSSED_OWNER_MESSAGE = "OwnerGotSpeedLimitCrossedMessage"

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        showNotificationDetails()
        return super.onStartCommand(intent, flags, startId)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun showNotificationDetails() {

        val channel = NotificationChannel(
            CHANNEL_ID,
            CHANNEL_ID,
            NotificationManager.IMPORTANCE_LOW
        )

        /*
        * Show notification to customer "Your rental car is running, don't cross the speed limit"
        * Due to this customer can be alerted.
        */
        getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        val notification: Notification.Builder = Notification.Builder(this, CHANNEL_ID)
            .setContentText(RENTAL_CAR_SERVICE_RUNNING)
            .setContentTitle(RENTAL_CAR_SERVICE_MESSAGE)
            /*
            *
            *
            * Assume Android Service is Connected with Car property Manager once after the Registration.
            * From Here we are getting the live car speed from the CarProperty Manager through VHAL communication.
            *
            *
            * */

        /*
        * currentSpeedLimit ---- Assume this data we are getting lively from the vehicle below layers speed when the car is running.
        * speedLimit ---  Assume this data we are getting from the Rest API and we have stored these details in the SP and we are taking from SP
        * If the customer crossed the speed limit then we are sending the notification to the rental owner
        */
        var currentSpeedLimit = 100 //
        var speedLimit = 90 //
        if(speedLimit > currentSpeedLimit){
            sendSpeedLimitCrossedMessage(currentSpeedLimit)
        }

        startForeground(1001, notification.build())
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    private fun sendSpeedLimitCrossedMessage(currentSpeedLimit: Int) {

        /*
        * This intent filter we have registered at the Customer Details screen.
        * When speed is crossed we are notifying to intent filter through the BCR
        *
        */
        val intent = Intent(SPEED_LIMIT_CROSSED_ALERT)
        intent.putExtra("Speed", currentSpeedLimit)
        LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(intent)
    }
}