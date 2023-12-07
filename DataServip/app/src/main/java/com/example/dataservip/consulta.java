package com.example.dataservip;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class consulta extends AppCompatActivity {

    public Button btnconsultar;
    public TextInputEditText textconsultar;
    public String respuesta = "";
    public ModeloRetorno dataservip = new ModeloRetorno();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        btnconsultar =  findViewById(R.id.btnconsultar);
        textconsultar = findViewById(R.id.txtplaca);
        btnconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarApi rg = new consultarApi();
                try {
                    rg.respuesta(textconsultar.getText().toString());
                    muestraToast("Procesando...");
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            dataservip = rg.modeloRetorno;
                            respuesta = "PLACA: " + dataservip.getPlaca() + "\n" +
                                        "Interno" + dataservip.getInterno() + "\n" +
                                    "Razon_Social_Empresa" + dataservip.getRazon_social_empresa() + "\n" +
                                    "Dirección_Empresa" + dataservip.getDireccion_empresa() + "\n" +
                                    "Telefono_Empresa" + dataservip.getTelefono_empresa() + "\n" +
                                    "Tipo_Documento" + dataservip.getTipo_documento() + "\n" +
                                    "Estado" + dataservip.getEstado() + "\n";
                            if (respuesta.equals(" ")){
                                Intent intent = new Intent(consulta.this, Datos.class );

                                intent.putExtra("Informacion",respuesta);
                                startActivity(intent);
                            }
                        }
                    }, 3000);
                } catch (Exception ex) {
                    muestraToast("Error: " + ex);
                }
            }
        });
    }
    public void muestraToast(String mensaje){
        Toast.makeText(this, "" + mensaje, Toast.LENGTH_SHORT).show();
    }

}