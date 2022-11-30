package com.example.examenfinal.service;

import com.example.examenfinal.entities.Cuenta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CuentasService {


    @POST("/cuenta")
    Call<Void> crear (@Body Cuenta cuenta);


    @GET("cuenta")
    Call<List<Cuenta>> listarCuentas();
}
