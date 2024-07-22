package siva.carrental.agency.demo.notification

import com.google.auth.oauth2.GoogleCredentials
import com.google.common.collect.Lists
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream
import java.nio.charset.StandardCharsets

/**
 *
 * Created by
 * @author Siva Kumar Bata
 * @Date 7/13/2024.
 *
 */
class AccessToken {

    companion object{
        private const val firebaseMessagingScope: String = "https://www.googleapis.com/auth/firebase.messaging"

    }

    fun getAccessToken(): String {
        try {
            val jsonString = "{\n" +
                    "  \"type\": \"service_account\",\n" +
                    "  \"project_id\": \"carrentalservice-faa64\",\n" +
                    "  \"private_key_id\": \"4dfd72d5bf0d142b1250858ed5388e8f483510ee\",\n" +
                    "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDgXT8Mmo1gVZyi\\n/hZ0iIzItSSbPTz07Bgu2dVTCwjZDnKOGnWz9ig97uUyjrPJ2xDSQ+Hhs5CnnZzC\\nT4oqDzrPhWlEtrFyy8GddPUBNOI6l75yU+ZTafAvz5N883re3g9Wd+E4sJJZadqm\\nNnn8xNMnygXFL0jOGCgM9oRISxIlhmjYj4Ygy5Ln/iwBdZCccZKTgiHdTSOEdTn+\\nbN1SaaouIn3CfDKj4+ZTkBzD12JLPDdVjgpTH+eQ2zLgltEzO7XXQNv+0A+eZY/8\\nvLB9aw1562mbXyiAIbnZVx2h6PbkhlDtjYGAloCn8MXTXz8G9QK+Rpgvdv7RwuTs\\nWK2CtysfAgMBAAECggEAAOHHxW2ooxARSbcS6OdYyrjnZdXk3+KOGP4B6NJSLykI\\nxeEhgiI5w5hHgImO7U+2ga39iJolJ8bmrXvKwa7dY7ZYldPt6JXhnWxuAYFkNLD7\\npX/iK6HMn9YxdhK3kSucoe+GDgKV0dEW1XbwCFtV4eNpe5sh73FoGxD+3oSkWgcf\\nKTxKIQid2h91wwGrXHBpyn8VpHMNWdrxdLMNk7050n31bfS5vWAa/H29fm/J4xjN\\nqPNSSUzQHV/vVdicnMZkiJiQeRkX8TQ6I4nl3Xx2Z9VbUVbw1yDJKtgpY+ldjoY1\\ndcJUMRzNgs/NGxI37Qrwiwwgx61XZcAgSYB2xSqXKQKBgQD/UxCCG3LNpChaEK7X\\nXc6cs8/ZMRsRmtpOivhBo+qKmPyjtS2sOtqIIj1CQi64q+WTWYX8HqCBDDenvTf8\\n3TSHmUjof/KriAVrQ2O9x8JS1G6EA0OdmySLMfUgzuLSjzXtCDfH0+bsQfDfF9ac\\nkt0YE+wpeYKrvTFEU8vY+KTFZQKBgQDg9TZAnC6Wn5ctRsJFgJX3q8wRAxBpfkWS\\nN9EgY0g7s23I8yJZKLYKXasuz278RTRFKykL7AajFooQpzkPgSiThy6bVavq0x/s\\n3GmthhjcOPm7AyhdsGnuX78UVa5XgAZTRcRQZ//CPYj2Mu7V/jL5+ddSbC/jHo89\\nFyq+AmL4MwKBgBLAOe0kMOkzThdXNE/yvrK5beFIfvFrCu9Lu3GupRHqrFsleiY0\\n6EmpIhCUpbPARArvPyzF3wm7KPczqUHzyODQfA8/HkZEpgk7mL6eRgIpQbiGONgB\\nRczHLXZsWzIVfGNdACO3xzTAnvzzVjqHep9DD0v4dYVBTrXy5XyYvhkVAoGAUlDI\\nGlpMHeel3PZwbhhASBGAKZVycve2o2tzRaOusdHVUVvObMud2SsvUYCr/vmfx9Ok\\nQG2MfC7qNG/MTGUZoOotXr+5mcLJgtWggdN401Sx5QGhyq6cBJLai6lSk0gQiHYW\\nAModZ0k3DcfTZ1CN/LS0Wr+lwjjTdyo8BK1A48sCgYEA6BnmWhpu3Db2iKA9toe+\\n2XeimNpRRf7UrmCevBzijTd8Db5WF2rI4DL2spXWZWzvq8wNSYMfIwnHCDUHHNQd\\nyAjSVMOOg850kRq8PnNCkrbUKbwk5dulaZIUVmzzBSJSZHcsQP6iZ5AKmF11Xblh\\nP5Xtk/WJqnxpdqJTW+toqyI=\\n-----END PRIVATE KEY-----\\n\",\n" +
                    "  \"client_email\": \"firebase-adminsdk-an4sh@carrentalservice-faa64.iam.gserviceaccount.com\",\n" +
                    "  \"client_id\": \"108477017716537072748\",\n" +
                    "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
                    "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
                    "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                    "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-an4sh%40carrentalservice-faa64.iam.gserviceaccount.com\",\n" +
                    "  \"universe_domain\": \"googleapis.com\"\n" +
                    "}\n"

            val stream: InputStream = ByteArrayInputStream(jsonString.toByteArray(StandardCharsets.UTF_8))
            val googleCredentials: GoogleCredentials = GoogleCredentials.fromStream(stream).createScoped(Lists.newArrayList(
                firebaseMessagingScope
            ))
            googleCredentials.refresh()

            return googleCredentials.accessToken.tokenValue
        }catch (exception: IOException){
            return  ""
        }
    }
}