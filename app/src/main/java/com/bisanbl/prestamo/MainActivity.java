package com.bisanbl.prestamo;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Cliente> Clientes = new ArrayList<>();

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
        TextView TVLog = findViewById(R.id.TVLog);
        switch (item.getItemId()){
            case R.id.nuevoRegistro:

                if (Clientes.size() >0){
                    intent = new Intent(getApplicationContext(), Registro_Credito.class);
                    intent.putStringArrayListExtra("nombreClientes", nombreClientes());
                    startActivityForResult(intent,2);
                }else {
                    TVLog.append("no hay Clientes\n");
                }
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
                    TVLog.append("Ingreso de nuevo Cliente " + Clientes.get(Clientes.size()-1).getNombre() + "\n");
                }else {
                    TVLog.append("Cancelo Ingreso de Nuevo Cliente\n");
                }
                break;

            case 2:
                if (resultCode ==Activity.RESULT_OK){

                }else {

                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    ArrayList<String> nombreClientes(){
        ArrayList<String> nombresClientes = new ArrayList<>();
        for (int i =0; i <Clientes.size();i++){
            nombresClientes.add(Clientes.get(i).getNombre() + " " + Clientes.get(i).getApellido());
        }
        return nombresClientes;
    }
}
