package siva.carrental.agency.demo.notification

import android.content.Context
import android.media.MediaPlayer
import android.os.Handler
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.messaging.FirebaseMessaging


/**
 *
 * Created by
 * @author Siva Kumar Bata
 * @Date 7/13/2024.
 *
 */
object Utility {

    fun sendNotification(senderUID: String, receiverUID:String, context: Context){
        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                var sendNotification = SendNotification("token", "title", "body", context)
                sendNotification.sendNotification()
            }
        }, 3000)
    }

    fun getToken(mSenderOrReceiverUID: String){

        var ref = FirebaseDatabase.getInstance().reference.child("Tokens").child(mSenderOrReceiverUID).child("token")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
               var userToken = dataSnapshot.getValue(String::class.java)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })


    }

    fun setToken(){
        var userToken = FirebaseMessaging.getInstance().token
        userToken.addOnCompleteListener(object : MediaPlayer.OnCompletionListener<String> {
            override fun onComplete(task: Task<String>) {
                var token = task.getResult()
                FirebaseDatabase.getInstance().getReference("Tokens").child("uid").child("token").setValue(token)
            }
        })
    }

}