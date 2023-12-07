package com.example.dataservip;

import com.example.dataservip.interfaces.peticiones;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class consultarApi {
    public static String URL = "https://grupoempresarialdts.com/appdataservip/";
    public static Retrofit varRetro;
    ModeloRetorno modeloRetorno = new ModeloRetorno();
    public String res;
    public void respuesta(String placa){
        varRetro = new Retrofit.Builder().baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        peticiones consApi = varRetro.create(peticiones.class);

        Call<dataservip> call = consApi.consultar(placa);
        call.enqueue(new Callback<dataservip>() {
            @Override
            public void onResponse(Call<dataservip> call, Response<dataservip> response) {
            try {
                if (response.isSuccessful()) {
                    dataservip dataservip = response.body();
                    modeloRetorno.setPlaca(dataservip.getPlaca());
                    modeloRetorno.setInterno(dataservip.getInterno());
                    modeloRetorno.setRazon_social_empresa(dataservip.getRazon_social_empresa());
                    modeloRetorno.setDireccion_empresa(dataservip.getDireccion_empresa());
                    modeloRetorno.setTelefono_empresa(dataservip.getTelefono_empresa());
                    modeloRetorno.setTipo_documento(dataservip.getTipo_documento());
                    modeloRetorno.setEstado(dataservip.getEstado());
                } else {
                    System.out.println("Mal");
                    System.out.println(call);
                }
            } catch (Exception ex) {
                System.out.println("Epalarepa't" + ex);
            }
            }

            @Override
            public void onFailure(Call<dataservip> call, Throwable t) {
                System.out.println("Hola: " + t);
            }
        });


    }
}
