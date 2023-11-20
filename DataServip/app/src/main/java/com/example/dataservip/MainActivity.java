package com.example.dataservip;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int TIEMPO_DE_ESPERA = 3000; // Tiempo en milisegundos (3 segundos)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.incio);

        // Crear un Handler para manejar el retraso
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Crear un Intent para iniciar ActividadB
                Intent intent = new Intent(MainActivity.this, inicio2.class);
                startActivity(intent);
                finish(); // Finalizar ActividadA para que no se pueda volver atrás
            }
        }, TIEMPO_DE_ESPERA);
    }
}
