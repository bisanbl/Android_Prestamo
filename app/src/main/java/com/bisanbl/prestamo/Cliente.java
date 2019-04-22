package com.bisanbl.prestamo;

import android.os.Parcel;
import android.os.Parcelable;

class Cliente implements Parcelable {
    String Nombre;
    String Apellido;
    String Sexo;
    String Telefono;
    String Cedula;
    String Direccion;
    String Ocupacion;

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getSexo() {
        return Sexo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getCedula() {
        return Cedula;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getOcupacion() {
        return Ocupacion;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public void setOcupacion(String ocupacion) {
        Ocupacion = ocupacion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Nombre);
        dest.writeString(Apellido);
        dest.writeString(Sexo);
        dest.writeString(Telefono);
        dest.writeString(Cedula);
        dest.writeString(Direccion);
        dest.writeString(Ocupacion);

    }

    public void readFromParcel(Parcel in){
        Nombre = in.readString();
        Apellido = in.readString();
        Sexo = in.readString();
        Telefono = in.readString();
        Cedula = in.readString();
        Direccion = in.readString();
        Ocupacion = in.readString();
    }

    public Cliente(){

    }

    public Cliente(Parcel in){
        readFromParcel(in);
    }

    public  static  final  Parcelable.Creator<Cliente> CREATOR = new Parcelable.Creator<Cliente>(){
        public Cliente createFromParcel(Parcel in){
            return new Cliente(in);
        }

        public Cliente[] newArray (int size){
            return new Cliente[size];
        }
    };
}

