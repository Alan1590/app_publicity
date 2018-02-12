package com.conapp.alangon.zeroul.databaseDAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;

/**
 * Created by Alan Gon on 12/02/2018.
 */

@Dao
public interface HorariosDeleteDAO {
    @Delete
    public void deleteAll(EntidadHorario entidadHorario);
}
