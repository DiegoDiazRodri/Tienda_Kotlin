package com.example.tiendakotlin.components

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.tiendakotlin.MainActivity
import com.example.tiendakotlin.R
import com.example.tiendakotlin.utils.Constants.channelId

class NotificacionProgramada : BroadcastReceiver() {
    companion object {
        const val NOTIFICATION_ID = 5
    }

    override fun onReceive(context: Context, intent: Intent?) {
        crearNotification(context)
        notificacionProgramada(context)
    }

    private fun crearNotification(context: Context) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val flag = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            PendingIntent.FLAG_IMMUTABLE else 0
        val pendingIntent : PendingIntent = PendingIntent.getActivity(context, 0,intent,flag)
        val notification = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.baseline_add_alert_24)
            .setContentTitle("Notificacion Programada")
            .setContentText("Saludos! Aprendiendo a programar notificaciones")
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText(
                        "Saludos esta es una prueba de notificacion" +
                                "Programada; aparece despues de un tiempo,"
                    )
            )
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .build()

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager
        manager.notify(NOTIFICATION_ID, notification)
    }
}

