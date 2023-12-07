package com.example.dataservip.modelos;

import android.os.Parcel;
import android.os.Parcelable;

public class Conductor implements Parcelable {
    private String foto;
    private String nombre;
    private String categoriaLicencia;
    private String vencimientoLicencia;
    private String grupoSanguineo;
    private String eps;
    private String arl;
    private String pensiones;

    // Constructor
    public Conductor(String foto, String nombre, String categoriaLicencia, String vencimientoLicencia,
                     String grupoSanguineo, String eps, String arl, String pensiones) {
        this.foto = foto;
        this.nombre = nombre;
        this.categoriaLicencia = categoriaLicencia;
        this.vencimientoLicencia = vencimientoLicencia;
        this.grupoSanguineo = grupoSanguineo;
        this.eps = eps;
        this.arl = arl;
        this.pensiones = pensiones;
    }

    // Métodos necesarios para Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(foto);
        dest.writeString(nombre);
        dest.writeString(categoriaLicencia);
        dest.writeString(vencimientoLicencia);
        dest.writeString(grupoSanguineo);
        dest.writeString(eps);
        dest.writeString(arl);
        dest.writeString(pensiones);
    }

    // Métodos getters y setters
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoriaLicencia() {
        return categoriaLicencia;
    }

    public void setCategoriaLicencia(String categoriaLicencia) {
        this.categoriaLicencia = categoriaLicencia;
    }

    public String getVencimientoLicencia() {
        return vencimientoLicencia;
    }

    public void setVencimientoLicencia(String vencimientoLicencia) {
        this.vencimientoLicencia = vencimientoLicencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getArl() {
        return arl;
    }

    public void setArl(String arl) {
        this.arl = arl;
    }

    public String getPensiones() {
        return pensiones;
    }

    public void setPensiones(String pensiones) {
        this.pensiones = pensiones;
    }

    // Constructor privado para Parcelable
    private Conductor(Parcel in) {
        foto = in.readString();
        nombre = in.readString();
        categoriaLicencia = in.readString();
        vencimientoLicencia = in.readString();
        grupoSanguineo = in.readString();
        eps = in.readString();
        arl = in.readString();
        pensiones = in.readString();
    }

    public static final Creator<Conductor> CREATOR = new Creator<Conductor>() {
        @Override
        public Conductor createFromParcel(Parcel in) {
            return new Conductor(in);
        }

        @Override
        public Conductor[] newArray(int size) {
            return new Conductor[size];
        }
    };
}
