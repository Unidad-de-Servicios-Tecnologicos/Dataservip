package com.example.dataservip;
import com.example.dataservip.modelos.Vehiculo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("json_vehiculo_qr.php")
    Call<Vehiculo> consultarVehiculo(String placa);
}


//import retrofit2.Call;
//import retrofit2.http.GET;
//import retrofit2.http.Path;
//
//public interface ApiService {
//    @GET("ruta/del/endpoint/{placa}")
//    Call<Vehiculo> obtenerInformacionConductor(@Path("placa") String placa);
//}