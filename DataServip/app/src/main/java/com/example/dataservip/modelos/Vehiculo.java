package com.example.dataservip.modelos;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class Vehiculo implements Parcelable {
    private String placa;
    private String interno;
    private String razonSocialEmpresa;
    private String direccionEmpresa;
    private String telefonoEmpresa;
    private String estado;
    private List<Documento> documentos;
    private List<Conductor> conductores;
    private String modalidad;

    // Constructor
    public Vehiculo(String placa, String interno, String razonSocialEmpresa, String direccionEmpresa, String telefonoEmpresa,
                    String estado, List<Documento> documentos, List<Conductor> conductores, String modalidad) {
        this.placa = placa;
        this.interno = interno;
        this.razonSocialEmpresa = razonSocialEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.estado = estado;
        this.documentos = documentos;
        this.conductores = conductores;
        this.modalidad = modalidad;
    }
    // Getters, setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getInterno() {
        return interno;
    }

    public void setInterno(String interno) {
        this.interno = interno;
    }

    public String getRazonSocialEmpresa() {
        return razonSocialEmpresa;
    }

    public void setRazonSocialEmpresa(String razonSocialEmpresa) {
        this.razonSocialEmpresa = razonSocialEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public List<Conductor> getConductores() {
        return conductores;
    }

    public void setConductores(List<Conductor> conductores) {
        this.conductores = conductores;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // Métodos necesarios para Parcelable
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(placa);
        dest.writeString(interno);
        dest.writeString(razonSocialEmpresa);
        dest.writeString(direccionEmpresa);
        dest.writeString(telefonoEmpresa);
        dest.writeString(estado);
        dest.writeTypedList(documentos);
        dest.writeTypedList(conductores);
        dest.writeString(modalidad);
    }

    // Constructor privado para Parcelable
    private Vehiculo(Parcel in) {
        placa = in.readString();
        interno = in.readString();
        razonSocialEmpresa = in.readString();
        direccionEmpresa = in.readString();
        telefonoEmpresa = in.readString();
        estado = in.readString();
        documentos = in.createTypedArrayList(Documento.CREATOR);
        conductores = in.createTypedArrayList(Conductor.CREATOR);
        modalidad = in.readString();
    }

    public static final Creator<Vehiculo> CREATOR = new Creator<Vehiculo>() {
        @Override
        public Vehiculo createFromParcel(Parcel in) {
            return new Vehiculo(in);
        }

        @Override
        public Vehiculo[] newArray(int size) {
            return new Vehiculo[size];
        }
    };

}

