package com.bisanbl.prestamo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ViewHolderCliente> {
    //ArrayList<ClientItem> clientItems = new ArrayList<>();
    List<Cliente> Clientes;
    Context context;

    public OnMyAdapterClickListener onMyAdapterClickListener;

    public ClienteAdapter(Context context,List<Cliente> clientes, OnMyAdapterClickListener onMyAdapterClickListener) {
        this.context = context;
        this.Clientes = clientes;
        this.onMyAdapterClickListener = onMyAdapterClickListener;
    }



    public class ViewHolderCliente extends RecyclerView.ViewHolder {



        TextView TEXTName;
        TextView TEXTLasname;

        ImageButton BTNedit;
        ImageButton BTNdelete;


        public ViewHolderCliente(@NonNull View itemView) {
            super(itemView);
            TEXTName = itemView.findViewById(R.id.TEXTVName);
            TEXTLasname = itemView.findViewById(R.id.TEXTVLastName);
            BTNedit = itemView.findViewById(R.id.BTNEdit);
            BTNdelete = itemView.findViewById(R.id.BTNDelete);
        }

        public void asignarDatos(Cliente clientItem) {
            TEXTName.setText(clientItem.getNombre());
            TEXTLasname.setText(clientItem.getApellido() );
        }

        public void asignarClicks(final int i) {
            BTNedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onMyAdapterClickListener.onEditCliked(i);
                }
            });
            BTNdelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onMyAdapterClickListener.onDeleteClicked(i);
                }
            });

            TEXTLasname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onMyAdapterClickListener.onDetailClicked(i);
                }
            });
        }


    }

    @NonNull
    @Override
    public ViewHolderCliente onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cliente,null,false);
        return new ViewHolderCliente(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCliente viewHolderCliente, int i) {
            viewHolderCliente.asignarDatos(Clientes.get(i));
            viewHolderCliente.asignarClicks(i);
    }

    @Override
    public int getItemCount() {
        return Clientes.size() ;
    }

}
