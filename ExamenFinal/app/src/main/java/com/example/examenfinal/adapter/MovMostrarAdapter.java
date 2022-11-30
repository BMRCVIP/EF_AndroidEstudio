package com.example.examenfinal.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenfinal.MovimientoReActivity;
import com.example.examenfinal.R;
import com.example.examenfinal.entities.Cuenta;
import com.example.examenfinal.entities.Movimiento;

import java.util.List;

public class MovMostrarAdapter extends RecyclerView.Adapter{
    List<Movimiento> datos;
    Button btnRedi,btnMost;
    public MovMostrarAdapter (List<Movimiento> cuentaList)
    {
        this.datos =cuentaList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =   LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_cuentalist,parent, false);
        return new CuentaListAdapter.CuentaAPIViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        btnMost=holder.itemView.findViewById(R.id.btnMost);
        TextView tvmoti = holder.itemView.findViewById(R.id.txmotivo);
        tvmoti.setText(datos.get(position).motivo);

        TextView tvlat = holder.itemView.findViewById(R.id.txlatitud);
        tvlat.setText(datos.get(position).latitud);

        TextView tvlong = holder.itemView.findViewById(R.id.txlongitud);
        tvlong.setText(datos.get(position).longitud);

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

    static class MovimientoAPIViewHolder extends RecyclerView.ViewHolder{
        public  MovimientoAPIViewHolder(@NonNull View itenView){
            super(itenView);
        }
    }
}
