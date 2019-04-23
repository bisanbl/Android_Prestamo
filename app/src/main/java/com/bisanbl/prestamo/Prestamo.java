package com.bisanbl.prestamo;

import android.os.Parcel;
import android.os.Parcelable;

public class Prestamo implements Parcelable {

    private float monto;
    private float interes;
    private int plazo;
    private String fechainicio;
    private String fechafin;
    private float total;
    private float cuota;



    Float getMonto(){
        return monto;
    }

    Float getInteres(){
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

    public Prestamo(float monto, float interes, int plazo, String fechainicio, String fechafin, float total, float cuota) {
        this.monto = monto;
        this.interes = interes;
        this.plazo = plazo;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.total = total;
        this.cuota = cuota;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(monto);
        dest.writeFloat(interes);
        dest.writeInt(plazo);
        dest.writeString(fechainicio);
        dest.writeString(fechafin);
        dest.writeFloat(total);
        dest.writeFloat(cuota);

    }

    private void readFromParcel(Parcel in){
        monto = in.readFloat();
        interes = in.readFloat();
        plazo = in.readInt();
        fechainicio = in.readString();
        fechafin = in.readString();
        total = in.readFloat();
        cuota = in.readFloat();
    }

    public Prestamo(Parcel in) {
        readFromParcel(in);
    }

    public  static  final  Creator<Prestamo> CREATOR = new Creator<Prestamo>(){
        public Prestamo createFromParcel(Parcel in){
            return new Prestamo(in);
        }

        public Prestamo[] newArray (int size){
            return new Prestamo[size];
        }
    };
}
