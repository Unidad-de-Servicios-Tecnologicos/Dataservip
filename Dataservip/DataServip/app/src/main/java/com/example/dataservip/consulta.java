package com.example.dataservip;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dataservip.modelos.Vehiculo;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class consulta extends AppCompatActivity {

    private EditText placaEditText;
    private Button consultarButton;
    private ApiService apiService;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_consulta);

        placaEditText = findViewById(R.id.txtplaca);

        consultarButton = findViewById(R.id.btnconsultar);

        apiService = RetrofitClient.getClient();

        consultarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String placa = placaEditText.getText().toString();

                if (TextUtils.isEmpty(placa)) {
                    Toast.makeText(consulta.this, "Ingresa una placa válida", Toast.LENGTH_SHORT).show();
                } else {
                    realizarConsulta(placa);
                }
            }
        });
    }
    private void realizarConsulta(String placa) {
        Call<Vehiculo> call = apiService.realizarConsulta(placa);

        call.enqueue(new Callback<Vehiculo>() {
            @Override
            public void onResponse(Call<Vehiculo> call, Response<Vehiculo> response) {
                if (response.isSuccessful()) {
                    Vehiculo vehiculo = response.body();
                    if (vehiculo != null) {
                        abrirActividadDatos(vehiculo);
                    } else {
                        Toast.makeText(consulta.this, "Datos del vehículo nulos", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(consulta.this, "Error en la respuesta de la API", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<Vehiculo> call, Throwable t) {
                Toast.makeText(consulta.this, "Error al realizar la llamada a la API", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void abrirActividadDatos(Vehiculo vehiculo) {
        Intent intent = new Intent(consulta.this, Datos.class);
        intent.putExtra("vehiculo", vehiculo);
        startActivity(intent);
    }


}