package com.example.dataservip;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://grupoempresarialdts.com/";
    private static Retrofit retrofit = null;

    public static ApiService getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://grupoempresarialdts.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
//        return retrofit.create(ApiService.class);
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService;
    }
}


