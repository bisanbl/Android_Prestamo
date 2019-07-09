package com.bisanbl.prestamo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;
import static android.arch.persistence.room.ForeignKey.RESTRICT;

@Entity(foreignKeys = @ForeignKey(entity = Clase.class,
        childColumns = "id_Cliente",
        parentColumns = "_ id",
        onDelete = CASCADE,
        onUpdate = RESTRICT))
public class Prestamo  {

    private float monto;
    private float interes;
    private int plazo;
    private String fechainicio;
    private String fechafin;
    private float total;
    private float cuota;
    private int id_Cliente;



    float getMonto(){
        return monto;
    }

    float getInteres(){
        return interes;
    }

    int getPlazo(){
        return plazo;
    }

    String getFechainicio(){
        return fechainicio;
    }
    String getFechafin(){
        return fechafin;
    }

    float getTotal(){
        return total;
    }

    float getCuota(){
        return cuota;
    }

    void setMonto(float monto){
        this.monto = monto;
    }

    void setInteres(float interes){
        this.interes = interes;
    }

    void setPlazo(int plazo){
        this.plazo = plazo;
    }

    void setFechainicio(String fechainicio){
        this.fechainicio = fechainicio;
    }

    void setFechafin(String fechafin){
        this.fechafin = fechafin;
    }

    void setTotal(float total){
        this.total = total;
    }

    void setCuota(float cuota){
        this.cuota = cuota;
    }

    Prestamo(){

    }


}
