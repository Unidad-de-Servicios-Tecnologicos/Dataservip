package com.example.dataservip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class inicio2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio2);


        Button myButton = findViewById(R.id.button2);
        myButton.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.morado));


    }

    public void irAActividadDos(View view) {
        Intent intent = new Intent(this, consulta.class);
        startActivity(intent);
    }

}