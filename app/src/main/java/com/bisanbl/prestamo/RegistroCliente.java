package com.bisanbl.prestamo;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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


        final Button BTNCancelar = findViewById(R.id.BTAnterior);
        final Button BTNGuardar = findViewById(R.id.BTSiguiente);

        if (getIntent().getExtras() != null){
            Cliente = getIntent().getParcelableExtra("Cliente");
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

        BTNGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validarActivity(ETnombre, ETdireccion, ETTelefono, ETcedula)) {
                    Snackbar.make(v, getResources().getString(R.string.ErrorBTN),Snackbar.LENGTH_LONG).show();
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
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();
                }

            }

        });

        BTNCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED,returnIntent);
                finish();

            }
        });
    }

    void cargarDatos(){
        ETnombre.setText(Cliente.getNombre());
        ETapellido.setText(Cliente.getNombre());
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
