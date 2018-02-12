package com.conapp.alangon.zeroul

import android.app.NotificationChannel
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.TaskStackBuilder
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import android.app.PendingIntent
import android.content.Context.NOTIFICATION_SERVICE
import android.app.NotificationManager
import android.arch.persistence.room.Room
import android.arch.persistence.room.Room.databaseBuilder
import android.arch.persistence.room.RoomDatabase
import android.content.*
import android.content.pm.PackageManager
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.app.NotificationCompat
import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text
import android.net.ConnectivityManager
import com.conapp.alangon.zeroul.broadcast.Notificacion
import com.conapp.alangon.zeroul.databaseDAO.DatabasePublicidad
import com.conapp.alangon.zeroul.databaseDAO.EntidadHorario
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var mAdView : AdView
    internal var CHANNEL_ID = "my_channel_01"
    val broadCastService = Notificacion()


    private val fechaActual = (Calendar.getInstance().get(Calendar.DAY_OF_MONTH).toString()
            + "/" + Calendar.getInstance().get(Calendar.MONTH + 1)
            + "/" + Calendar.getInstance().get(Calendar.YEAR))

    private val fechaPrxAct = (Calendar.getInstance().get(Calendar.DAY_OF_MONTH+1).toString()
            + "/" + Calendar.getInstance().get(Calendar.MONTH + 1)
            + "/" + Calendar.getInstance().get(Calendar.YEAR))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView : TextView = findViewById(R.id.txtView);
        setService()
        createDB()
        blockApp()
    }


    private fun createDB(){
        val thread = Thread(Runnable {
            val databasePublicidad = Room.databaseBuilder(this, DatabasePublicidad::class.java,
                    "Zeroul").build()
            val numElementos = databasePublicidad.horariosQueryDAO().numElement
            if(numElementos==0){
                val entidadHorarios = EntidadHorario()
                entidadHorarios.dateUltAct=fechaActual
                entidadHorarios.dateProxAct=fechaPrxAct
                databasePublicidad.horariosInsertDAO().insertarHorarioProxVista(entidadHorarios)
                Log.d("Crear","Se crea la base de datos")
            }
        })
        thread.start()

    }



    private fun setService(){

        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        filter.addAction(Intent.ACTION_USER_UNLOCKED)
        filter.addAction(Intent.ACTION_BOOT_COMPLETED)
        filter.addAction(Intent.ACTION_POWER_CONNECTED)
        filter.addAction(Intent.ACTION_SCREEN_OFF)
        filter.addAction(Intent.ACTION_SCREEN_ON)
        this.registerReceiver(broadCastService,filter)
    }

    fun blockApp(){
         val p:PackageManager = getPackageManager();
         val componentName = ComponentName(this, com.conapp.alangon.zeroul.MainActivity::class.java)
         p.setComponentEnabledSetting(componentName,PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
    }
}

