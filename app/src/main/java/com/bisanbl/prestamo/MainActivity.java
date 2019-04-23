package com.bisanbl.prestamo;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
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
import android.widget.Switch;
import android.widget.TextView;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    Vector<Cliente> Clientes = new Vector<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId()){
            case R.id.nuevoRegistro:
                intent = new Intent(getApplicationContext(), Registro_Credito.class);
                intent.putExtra("Clientes",Clientes);
                startActivity(intent);
                break;

            case R.id.nuevoCliente:
                intent = new Intent(getApplicationContext(), RegistroCliente.class);
                startActivityForResult(intent,1);
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        TextView TVLog = findViewById(R.id.TVLog);
        try {
            if(data.getExtras() ==null){
                TVLog.append("no hay informacion\n");
                return;
            }
        }catch (Exception e){

        }
        switch(requestCode){
            case 1:
                if (resultCode == Activity.RESULT_OK){
                    Clientes.add((Cliente) data.getParcelableExtra("Cliente"));
                    TVLog.append("Ingreso de nuevo Cliente " + Clientes.lastElement().getNombre() + "\n");
                }else {
                    TVLog.append("Cancelo Ingreso de Nuevo Cliente\n");
                }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
