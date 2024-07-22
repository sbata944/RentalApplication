package siva.carrental.agency.demo.core.customer.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import siva.android.car.agency.R
import siva.carrental.agency.demo.core.carowner.viewmodel.OwnerLoginViewModel
import siva.carrental.agency.demo.core.customer.viewmodel.CustomerInformationViewModel
import siva.carrental.agency.demo.notification.Utility
import siva.carrental.agency.demo.services.CarRunningForegroundService
import siva.carrental.agency.demo.services.CarRunningForegroundService.Companion.SPEED_LIMIT_CROSSED_ALERT


class CustomerInformationActivity : AppCompatActivity() {

    private lateinit var loginViewModel: CustomerInformationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_information)

        loginViewModel = ViewModelProvider(this)[CustomerInformationViewModel::class.java]
        loginViewModel.getCarCustomersDetails("","", 0, "")

        /*
        * Assume like your bike is started and running to show the customer we are using the Foreground service
        *
        * */
        val serviceIntent = Intent(this, CarRunningForegroundService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(serviceIntent)
        }

        /*
        * Set customer token for Firebase for further operations
        * */
        Utility.setToken()


        /*
        *
        * Register Intent filter in case speed is crossed then we have to get the data from the service for further operations
        * */
        val intentFilter = IntentFilter(SPEED_LIMIT_CROSSED_ALERT)
        LocalBroadcastManager.getInstance(this).registerReceiver(
            mMessageReceiver, intentFilter
        );
    }

    private val mMessageReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {

            if (true) {
                // If the message type is speed limit crossed message

                /*
                * 1. Here we are taking the Owner token.
                * 2. Call Rest API saying the Speed limit crossed with the data (Speed value wer are getting from the intent)
                * 3. Send Fire base notification message to owner using the FC challenges
                * */
                Utility.getToken("Owner")
                loginViewModel.notifyToOwnerCrossedSpeedLimit("", "", 121, 100)
                Utility.sendNotification("Owner", "", applicationContext)

                /*------------ SHOW ALERT MESSAGE TO CUSTOMER -----------YOUR CROSSING SPEED LIMIT------------------------------*/
            } else {
                // If the messsage type is updated speed limit from 30kmph to 50 kmph
                loginViewModel.getCarCustomersDetails("","", 0, "")

                /*------------ SHOW ALERT MESSAGE TO CUSTOMER -----------YOUR SPEED LIMIT is INCREASED/DECREASED ---------------*/
            }

        }
    }
}