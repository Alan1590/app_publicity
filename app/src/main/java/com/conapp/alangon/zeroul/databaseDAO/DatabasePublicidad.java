package com.conapp.alangon.zeroul.databaseDAO;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.util.Log;

/**
 * Created by Alan Gon on 12/02/2018.
 */

@Database(version = 1,entities = {EntidadHorario.class})
public abstract class DatabasePublicidad  extends RoomDatabase{
    abstract public HorariosInsertDAO horariosInsertDAO();
    public abstract HorariosQueryDAO horariosQueryDAO();
    public abstract HorariosDeleteDAO horariosDeleteDAO();
}
