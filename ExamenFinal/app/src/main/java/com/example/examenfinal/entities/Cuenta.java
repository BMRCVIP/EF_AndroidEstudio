package com.example.examenfinal.entities;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cuentas")
public class Cuenta {
    @PrimaryKey(autoGenerate = true)
    public int cuentaID;
    public String nombre;

}
