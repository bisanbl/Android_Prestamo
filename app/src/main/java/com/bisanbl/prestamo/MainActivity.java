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
import java.util.Iterator;
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
                    TVLog.append(getResources().getString(R.string.ceroClientes)+"\n");
                }
                break;

            case R.id.nuevoCliente:
                intent = new Intent(getApplicationContext(), RegistroCliente.class);
                startActivityForResult(intent,1);
                break;

            case R.id.verCliente:
                if (Clientes.size() >0) {
                    intent = new Intent(getApplicationContext(), Ver_Clientes.class);
                    intent.putParcelableArrayListExtra("Clientes", (ArrayList<? extends Parcelable>) Clientes);
                    startActivityForResult(intent, 3);
                }else {
                    TVLog.append(getResources().getString(R.string.ceroClientes) + "\n");
                }
                break;

            case R.id.verPrestamo:
                if (Clientes.size() >0) {

                    ArrayList<VerPrestamo> listprestamo = prestamosvisibles();
                    if (listprestamo.size()>0){
                    intent = new Intent(getApplicationContext(), Ver_Prestamos.class);
                    intent.putParcelableArrayListExtra("Prestamos", listprestamo);
                    startActivity(intent);
                    }else {
                        TVLog.append(getResources().getString(R.string.ceroPrestamos) + "\n");
                    }
                }else {
                    TVLog.append(getResources().getString(R.string.ceroClientes) + "\n");
                }
                break;

            case R.id.about:
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        TextView TVLog = findViewById(R.id.TVLog);
        try {
            if(data.getExtras() !=null && resultCode == Activity.RESULT_OK){
                switch(requestCode){
                    case 1:
                            Clientes.add((Cliente) data.getParcelableExtra("Cliente"));
                            TVLog.append(getResources().getString(R.string.ingresoCliente) + " " + Clientes.get(Clientes.size()-1).getNombre() + "\n");
                        break;

                    case 2:
                            Clientes.get(data.getIntExtra("Cliente",0)).setPrestamos((Prestamo)data.getParcelableExtra("Prestamo"));
                            TVLog.append(getResources().getString(R.string.ingresoPrestamo)+"\n");
                        break;
                    case 3:
                        List<Cliente> tempclientes = data.getParcelableArrayListExtra("Clientes");
                        Clientes = new ArrayList<>(tempclientes);
                        if (data.getIntExtra("prestamo",0)>0){
                            for (int i =0; i <data.getIntExtra("prestamo",0); i++){
                                TVLog.append(getResources().getString(R.string.ingresoPrestamo)+"\n");
                            }
                        }
                     break;
                }
            }else {
                switch (requestCode){
                    case 1:
                        TVLog.append(getResources().getString(R.string.cancelCliente)  +"\n");
                        break;
                    case 2:
                        TVLog.append(getResources().getString(R.string.cancelPrestamo) + "\n");
                        break;
                }
            }
        }catch (Exception e){

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    ArrayList<VerPrestamo> prestamosvisibles(){
        ArrayList<VerPrestamo> prestamos = new ArrayList<>();
        ArrayList<Prestamo> userprestamos = new ArrayList<>();

        Iterator<Cliente> it = Clientes.iterator();
        while (it.hasNext()) {
            userprestamos.clear();
            Cliente clnt = it.next();
            userprestamos =  clnt.getPrestamos();
            Iterator<Prestamo> itp =userprestamos.iterator();
            while (itp.hasNext()) {
                VerPrestamo nuevoPrestamo = new VerPrestamo();
                Prestamo auxprestamo = itp.next();

                nuevoPrestamo.setName(clnt.getNombre());
                nuevoPrestamo.setLastname(clnt.getApellido());
                nuevoPrestamo.setMonto(auxprestamo.getMonto());
                nuevoPrestamo.setInteres(auxprestamo.getInteres());
                nuevoPrestamo.setPlazo(auxprestamo.getPlazo());
                nuevoPrestamo.setFechainicio(auxprestamo.getFechainicio());
                nuevoPrestamo.setFechafin(auxprestamo.getFechafin());
                nuevoPrestamo.setTotal(auxprestamo.getTotal());
                nuevoPrestamo.setCuota(auxprestamo.getCuota());

                prestamos.add(nuevoPrestamo);
            }
        }
        /*for (int i = 0; i <Clientes.size(); i++){

            userprestamos.clear();
            userprestamos = Clientes.get(i).getPrestamos();

            for (int j =0; i<userprestamos.size();j++){
                VerPrestamo nuevoPrestamo = new VerPrestamo();

                nuevoPrestamo.setName(Clientes.get(i).getNombre());
                nuevoPrestamo.setLastname(Clientes.get(i).getApellido());
                nuevoPrestamo.setMonto(userprestamos.get(j).getMonto());
                nuevoPrestamo.setInteres(userprestamos.get(j).getInteres());
                nuevoPrestamo.setPlazo(userprestamos.get(j).getPlazo());
                nuevoPrestamo.setFechainicio(userprestamos.get(j).getFechainicio());
                nuevoPrestamo.setFechafin(userprestamos.get(j).getFechafin());
                nuevoPrestamo.setTotal(userprestamos.get(j).getTotal());
                nuevoPrestamo.setCuota(userprestamos.get(j).getCuota());

                prestamos.add(nuevoPrestamo);

            }
        }*/
        return prestamos;
    }

    ArrayList<String> nombreClientes(){
        ArrayList<String> nombresClientes = new ArrayList<>();
        for (int i =0; i <Clientes.size();i++){
            nombresClientes.add(Clientes.get(i).getNombre() + " " + Clientes.get(i).getApellido());
        }
        return nombresClientes;
    }
}
