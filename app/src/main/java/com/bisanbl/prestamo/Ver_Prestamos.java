package com.bisanbl.prestamo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Ver_Prestamos extends AppCompatActivity {
    List<Cliente> Clientes = new ArrayList<>();
    List<Prestamo> prestamos = new ArrayList<>();
    int index;
    int index2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver__prestamos);

        Button BTNSiguiente = findViewById(R.id.BTSiguiente);
        Button BTNAnterior = findViewById(R.id.BTAnterior);


        if (getIntent().getExtras() != null){
            Clientes = getIntent().getParcelableArrayListExtra("Clientes");
            index= index2 = 0;
            prestamos = Clientes.get(index).getPrestamos();
            cargarDatos();
        }

        BTNSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prestamos.size()>index2 && index <Clientes.size()){
                        index ++;
                    index2 =0;
                    prestamos.clear();
                    prestamos = Clientes.get(index).getPrestamos();
                    cargarDatos();
                }else {
                    index2++;
                    cargarDatos();
                }

            }
        });
        BTNAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index2>0 && index>0){
                        index --;
                    index2 =0;
                    prestamos.clear();
                    prestamos = Clientes.get(index).getPrestamos();
                    cargarDatos();
                }else {
                    index2--;
                    cargarDatos();
                }
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

        TVNombre.setText(Clientes.get(index).getNombre());
        ETVMonto.setText(prestamos.get(index2).getMonto().toString());
        ETVInteres.setText(prestamos.get(index2).getInteres().toString());
        ETVPlazo.setText(Integer.toString(prestamos.get(index2).getPlazo()));
        ETVFechaInicialM.setText(prestamos.get(index2).getFechainicio());
        ETVFechaFinM.setText(prestamos.get(index2).getFechafin());
        ETVMontoPagarM.setText(Float.toString(prestamos.get(index2).getTotal()));
        ETVMontoMesM.setText(Float.toString(prestamos.get(index2).getCuota()));
    }
}
