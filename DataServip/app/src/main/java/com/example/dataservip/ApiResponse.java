package com.example.dataservip;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {
    private int code;
    private String message;
    private Data data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private List<Vehiculo> vehiculos;

        public List<Vehiculo> getVehiculos() {
            return vehiculos;
        }

        public void setVehiculos(List<Vehiculo> vehiculos) {
            this.vehiculos = vehiculos;
        }
    }

    public static class Vehiculo {
        private String placa;
        private String interno;
        private String razon_social_empresa;
        private String direccion_empresa;
        private String telefono_empresa;
        private String foto;
        private String estado;
        private List<Documento> documentos;
        private List<Conductor> conductores;
        private String modalidad;

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

        public String getRazon_social_empresa() {
            return razon_social_empresa;
        }

        public void setRazon_social_empresa(String razon_social_empresa) {
            this.razon_social_empresa = razon_social_empresa;
        }

        public String getDireccion_empresa() {
            return direccion_empresa;
        }

        public void setDireccion_empresa(String direccion_empresa) {
            this.direccion_empresa = direccion_empresa;
        }

        public String getTelefono_empresa() {
            return telefono_empresa;
        }

        public void setTelefono_empresa(String telefono_empresa) {
            this.telefono_empresa = telefono_empresa;
        }

        public String getFoto() {
            return foto;
        }

        public void setFoto(String foto) {
            this.foto = foto;
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
    }

    public static class Documento {
        private String tipo_documento;
        private String estado;

        public String getTipo_documento() {
            return tipo_documento;
        }

        public void setTipo_documento(String tipo_documento) {
            this.tipo_documento = tipo_documento;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
    }

    public static class Conductor {
        private String foto;
        private String nombre;
        private String categoria_licencia;
        private String vencimiento_licencia;
        private String grupo_sanguineo;
        private String eps;
        private String arl;
        private String pensiones;

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

        public String getCategoria_licencia() {
            return categoria_licencia;
        }

        public void setCategoria_licencia(String categoria_licencia) {
            this.categoria_licencia = categoria_licencia;
        }

        public String getVencimiento_licencia() {
            return vencimiento_licencia;
        }

        public void setVencimiento_licencia(String vencimiento_licencia) {
            this.vencimiento_licencia = vencimiento_licencia;
        }

        public String getGrupo_sanguineo() {
            return grupo_sanguineo;
        }

        public void setGrupo_sanguineo(String grupo_sanguineo) {
            this.grupo_sanguineo = grupo_sanguineo;
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
    }


    public class ConsultarVehiculo {
        @SerializedName("placa")
        private String placa;

        public String getPlaca() {
            return placa;
        }
    }


}
