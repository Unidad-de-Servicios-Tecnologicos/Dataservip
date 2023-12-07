package com.example.dataservip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dataservip.modelos.Vehiculo;

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

        // Inicializar vistas (asegúrate de que los IDs coincidan)
        placaEditText = findViewById(R.id.txtplaca);
        consultarButton = findViewById(R.id.btnconsultar);

        // Obtener la instancia de ApiService utilizando Retrofit
        apiService = RetrofitClient.getClient();

        // Configurar el evento de clic del botón
        consultarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener la placa ingresada por el usuario
                String placa = placaEditText.getText().toString();

                // Validar que se haya ingresado una placa
                if (placa.isEmpty()) {
                    Toast.makeText(consulta.this, "Ingresa una placa válida", Toast.LENGTH_SHORT).show();
                } else {
                    // Realizar la consulta a la API con la placa ingresada
                    realizarConsulta(placa);
                }
            }
        });
    }

    private void realizarConsulta(String placa) {
        // Aquí realizas la llamada a la API utilizando Retrofit

        Call<Vehiculo> call = apiService.consultarVehiculo(placa);

        call.enqueue(new Callback<Vehiculo>() {
            @Override
            public void onResponse(Call<Vehiculo> call, Response<Vehiculo> response) {
                if (response.isSuccessful()) {
                    // Llamada exitosa, abres la actividad de datos y pasas los datos del vehículo
                    Vehiculo vehiculo = response.body();
                    abrirActividadDatos(vehiculo);
                } else {
                    // Llamada no exitosa, manejas el error y muestras un mensaje al usuario
                    Toast.makeText(consulta.this, "Error en la respuesta de la API", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Vehiculo> call, Throwable t) {
                // Fallo en la llamada, manejas el error y muestras un mensaje al usuario
                Toast.makeText(consulta.this, "Error al realizar la llamada a la API", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void abrirActividadDatos(Vehiculo vehiculo) {
        // Crear un intent para abrir la actividad de datos
        Intent intent = new Intent(consulta.this, Datos.class);

        // Puedes pasar los datos del vehículo como extras en el intent
        intent.putExtra("vehiculo", vehiculo);

        // Iniciar la actividad de datos
        startActivity(intent);
    }

    public static class ApiClient {
        private ApiService apiService;

        // Constructor u otros métodos de inicialización según tus necesidades
        public ApiClient() {
            // Configurar Retrofit y obtener la instancia de ApiService
            apiService = RetrofitClient.getClient();
        }

        public void obtenerDatos(final ApiCallback<Vehiculo> callback) {
            // Utilizar Retrofit para realizar la llamada a la API
            String placa = null;
            Call<Vehiculo> call = apiService.consultarVehiculo(placa);

            call.enqueue(new Callback<Vehiculo>() {
                @Override
                public void onResponse(Call<Vehiculo> call, Response<Vehiculo> response) {
                    if (response.isSuccessful()) {
                        // Llamada exitosa, llamar al método onSuccess del callback
                        callback.onSuccess(response.body());
                    } else {
                        // Llamada no exitosa, manejar el error y llamar al método onFailure del callback
                        callback.onFailure("Error en la respuesta de la API");
                    }
                }

                @Override
                public void onFailure(Call<Vehiculo> call, Throwable t) {
                    // Fallo en la llamada, manejar el error y llamar al método onFailure del callback
                    callback.onFailure("Error al realizar la llamada a la API");
                }
            });
        }
    }
}