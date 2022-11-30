package com.example.examenfinal.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.examenfinal.dao.DatosDao;
import com.example.examenfinal.dao.MovimientoDao;
import com.example.examenfinal.entities.Cuenta;
import com.example.examenfinal.entities.Movimiento;
import com.example.examenfinal.service.CuentasService;


@Database(entities ={Cuenta.class, Movimiento.class}, version =1)
public abstract class DataBD  extends  RoomDatabase{
    public abstract DatosDao datosdao();
    public abstract MovimientoDao movimientoDao();

    public static DataBD getInstance(Context context){
        return Room.databaseBuilder(context, DataBD.class, "com.example.examenfinal.database_bmrc")
                .allowMainThreadQueries().build();
    }

}
