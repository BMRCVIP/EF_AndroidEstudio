package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.examenfinal.adapter.CuentaListAdapter;
import com.example.examenfinal.database.DataBD;
import com.example.examenfinal.entities.Cuenta;
import com.example.examenfinal.service.CuentasService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListDatosActivity extends AppCompatActivity {


    RecyclerView rvList;
    List<Cuenta> cuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_datos);


        DataBD data = DataBD.getInstance(this);

        rvList= findViewById(R.id.rvLista);


        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://635a088aff3d7bddb9adab04.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CuentasService service = retrofit.create(CuentasService.class);

        List<Cuenta> datos = data.datosdao().listarCuentas();
        Call<List<Cuenta>> call = service.listarCuentas();
        call.enqueue(new Callback<List<Cuenta>>() {
            @Override
            public void onResponse(Call<List<Cuenta>> call, Response<List<Cuenta>> response) {
                rvList=findViewById(R.id.rvLista);
                cuenta = response.body();
                CuentaListAdapter adapter= new CuentaListAdapter(cuenta);
                rvList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rvList.setHasFixedSize(true);
                rvList.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Cuenta>> call, Throwable t) {

            }
        });
    }
}