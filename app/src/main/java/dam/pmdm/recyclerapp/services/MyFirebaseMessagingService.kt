package dam.pmdm.recyclerapp.services

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dam.pmdm.recyclerapp.utils.NotificationHelper

class MyFirebaseMessagingService : FirebaseMessagingService() {
    private val notificationHelper by lazy { NotificationHelper(this) }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // Aquí puedes manejar los datos y la notificación
        val title = remoteMessage.notification?.title ?: "Nueva Notificación"
        val message = remoteMessage.notification?.body ?: "Tienes un nuevo mensaje."

        // Mostrar la notificación utilizando NotificationHelper
        notificationHelper.showGameNotification(title, message)
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("FCM Token", "Token: $token")
    }
}