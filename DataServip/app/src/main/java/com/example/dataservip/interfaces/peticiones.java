package com.example.dataservip.interfaces;

import com.example.dataservip.consulta;
import com.example.dataservip.dataservip;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface peticiones {
    @GET("json_vehiculo_qr.php?placa=FXU925/{id}")
    Call<dataservip> consultar(@Path("id") String id);
}