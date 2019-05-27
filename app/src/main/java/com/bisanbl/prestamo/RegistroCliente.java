package com.bisanbl.prestamo;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RegistroCliente extends AppCompatActivity {
    Cliente Cliente;

    EditText ETnombre;
    EditText ETapellido;
    Spinner  SPSexo;
    EditText ETTelefono;
    EditText ETdireccion;
    EditText ETocupacion ;
    EditText ETcedula;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_cliente);

        ETnombre = findViewById(R.id.ETVNombre);
        ETapellido = findViewById(R.id.ETVApellido);
        SPSexo = findViewById(R.id.ETVsexo);
        ETTelefono = findViewById(R.id.ETVTelefono);
        ETdireccion = findViewById(R.id.ETVDireccion);
        ETocupacion = findViewById(R.id.ETVOcupacion);
        ETcedula = findViewById(R.id.ETVCedula);


        if (getIntent().getExtras() != null){
            Cliente = getIntent().getParcelableExtra("Cliente");
            index = getIntent().getIntExtra("index",0);
            Snackbar.make(findViewById(android.R.id.content),"Cargando datos del Cliente",Snackbar.LENGTH_LONG).show();
            cargarDatos();
        }

        ETnombre.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    if (TextUtils.isEmpty(ETnombre.getText().toString()))
                        ETnombre.setError(getResources().getString(R.string.Error));
                }
            }
        });

        ETdireccion.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    if (TextUtils.isEmpty(ETdireccion.getText().toString()))
                        ETdireccion.setError(getResources().getString(R.string.Error));
                }
            }
        });

        ETTelefono.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    if (TextUtils.isEmpty(ETTelefono.getText().toString()))
                        ETTelefono.setError(getResources().getString(R.string.Error));
                }
            }
        });

        ETcedula.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    if (TextUtils.isEmpty(ETcedula.getText().toString()))
                        ETcedula.setError(getResources().getString(R.string.Error));
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.registromenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.guardarmenu:
                if (!validarActivity(ETnombre, ETdireccion, ETTelefono, ETcedula)) {
                    Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.ErrorBTN),Snackbar.LENGTH_LONG).show();
                } else {
                    Cliente cliente = new Cliente();
                    cliente.setNombre(ETnombre.getText().toString());
                    cliente.setApellido(ETapellido.getText().toString());
                    cliente.setSexo(SPSexo.getSelectedItem().toString());
                    cliente.setTelefono(ETTelefono.getText().toString());
                    cliente.setCedula(ETcedula.getText().toString());
                    cliente.setOcupacion(ETocupacion.getText().toString());
                    cliente.setDireccion(ETdireccion.getText().toString());


                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("Cliente",cliente);
                    if (index != -1){
                        returnIntent.putExtra("index",index);
                    }
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();
                }
                break;

            case R.id.cancelarmenu:
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED,returnIntent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    void cargarDatos(){
        ETnombre.setText(Cliente.getNombre());
        ETapellido.setText(Cliente.getApellido());
        SPSexo.setSelection(obtenerPosicionItem(SPSexo,Cliente.getSexo()));
        ETTelefono.setText(Cliente.getTelefono());
        ETdireccion.setText(Cliente.getDireccion());
        ETocupacion.setText(Cliente.getOcupacion());
        ETcedula.setText(Cliente.getCedula());
    }

    //Método para obtener la posición de un ítem del spinner
    public static int obtenerPosicionItem(Spinner spinner, String fruta) {
        //Creamos la variable posicion y lo inicializamos en 0
        int posicion = 0;
        //Recorre el spinner en busca del ítem que coincida con el parametro `String fruta`
        //que lo pasaremos posteriormente
        for (int i = 0; i < spinner.getCount(); i++) {
            //Almacena la posición del ítem que coincida con la búsqueda
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(fruta)) {
                posicion = i;
            }
        }
        //Devuelve un valor entero (si encontro una coincidencia devuelve la
        // posición 0 o N, de lo contrario devuelve 0 = posición inicial)
        return posicion;
    }


    private boolean validarActivity(EditText ETnombre, EditText ETdireccion, EditText ETTelefono, EditText ETcedula){
        if (!TextUtils.isEmpty(ETnombre.getText().toString()) || !TextUtils.isEmpty(ETdireccion.getText().toString())){
            return (!TextUtils.isEmpty(ETTelefono.getText().toString()) || !TextUtils.isEmpty(ETcedula.getText().toString()));
        }
        return false;
    }
}
