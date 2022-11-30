package com.example.examenfinal.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.examenfinal.entities.Cuenta;

import java.util.List;

import retrofit2.Call;

@Dao
public interface DatosDao {

    @Insert
    void crearCuenta (Cuenta cuenta);

    @Query("SELECT * FROM cuentas")
    List<Cuenta> listarCuentas();




}
