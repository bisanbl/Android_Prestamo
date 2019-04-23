package com.bisanbl.prestamo;

import android.os.Parcel;
import android.os.Parcelable;

class Cliente implements Parcelable {
    private String Nombre;
    private String Apellido;
    private String Sexo;
    private String Telefono;
    private String Cedula;
    private String Direccion;
    private String Ocupacion;

    String getNombre() {
        return Nombre;
    }

    String getApellido() {
        return Apellido;
    }

    String getSexo() {
        return Sexo;
    }

    String getTelefono() {
        return Telefono;
    }

    String getCedula() {
        return Cedula;
    }

    String getDireccion() {
        return Direccion;
    }

    String getOcupacion() {
        return Ocupacion;
    }

    void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    void setApellido(String apellido) {
        this.Apellido = apellido;
    }

    void setSexo(String sexo) {
        this.Sexo = sexo;
    }

    void setTelefono(String telefono) {
        this.Telefono = telefono;
    }

    void setDireccion(String direccion) {
        this.Direccion = direccion;
    }

    void setCedula(String cedula) {
        this.Cedula = cedula;
    }

    void setOcupacion(String ocupacion) {
        this.Ocupacion = ocupacion;
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

    private void readFromParcel(Parcel in){
        Nombre = in.readString();
        Apellido = in.readString();
        Sexo = in.readString();
        Telefono = in.readString();
        Cedula = in.readString();
        Direccion = in.readString();
        Ocupacion = in.readString();
    }

    Cliente(){

    }

    private Cliente(Parcel in){
        readFromParcel(in);
    }

    public  static  final  Creator<Cliente> CREATOR = new Creator<Cliente>(){
        public Cliente createFromParcel(Parcel in){
            return new Cliente(in);
        }

        public Cliente[] newArray (int size){
            return new Cliente[size];
        }
    };
}

