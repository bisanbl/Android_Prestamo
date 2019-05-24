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
    ArrayList<ClientItem> clientItems = new ArrayList<>();
    List<Cliente> Clientes;
    Context context;

    public OnMyAdapterClickListener onMyAdapterClickListener;

    public ClienteAdapter(Context context,List<Cliente> clientes, OnMyAdapterClickListener onMyAdapterClickListener) {
        this.context = context;
        this.Clientes = clientes;
        this.onMyAdapterClickListener = onMyAdapterClickListener;
        cargarDatos();
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

        public void asignarDatos(ClientItem clientItem) {
            TEXTName.setText(clientItem.getName());
            TEXTLasname.setText(clientItem.getLastname() );
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
        }

       /* @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.BTNEdit:


                    Intent intent = new Intent(context,RegistroCliente.class);
                    intent.putExtra("Cliente",Clientes.get(cln));
                    ((Activity) context).startActivityForResult(intent, cln);
                    break;

                case R.id.BTNDelete:

                    break;
            }
        }*/
    }

    @NonNull
    @Override
    public ViewHolderCliente onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cliente,null,false);
        return new ViewHolderCliente(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCliente viewHolderCliente, int i) {
            viewHolderCliente.asignarDatos(clientItems.get(i));
            viewHolderCliente.asignarClicks(i);
    }

    @Override
    public int getItemCount() {
        return clientItems.size() ;
    }

    void cargarDatos(){
        Iterator<Cliente> it = Clientes.iterator();
        while (it.hasNext()){
            Cliente clnt = it.next();
            clientItems.add(new ClientItem(clnt.getNombre(),clnt.getApellido()));
        }
    }
}
