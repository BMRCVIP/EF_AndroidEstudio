package com.example.examenfinal.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName= "movimientos")
public class Movimiento {
    @PrimaryKey (autoGenerate = true)
    public int movimientoID;
    public String tipo;
    public double monto;
    public String motivo;
    public String img;
    public String latitud;
    public String longitud;
}
