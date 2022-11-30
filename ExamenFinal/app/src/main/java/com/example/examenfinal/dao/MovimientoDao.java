package com.example.examenfinal.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.examenfinal.entities.Movimiento;

import java.util.List;

@Dao
public interface MovimientoDao {

    @Insert
    void guardar (Movimiento movimiento);

    @Query("SELECT * FROM movimientos")
    List<Movimiento> movimientoobt();
}
