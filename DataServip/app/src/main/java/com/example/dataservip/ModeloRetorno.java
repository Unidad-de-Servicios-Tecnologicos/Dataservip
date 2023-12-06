package com.example.dataservip;

public class ModeloRetorno {
    private String placa;
    private String interno;
    private String razon_social_empresa;
    private String direccion_empresa;
    private String telefono_empresa;
    private String tipo_documento;
    private String estado;

    public String getPlaca(){return placa;}
    public void setPlaca(String placa){this.placa = placa;}


    public String getInterno(){return interno;}
    public void setInterno(String interno){this.interno = interno;}


    public String getRazon_social_empresa(){return razon_social_empresa;}
    public void setRazon_social_empresa(String razon_social_empresa){this.razon_social_empresa = razon_social_empresa;}

    public String getDireccion_empresa(){return direccion_empresa;}
    public void setDireccion_empresa(String direccion_empresa){this.direccion_empresa = direccion_empresa;}

    public String getTelefono_empresa(){return telefono_empresa;}
    public void setTelefono_empresa(String telefono_empresa){this.telefono_empresa = telefono_empresa;}


    public String getTipo_documento(){return tipo_documento;}
    public void setTipo_documento(String tipo_documento){this.tipo_documento = tipo_documento;}


    public String getEstado(){return estado;}
    public void setEstado(String estado){this.estado = estado;}

}
