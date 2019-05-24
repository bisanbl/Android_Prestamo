package com.bisanbl.prestamo;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_lista_clientes);

        recyclerView = findViewById(R.id.RecyclerClientes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        if (getIntent().getExtras() != null){
            Clientes = getIntent().getParcelableArrayListExtra("Clientes");
             clienteAdapter = new ClienteAdapter(this,Clientes, new OnMyAdapterClickListener() {
                @Override
                public void onEditCliked(int post) {
                    Intent intent = new Intent( ListaClientes.this,RegistroCliente.class);
                    intent.putExtra("Cliente",Clientes.get(post));
                    startActivityForResult(intent, post);
                }

                @Override
                public void onDeleteClicked(int post) {
                    Log.d("Test", String.valueOf(post));
                    Clientes.remove(post);
                    clienteAdapter.notifyDataSetChanged();

                }
            });
             recyclerView.setAdapter(clienteAdapter);
        }

    }


}
