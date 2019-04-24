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

public class RegistroCliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_cliente);

        final EditText ETnombre = findViewById(R.id.ETVNombre);
        final EditText ETapellido = findViewById(R.id.ETVApellido);
        final Spinner  SPSexo = findViewById(R.id.ETVsexo);
        final EditText ETTelefono = findViewById(R.id.ETVTelefono);
        final EditText ETdireccion = findViewById(R.id.ETVDireccion);
        final EditText ETocupacion = findViewById(R.id.ETVOcupacion);
        final EditText ETcedula = findViewById(R.id.ETVCedula);


        final Button BTNCancelar = findViewById(R.id.BTNAnterior);
        final Button BTNGuardar = findViewById(R.id.BTNSiguiente);

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

    private boolean validarActivity(EditText ETnombre, EditText ETdireccion, EditText ETTelefono, EditText ETcedula){
        if (!TextUtils.isEmpty(ETnombre.getText().toString()) || !TextUtils.isEmpty(ETdireccion.getText().toString())){
            return (!TextUtils.isEmpty(ETTelefono.getText().toString()) || !TextUtils.isEmpty(ETcedula.getText().toString()));
        }
        return false;
    }
}
