package com.conapp.alangon.zeroul.databaseDAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

/**
 * Created by Alan Gon on 12/02/2018.
 */

@Dao
public interface HorariosInsertDAO {

    @Insert
    public void insertarHorarioProxVista(EntidadHorario entidadHorario);
}
