package com.bisanbl.prestamo;

import android.os.Parcel;
import android.os.Parcelable;

public class VerPrestamo extends Prestamo implements Parcelable {

    private String name;
    private String lastname;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    private void readFromParcel(Parcel in){
        name = in.readString();
        lastname = in.readString();

    }


    public VerPrestamo(Parcel in) {
        super(in);
        readFromParcel(in);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(name);
        dest.writeString(lastname);
    }


    VerPrestamo() {
        super();
    }

    public  static  final  Creator<VerPrestamo> CREATOR = new Creator<VerPrestamo>(){
        public VerPrestamo createFromParcel(Parcel in){
            return new VerPrestamo(in);
        }

        public VerPrestamo[] newArray (int size){
            return new VerPrestamo[size];
        }
    };
}
