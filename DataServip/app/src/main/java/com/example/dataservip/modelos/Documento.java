package com.example.dataservip.modelos;

import android.os.Parcel;
import android.os.Parcelable;

public class Documento implements Parcelable {
    private String tipoDocumento;
    private String estado;

    public Documento(String tipoDocumento, String estado) {
        this.tipoDocumento = tipoDocumento;
        this.estado = estado;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Métodos necesarios para Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tipoDocumento);
        dest.writeString(estado);
    }

    // Constructor privado para Parcelable
    private Documento(Parcel in) {
        tipoDocumento = in.readString();
        estado = in.readString();
    }

    public static final Creator<Documento> CREATOR = new Creator<Documento>() {
        @Override
        public Documento createFromParcel(Parcel in) {
            return new Documento(in);
        }

        @Override
        public Documento[] newArray(int size) {
            return new Documento[size];
        }
    };
}
