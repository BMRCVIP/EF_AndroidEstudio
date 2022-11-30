package com.example.examenfinal.adapter;

import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenfinal.FormDataCuentaActivity;
import com.example.examenfinal.MovimientoReActivity;
import com.example.examenfinal.R;
import com.example.examenfinal.entities.Cuenta;

import java.util.List;

public class CuentaListAdapter extends RecyclerView.Adapter {

    List<Cuenta> datos;

    Button btnRedi;

    public CuentaListAdapter (List<Cuenta> cuentaList){

        this.datos=cuentaList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =   LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_cuentalist,parent, false);
        return new CuentaAPIViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        TextView tvmosdata = holder.itemView.findViewById(R.id.tvmostrardata);
        tvmosdata.setText(datos.get(position).nombre);
        btnRedi=holder.itemView.findViewById(R.id.btnMovimientos);
        btnRedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), MovimientoReActivity.class);
                holder.itemView.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }


    static class CuentaAPIViewHolder extends RecyclerView.ViewHolder{
        public  CuentaAPIViewHolder(@NonNull View itenView){
            super(itenView);
        }
    }
}
