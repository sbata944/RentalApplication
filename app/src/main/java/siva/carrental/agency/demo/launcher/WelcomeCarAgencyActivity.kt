package siva.carrental.agency.demo.launcher

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import siva.android.car.agency.databinding.ActivityWelcomeCarAgencyBinding
import siva.carrental.agency.demo.core.carowner.ui.OwnerLoginActivity
import siva.carrental.agency.ui.topheadline.TopHeadlineActivity

class WelcomeCarAgencyActivity : AppCompatActivity() {


    private lateinit var binding:ActivityWelcomeCarAgencyBinding

    @SuppressLint("LongLogTag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeCarAgencyBinding.inflate(layoutInflater)

        binding.ownerlogin.setOnClickListener{
            Log.i(TAG, "Selected Owner Login Option")
            val intent = Intent(this, OwnerLoginActivity::class.java);
            startActivity(intent)
        }
        binding.customerlogin.setOnClickListener{
            Log.i(TAG, "Selected Customer Login Option")
            val intent = Intent(this, TopHeadlineActivity::class.java);
            startActivity(intent)
        }

        val policy: StrictMode.ThreadPolicy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
    }

    companion object {
        private const val TAG: String = "WelcomeCarAgencyActivity"
    }
}