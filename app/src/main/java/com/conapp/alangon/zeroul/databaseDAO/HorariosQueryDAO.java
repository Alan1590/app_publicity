package com.conapp.alangon.zeroul.databaseDAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.conapp.alangon.zeroul.model.ModelHorarios;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan Gon on 12/02/2018.
 */

@Dao
public interface HorariosQueryDAO {
    @Query("Select * from EntidadHorario")
    public List<ModelHorarios> loadAll();

    @Query("Select * from EntidadHorario where fecha_prox_act=:fechaAct")
    public boolean isActualizar(String fechaAct);

    @Query("Select Count(*) from EntidadHorario")
    public int getNumElement();
}
