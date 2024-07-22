package siva.carrental.agency.demo.core.carowner.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.StrictMode
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import siva.android.car.agency.databinding.ActivityCarRentedListBinding
import siva.carrental.agency.demo.core.carowner.viewmodel.CustomerDetailsViewModel
import siva.carrental.agency.demo.core.carowner.adapter.CustomerDetailsAdapter
import siva.carrental.agency.demo.api.model.CustomerDetailsModel
import siva.carrental.agency.demo.notification.Utility
import siva.carrental.agency.demo.services.CarRunningForegroundService

class CustomerDetailsListActivity : AppCompatActivity() {
    private var customerDetailsList = ArrayList<CustomerDetailsModel>()
    private lateinit var customerDetailsAdapter: CustomerDetailsAdapter

    private lateinit var loginViewModel: CustomerDetailsViewModel
    private lateinit var binding: ActivityCarRentedListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarRentedListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginViewModel = ViewModelProvider(this)[CustomerDetailsViewModel::class.java]
        //loginViewModel.getCarRentedCustomersDetailsList("", "") get all customer details list

        customerDetailsAdapter = CustomerDetailsAdapter(customerDetailsList)
        val layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        binding.recyclerView.adapter = customerDetailsAdapter


        loginViewModel.loginResult.observe(this, Observer {
            val loginResult = it ?: return@Observer
            customerDetailsList = it
            customerDetailsAdapter.notifyDataSetChanged()
        })
        /*
        *
        * When onclick event happen in the customer owner is setting the speed through the api with the support of customer id and username
        * */
        if(true){
            Utility.getToken("Customer")
            loginViewModel.setCarSpeedLimitToCustomer(0, 100, 200)
            Utility.sendNotification("Customer","", applicationContext)
        }

        /*
       * Set OWNER token for Firebase for further operations
       * */
        Utility.setToken()

        /*
        *
        * Register Intent filter in case speed is crossed then we have to get the data from the service for further operations
        * */
        val intentFilter = IntentFilter(CarRunningForegroundService.SPEED_LIMIT_CROSSED_OWNER_MESSAGE)
        LocalBroadcastManager.getInstance(this).registerReceiver(
            mMessageReceiver, intentFilter);
    }

    private val mMessageReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {

            /*
            * 1. Owner got speed limit crossed message.
            * 2. He has to update the list with the latest data
            * */
            loginViewModel.getCarRentedCustomersDetailsList("", "", 0, "")
            customerDetailsAdapter.notifyDataSetChanged()

            /*@@@@@@@@@@@@  Hilight with RED Color Speed crossed customer @@@@@@@@@@@@*/
        }
    }
}