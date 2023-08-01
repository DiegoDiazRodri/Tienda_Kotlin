package com.example.tiendakotlin.components

import android.Manifest
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.tiendakotlin.components.NotificacionProgramada.Companion.NOTIFICATION_ID
import com.example.tiendakotlin.MainActivity
import com.example.tiendakotlin.R
import java.util.Calendar

fun CreateChannelNotification(
    idChannel: String,
    context: Context,
    name: String,
    descriptionText: String
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

        val importance = NotificationManager.IMPORTANCE_DEFAULT
        //Definicion del canal
        val channel = NotificationChannel(
            idChannel,
            name,
            importance
        ).apply {
            description = descriptionText
        }

        //Definicion del gestor de notificaciones
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //Creacion del Canal
        notificationManager.createNotificationChannel(channel)

    }
}

fun notificacionSencilla(
    context: Context,
    idChannel: String,
    idNotification: Int,
    textTitle: String,
    textContent: String,
    priority: Int = NotificationCompat.PRIORITY_DEFAULT
) {

    val intent = Intent(
        context,
        MainActivity::class.java
    ).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    val pendingIntent: PendingIntent = PendingIntent.getActivity(
        context,
        0,
        intent,
        PendingIntent.FLAG_IMMUTABLE
    )

    val builder = NotificationCompat.Builder(
        context,
        idChannel
    )
        .setSmallIcon(R.drawable.baseline_add_alert_24)
        .setContentTitle(textTitle)
        .setContentText(textContent)
        .setPriority(priority)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .build()

    with(NotificationManagerCompat.from(context)) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //  ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int [] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            //for ActivityCompat#requestPermissions for more details.
            return
        }
        notify(idNotification, builder)
    }
}

fun notificacionExtensa(
    context: Context,
    idChannel: String,
    idNotification: Int,
    textTitle: String,
    textContent: String,
    bigIcono: Bitmap,
    priority: Int = NotificationCompat.PRIORITY_DEFAULT
) {

    var builder = NotificationCompat.Builder(context, idChannel)
        .setSmallIcon(R.drawable.baseline_add_alert_24)
        .setContentTitle(textTitle)
        .setContentText(textContent)
        .setLargeIcon(bigIcono) 
        .setStyle(
            NotificationCompat.BigTextStyle()
                .bigText(textContent)
        )
        .setPriority(priority)
        .build()

    with(NotificationManagerCompat.from(context)) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //  ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int [] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            //for ActivityCompat#requestPermissions for more details.
            return
        }
        notify(idNotification, builder)
    }
}

fun notificacionImagen(
    context: Context,
    idChannel: String,
    idNotification: Int,
    textTitle: String,
    textContent: String,
    bigImagen: Bitmap,
    priority: Int = NotificationCompat.PRIORITY_DEFAULT
) {

    val intent = Intent(
        context,
        MainActivity::class.java
    ).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    val pendingIntent: PendingIntent = PendingIntent.getActivity(
        context,
        0,
        intent,
        PendingIntent.FLAG_IMMUTABLE
    )

    val builder = NotificationCompat.Builder(
        context,
        idChannel
    )
        .setSmallIcon(R.drawable.baseline_add_alert_24)
        .setContentTitle(textTitle)
        .setContentText(textContent)
        .setStyle(
            NotificationCompat
                .BigPictureStyle()
                .bigPicture(bigImagen)
                .setBigContentTitle("Tienda sena CBA")
        )
        .setPriority(priority)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .build()

    with(NotificationManagerCompat.from(context)) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //  ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int [] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            //for ActivityCompat#requestPermissions for more details.
            return
        }
        notify(idNotification, builder)
    }
}

fun notificacionProgramada(context: Context) {
    val intent = Intent(context, NotificacionProgramada::class.java)
    val pendingIntent = PendingIntent.getBroadcast(
        context,
        NOTIFICATION_ID,
        intent,
        PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
    )

    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    alarmManager.setExact(
        AlarmManager.RTC_WAKEUP,
        Calendar.getInstance().timeInMillis + 5000,
        pendingIntent
    )
}
