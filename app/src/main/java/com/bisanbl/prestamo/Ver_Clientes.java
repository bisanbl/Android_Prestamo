package com.bisanbl.prestamo;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Ver_Clientes extends AppCompatActivity {

    List<Cliente> Clientes = new ArrayList<>();
    int index;
    int prestamo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver__clientes);



        Button BTNSiguiente = findViewById(R.id.BTNSiguiente);
        Button BTNAnterior = findViewById(R.id.BTNAnterior);
        Button BTNNuevoPrestamo = findViewById(R.id.BTNNuevoPrestamo);


        if (getIntent().getExtras() != null){
            Clientes = getIntent().getParcelableArrayListExtra("Clientes");
            index=0;
            prestamo =0;
            cargarDatos(Clientes,index);
        }

        BTNNuevoPrestamo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Clientes.size()>0){

                    ArrayList<String> nombreClientes = new ArrayList<>();
                    nombreClientes.add(Clientes.get(index).getNombre());
                    Intent intent = new Intent(getApplicationContext(), Registro_Credito.class);
                    intent.putStringArrayListExtra("nombreClientes",nombreClientes );
                    startActivityForResult(intent,1);
                }
            }
        });

        BTNAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index==0){
                    Snackbar.make(v, getResources().getString(R.string.llegoinicio),Snackbar.LENGTH_LONG).show();
                }else {
                    index--;
                    cargarDatos(Clientes,index);
                }
            }
        });

        BTNSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index == Clientes.size()-1){
                    Snackbar.make(v, getResources().getString(R.string.llegofin),Snackbar.LENGTH_LONG).show();
                }else {
                    index++;
                    cargarDatos(Clientes,index);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if(data.getExtras() !=null && resultCode == Activity.RESULT_OK){
                if (requestCode ==1){
                    Clientes.get(index).setPrestamos((Prestamo)data.getParcelableExtra("Prestamo"));
                    prestamo++;
                }else {
                    Snackbar.make(getWindow().getDecorView().getRootView(), getResources().getString(R.string.llegofin),Snackbar.LENGTH_LONG).show();
                }

            }

        }catch (Exception e){

        }

    }

    @Override
    public void onBackPressed()
    {
        Intent returnIntent = new Intent();

        if (prestamo>0) {
            returnIntent.putParcelableArrayListExtra("Clientes", (ArrayList<? extends Parcelable>) Clientes);
            returnIntent.putExtra("prestamo", prestamo);
            setResult(Activity.RESULT_OK,returnIntent);
        }else {
            setResult(Activity.RESULT_CANCELED,returnIntent);
        }
        super.onBackPressed();
    }

    void cargarDatos(List<Cliente> clientes, int i){
        TextView ETVNombre = findViewById(R.id.ETVNombre);
        TextView ETVApellido = findViewById(R.id.ETVApellido);
        TextView ETVSexo = findViewById(R.id.ETVsexo);
        TextView ETVTelefono = findViewById(R.id.ETVTelefono);
        TextView ETVCedula = findViewById(R.id.ETVCedula);
        TextView ETVOcupacion = findViewById(R.id.ETVOcupacion);
        TextView ETVDireccion = findViewById(R.id.ETVDireccion);

        ETVNombre.setText(clientes.get(i).getNombre());
        ETVApellido.setText(clientes.get(i).getApellido());
        ETVSexo.setText(clientes.get(i).getSexo());
        ETVTelefono.setText(clientes.get(i).getTelefono());
        ETVCedula.setText(clientes.get(i).getCedula());
        ETVOcupacion.setText(clientes.get(i).getOcupacion());
        ETVDireccion.setText(clientes.get(i).getDireccion());
    }
}
