package com.bisanbl.prestamo;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText ETnombre = findViewById(R.id.ETNombre);
        final EditText ETdireccion = findViewById(R.id.ETDireccion);
        final EditText ETTelefono = findViewById(R.id.ETTelefono);
        final EditText ETcedula = findViewById(R.id.ETCedula);
        final Button BTNcontinuar = findViewById(R.id.BTNContinuar);

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

        BTNcontinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validarActivity(ETnombre, ETdireccion, ETTelefono, ETcedula)) {
                    Snackbar.make(v, getResources().getString(R.string.ErrorBTN),Snackbar.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), Registro_Credito.class);
                    startActivity(intent);
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private boolean validarActivity(EditText ETnombre, EditText ETdireccion, EditText ETTelefono, EditText ETcedula){
        if (!TextUtils.isEmpty(ETnombre.getText().toString()) || !TextUtils.isEmpty(ETdireccion.getText().toString())){
            return (!TextUtils.isEmpty(ETTelefono.getText().toString()) || !TextUtils.isEmpty(ETcedula.getText().toString()));


        }
        return false;
    }
}
