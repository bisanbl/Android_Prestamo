package com.bisanbl.prestamo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewDebug;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.bisanbl.prestamo.R.layout.activity_lista_clientes;

public class ListaClientes extends AppCompatActivity {

    List<Cliente> Clientes = new ArrayList<>();
    RecyclerView recyclerView;
    ClienteAdapter clienteAdapter;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_lista_clientes);

        recyclerView = findViewById(R.id.RecyclerClientes);
        builder = new AlertDialog.Builder(ListaClientes.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        if (getIntent().getExtras() != null){
            Clientes = getIntent().getParcelableArrayListExtra("Clientes");

             clienteAdapter = new ClienteAdapter(this,Clientes, new OnMyAdapterClickListener() {
                @Override
                public void onEditCliked(int post) {
                    Intent intent = new Intent( ListaClientes.this,RegistroCliente.class);
                    intent.putExtra("Cliente",Clientes.get(post));
                    intent.putExtra("index",post);
                    startActivityForResult(intent, 1);
                }

                @Override
                public void onDeleteClicked(final int post) {

                    builder.setMessage("Esta seguro que desea eliminar el cliente " + Clientes.get(post).getNombre())
                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Snackbar.make(findViewById(android.R.id.content),"Accion Cancelada",Snackbar.LENGTH_LONG).show();
                        }
                    })
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            clienteAdapter.Clientes.remove(post);
                            Clientes = clienteAdapter.Clientes;
                            clienteAdapter.notifyDataSetChanged();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }
            });
             recyclerView.setAdapter(clienteAdapter);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if(data.getExtras() !=null && resultCode == Activity.RESULT_OK){
                switch(requestCode){
                    case 1:
                        Snackbar.make(findViewById(android.R.id.content),"Actualizando Cliente",Snackbar.LENGTH_LONG).show();
                        Clientes.set(data.getIntExtra("index",0),(Cliente) data.getParcelableExtra("Cliente"));
                        clienteAdapter.Clientes.set(data.getIntExtra("index",0),(Cliente) data.getParcelableExtra("Cliente"));
                        clienteAdapter.notifyDataSetChanged();
                        break;
                }
            }else {
                switch (requestCode){
                    case 1:
                        //TVLog.append(getResources().getString(R.string.cancelCliente)  +"\n");
                        break;
                }
            }
        }catch (Exception e){

        }
    }
}
