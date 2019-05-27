package com.bisanbl.prestamo;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Detalle_Clientes extends AppCompatActivity {

    Cliente Cliente = new Cliente();
    int index;
    int prestamo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle__clientes);





        if (getIntent().getExtras() != null){
            Cliente = getIntent().getParcelableExtra("Cliente");
            index = getIntent().getIntExtra("index",0);
            cargarDatos(Cliente);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.verclientesmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nuevoprestamormenu:
                ArrayList<String> nombreClientes = new ArrayList<>();
                nombreClientes.add(Cliente.getNombre() + " " + Cliente.getApellido());
                Intent intent = new Intent(getApplicationContext(), Registro_Credito.class);
                intent.putStringArrayListExtra("nombreClientes",nombreClientes );
                startActivityForResult(intent,1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if(data.getExtras() !=null && resultCode == Activity.RESULT_OK){
                if (requestCode ==1){
                    Cliente.setPrestamos((Prestamo)data.getParcelableExtra("Prestamo"));
                    prestamo++;
                }else {
                    Snackbar.make(getWindow().getDecorView().getRootView(), getResources().getString(R.string.cancelPrestamo),Snackbar.LENGTH_LONG).show();
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
            returnIntent.putExtra("Cliente",Cliente);
            returnIntent.putExtra("index", index);
            setResult(Activity.RESULT_OK,returnIntent);
        }else {
            setResult(Activity.RESULT_CANCELED,returnIntent);
        }
        super.onBackPressed();
    }

    void cargarDatos(Cliente cliente){
        TextView ETVNombre = findViewById(R.id.ETVNombre);
        TextView ETVApellido = findViewById(R.id.ETVApellido);
        TextView ETVSexo = findViewById(R.id.ETVsexo);
        TextView ETVTelefono = findViewById(R.id.ETVTelefono);
        TextView ETVCedula = findViewById(R.id.ETVCedula);
        TextView ETVOcupacion = findViewById(R.id.ETVOcupacion);
        TextView ETVDireccion = findViewById(R.id.ETVDireccion);

        ETVNombre.setText(cliente.getNombre());
        ETVApellido.setText(cliente.getApellido());
        ETVSexo.setText(cliente.getSexo());
        ETVTelefono.setText(cliente.getTelefono());
        ETVCedula.setText(cliente.getCedula());
        ETVOcupacion.setText(cliente.getOcupacion());
        ETVDireccion.setText(cliente.getDireccion());
    }

}
