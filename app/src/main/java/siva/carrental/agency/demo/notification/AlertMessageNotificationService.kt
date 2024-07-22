package siva.carrental.agency.demo.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Vibrator
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import siva.carrental.agency.demo.core.carowner.ui.CustomerDetailsListActivity
import siva.carrental.agency.demo.core.customer.ui.CustomerInformationActivity
import siva.carrental.agency.demo.services.CarRunningForegroundService

/**
 *
 * Created by
 * @author Siva Kumar Bata
 * @Date 7/13/2024.
 *
 */
class AlertMessageNotificationService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {

        var notification: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        var ring: Ringtone = RingtoneManager.getRingtone(applicationContext, notification)
        ring.play()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            ring.isLooping = false
        }

        // Vibration
        /*var vibration: Vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        var pattern = {100, 300, 300, 300}
        vibration.vibrate(pattern, -1)*/

        val title = message.notification?.title
        val text = message.notification?.body


        val CHANNEL_ID = "TEST_MESSAGE_NOTIFICATION"

        val notificationChannel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel(
                CHANNEL_ID,
                "Siva Car Rental Service",
                NotificationManager.IMPORTANCE_HIGH
            )
        } else {
            TODO("VERSION.SDK_INT < O")
        }

        var resultIntent1 = Intent(this, CustomerDetailsListActivity::class.java)
        var pendingIntent1 =
            PendingIntent.getActivity(this, 1, resultIntent1, PendingIntent.FLAG_MUTABLE)
        var resultIntent2 = Intent(this, CustomerInformationActivity::class.java)
        var pendingIntent2 =
            PendingIntent.getActivity(this, 1, resultIntent2, PendingIntent.FLAG_MUTABLE)

        getSystemService(NotificationManager::class.java).createNotificationChannel(
            notificationChannel
        )
        val notificationBuilder: Notification.Builder = Notification.Builder(this, CHANNEL_ID)
        notificationBuilder.setContentTitle(title)
        notificationBuilder.setContentText(text)
        notificationBuilder.setAutoCancel(true)

        //NotificationManagerCompat.from(this).notify(1, notificationBuilder.build())
        if(title == "Owner"){
            // Show notification messsage customer crossed speed limit
            // Send broad cast to user for the update customers list and update teh speed crossed status

            val intent = Intent(CarRunningForegroundService.SPEED_LIMIT_CROSSED_OWNER_MESSAGE)
            intent.putExtra("Speed", text)
            LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(intent)
            notificationBuilder.setContentIntent(pendingIntent1)
        }else {
            // This is customer message for speed limit update from 300kmph to 500kmph
            val intent = Intent(CarRunningForegroundService.SPEED_LIMIT_CROSSED_ALERT)
            intent.putExtra("SpeedLimitChangedOrUpdated", text)
            LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(intent)
            notificationBuilder.setContentIntent(pendingIntent2)
        }

        super.onMessageReceived(message)
    }
}