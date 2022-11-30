package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.examenfinal.database.DataBD;
import com.example.examenfinal.entities.Cuenta;
import com.example.examenfinal.service.CuentasService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormDataCuentaActivity extends AppCompatActivity {


    EditText etNombre;
    Button btnEnviarRegistro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_data_cuenta);


        etNombre = findViewById(R.id.etNombre);
        btnEnviarRegistro = findViewById(R.id.btnCrearCuentas);


        Cuenta cuenta = new Cuenta();
        DataBD data = DataBD.getInstance(this);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://635a088aff3d7bddb9adab04.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        btnEnviarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cuenta.nombre = etNombre.getText().toString();
                data.datosdao().crearCuenta(cuenta);
                CuentasService service = retrofit.create(CuentasService.class);
                service.crear(cuenta).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });

            }
        });


    }
}