package com.example.dataservip;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;


public class consulta extends AppCompatActivity {

    public Button consultar;
    public TextInputEditText textconsultar;
    public String respuesta = "", imagen = "";
    public ModeloRetorno dataservip = new ModeloRetorno();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);


    }

}