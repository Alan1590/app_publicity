package com.conapp.alangon.zeroul.broadcast;

import android.arch.persistence.room.Room;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.widget.Toast;

import com.conapp.alangon.zeroul.AdmobPublicity;
import com.conapp.alangon.zeroul.databaseDAO.DatabasePublicidad;
import com.conapp.alangon.zeroul.databaseDAO.EntidadHorario;

import java.util.Calendar;

/**
 * Created by Alan Gon on 11/02/2018.
 */

public class Notificacion extends BroadcastReceiver{
    private boolean mostrarAct;
    private Context ctx;

    private String fechaActual = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
            + "/" + Calendar.getInstance().get(Calendar.MONTH + 1)
            + "/" + Calendar.getInstance().get(Calendar.YEAR);
    private String fechaPrxAct = Calendar.getInstance().get(Calendar.DAY_OF_MONTH+1)
            + "/" + Calendar.getInstance().get(Calendar.MONTH + 1)
            + "/" + Calendar.getInstance().get(Calendar.YEAR);
    DatabasePublicidad databasePublicidad;

    @Override
    public void onReceive(final Context context, Intent intent) {
        this.ctx = context;
        databasePublicidad = Room.databaseBuilder(ctx, DatabasePublicidad.class,
                "Test").build();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                mostrarAct = databasePublicidad.horariosQueryDAO().isActualizar(fechaPrxAct);
                if(mostrarAct){
                    EntidadHorario entidadHorario = new EntidadHorario();
                    entidadHorario.setDateUltAct(fechaActual);
                    entidadHorario.setDateProxAct(fechaPrxAct);
                    databasePublicidad.horariosInsertDAO().insertarHorarioProxVista(entidadHorario);
                    AdmobPublicity admobPublicity = new AdmobPublicity(ctx);
                }else{
                    Log.d("Publicidad","No mostrar publicidad");
                }
            }
        });
        thread.start();

    }
}
