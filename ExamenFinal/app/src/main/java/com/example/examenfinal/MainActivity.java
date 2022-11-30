package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    Button btnMostrarDatos, btnCrearDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMostrarDatos = findViewById(R.id.btnMostrarData);
        btnCrearDatos = findViewById(R.id.btnCrearData);

        btnMostrarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listFormulario();

            }
        });

        btnCrearDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearCuenta();
            }
        });


    }

    void listFormulario(){
        Intent intent = new Intent(getApplicationContext(), ListDatosActivity.class);
        startActivity(intent);
    }

    void crearCuenta(){

        Intent intent = new Intent(getApplicationContext(), FormDataCuentaActivity.class);
        startActivity(intent);
    }




}