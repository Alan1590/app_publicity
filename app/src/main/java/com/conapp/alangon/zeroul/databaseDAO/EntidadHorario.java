package com.conapp.alangon.zeroul.databaseDAO;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by Alan Gon on 12/02/2018.
 */

@Entity
public class EntidadHorario {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "fecha_actual")
    String dateUltAct;
    @ColumnInfo(name = "fecha_prox_act")
    String dateProxAct;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateUltAct() {
        return dateUltAct;
    }

    public void setDateUltAct(String dateUltAct) {
        this.dateUltAct = dateUltAct;
    }

    public String getDateProxAct() {
        return dateProxAct;
    }

    public void setDateProxAct(String dateProxAct) {
        this.dateProxAct = dateProxAct;
    }
}
