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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        // Inicializar vistas (asegúrate de que los IDs coincidan)
        placaEditText = findViewById(R.id.txtplaca);
        consultarButton = findViewById(R.id.btnconsultar);


        // Configurar el evento de clic del botón
        consultarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener la placa ingresada por el usuario
                String placa = placaEditText.getText().toString();

                // Validar que se haya ingresado una pla
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
        // Aquí podrías realizar la llamada a la API para obtener los datos del vehículo según la placa
        // Puedes utilizar la clase ApiClient y el callback que definimos antes

        ApiClient apiClient = new ApiClient();

        apiClient.obtenerDatos(placa, new ApiCallback<Vehiculo>() {
            @Override
            public void onSuccess(Vehiculo vehiculo) {
                // Abrir la actividad de datos y pasar los datos del vehículo
                abrirActividadDatos(vehiculo);
            }

            @Override
            public void onFailure(String mensajeError) {
                // Manejar el error, mostrar un mensaje al usuario, etc.
                Toast.makeText(consulta.this, "Error al obtener datos: " + mensajeError, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void abrirActividadDatos(Vehiculo vehiculo) {
        // Crear un intent para abrir la actividad de datos
        Intent intent = new Intent(consulta.this, Datos.class);

        // Puedes pasar los datos del vehículo como extras en el intent
        // Aquí asumo que Vehiculo implementa Serializable, pero puedes utilizar Parcelable u otras opciones
        intent.putExtra("vehiculo", vehiculo);

        // Iniciar la actividad de datos
        startActivity(intent);
    }

    static class ApiClient {

        // Aquí debes tener una instancia de Retrofit configurada para tu API
        private ApiService apiService;

        // Constructor u otros métodos de inicialización según tus necesidades

        public void obtenerDatos(final ApiCallback<Vehiculo> callback) {
            // Aquí haces la solicitud a la API utilizando Retrofit
            Call<Vehiculo> call = apiService.consultarVehiculo();

            call.enqueue(new Callback<Vehiculo>() {
                @Override
                public void onResponse(Call<Vehiculo> call, Response<Vehiculo> response) {
                    if (response.isSuccessful()) {
                        // Llamada exitosa, llamas al método onSuccess del callback
                        callback.onSuccess(response.body());
                    } else {
                        // Llamada no exitosa, manejas el error y llamas al método onFailure del callback
                        callback.onFailure("Error en la respuesta de la API");
                    }
                }

                @Override
                public void onFailure(Call<Vehiculo> call, Throwable t) {
                    // Fallo en la llamada, manejas el error y llamas al método onFailure del callback
                    callback.onFailure("Error al realizar la llamada a la API");
                }
            });
        }

        public void obtenerDatos(String placa, ApiCallback<Vehiculo> vehiculoApiCallback) {

        }
    }
}
