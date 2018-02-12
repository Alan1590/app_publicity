package com.conapp.alangon.zeroul.model;

/**
 * Created by Alan Gon on 12/02/2018.
 */

public class ModelHorarios {
    private int id;
    private String fecha_actual, fecha_prox_act;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_actual() {
        return fecha_actual;
    }

    public void setFecha_actual(String fecha_actual) {
        this.fecha_actual = fecha_actual;
    }

    public String getFecha_prox_act() {
        return fecha_prox_act;
    }

    public void setFecha_prox_act(String fecha_prox_act) {
        this.fecha_prox_act = fecha_prox_act;
    }
}
