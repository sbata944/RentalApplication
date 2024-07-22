package siva.carrental.agency.demo.notification


import android.content.Context
import androidx.annotation.NonNull
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject
import java.util.HashMap
import org.checkerframework.checker.nullness.qual.NonNull as NonNull1

/**
 *
 * Created by
 * @author Siva Kumar Bata
 * @Date 7/13/2024.
 *
 */
class SendNotification(mUserFCMToken: String, mTitle: String, mBody: String, mContext: Context) {

    private var userFCMToken: String = mUserFCMToken
    private var title: String = mTitle
    private var body: String = mBody
    private var context: Context = mContext
    private val postUrl = "https://fcm.googleapis.com/v1/projects/chatti-8031c/message:send"


    fun sendNotification(){
        var requestQueue = Volley.newRequestQueue(context)
        var mainObj = JSONObject()

        try {
            var messageObject = JSONObject()
            var notificationObject = JSONObject()
            notificationObject.put("title", title)
            notificationObject.put("body", body)
            messageObject.put("token", userFCMToken)
            messageObject.put("notification", notificationObject)
            mainObj.put("message", messageObject)

            val request = JsonObjectRequest(Request.Method.POST, postUrl, mainObj, Response.Listener { response ->
                val str = response.toString()
            }, Response.ErrorListener {
                    error ->
            }){
                @NonNull
                @Override
                fun getHeaders(): Map<String, String>{
                    var accessToken = AccessToken()
                    var accessKey = accessToken.getAccessToken()
                    var header: Map<String, String> = hashMapOf("content-type" to "application/json" , "authorization" to "Bearer $accessKey")
                    return header
                }
            }
            requestQueue.add(request)
        }catch (exception: JSONException){

        }

    }

}