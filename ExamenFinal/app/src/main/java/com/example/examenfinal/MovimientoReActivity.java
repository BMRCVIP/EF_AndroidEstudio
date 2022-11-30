package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.examenfinal.database.DataBD;
import com.example.examenfinal.entities.Movimiento;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MovimientoReActivity extends AppCompatActivity {



    EditText etMon, etMot, etLog, etLa;
    Button btnCreaMov;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimiento_re);


        Spinner spnTipos = findViewById(R.id.spTipo2);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.dostipos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spnTipos.setAdapter(adapter);

        Movimiento movimiento= new Movimiento();

        DataBD dataBD = DataBD.getInstance(this);

        etMon=findViewById(R.id.etMonto);
        etMot=findViewById(R.id.etNombre3);
        etLog=findViewById(R.id.etLongitud);
        etLa=findViewById(R.id.etLatitud);

        btnCreaMov=findViewById(R.id.btnTipos);


        btnCreaMov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movimiento.tipo= spnTipos.getSelectedItem().toString();

                movimiento.monto= Integer.parseInt(etMon.getText().toString());
                movimiento.motivo= etMot.getText().toString();
                movimiento.longitud=etLog.getText().toString();
                movimiento.latitud=etLa.getText().toString();


                dataBD.movimientoDao().guardar(movimiento);

                List<Movimiento> movimientos = dataBD.movimientoDao().movimientoobt();
                Log.i("Main_APP", new Gson().toJson(movimientos));

            }
        });






    }






}