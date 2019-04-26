package com.bisanbl.prestamo;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Ver_Prestamos extends AppCompatActivity {
    ArrayList<VerPrestamo> Prestamos = new ArrayList<>();
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver__prestamos);

        Button BTNSiguiente = findViewById(R.id.BTSiguiente);
        Button BTNAnterior = findViewById(R.id.BTAnterior);


        if (getIntent().getExtras() != null){
            Prestamos = getIntent().getParcelableArrayListExtra("Prestamos");
            index =0;
            cargarDatos();
        }

        BTNSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index == Prestamos.size()-1){
                    Snackbar.make(v, getResources().getString(R.string.llegofin),Snackbar.LENGTH_LONG).show();
                }else {
                    index++;
                    cargarDatos();
                }

                cargarDatos();
            }
        });
        BTNAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index==0){
                    Snackbar.make(v, getResources().getString(R.string.llegoinicio),Snackbar.LENGTH_LONG).show();
                }else {
                    index--;
                    cargarDatos();
                }

                cargarDatos();
            }
        });
    }

    void cargarDatos(){
        TextView TVNombre = findViewById(R.id.TVNombreCliente);
        TextView ETVMonto = findViewById(R.id.ETVMonton);
        TextView ETVInteres = findViewById(R.id.ETVinteres);
        TextView ETVPlazo = findViewById(R.id.ETVPlazo);
        TextView ETVFechaInicialM = findViewById(R.id.TVFechaInicialM);
        TextView ETVFechaFinM = findViewById(R.id.TVFechaFinM);
        TextView ETVMontoPagarM = findViewById(R.id.TVMontoPagarM);
        TextView ETVMontoMesM = findViewById(R.id.TVMontomesM);

        TVNombre.setText(Prestamos.get(index).getName() + " " + Prestamos.get(index).getLastname());
        ETVMonto.setText(Prestamos.get(index).getMonto().toString());
        ETVInteres.setText(Prestamos.get(index).getInteres().toString());
        ETVPlazo.setText(Integer.toString(Prestamos.get(index).getPlazo()));
        ETVFechaInicialM.setText(Prestamos.get(index).getFechainicio());
        ETVFechaFinM.setText(Prestamos.get(index).getFechafin());
        ETVMontoPagarM.setText(Float.toString(Prestamos.get(index).getTotal()));
        ETVMontoMesM.setText(Float.toString(Prestamos.get(index).getCuota()));
    }
}
