package com.bisanbl.prestamo.obj;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
class Cliente  {
    @PrimaryKey(autoGenerate = true)
    private  int _id;
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

    Cliente(){

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}

