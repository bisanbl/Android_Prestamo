package com.bisanbl.prestamo;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Registro_Credito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro__credito);

        final TextView TVfechainicial = findViewById(R.id.TVFechaInicialM);
        final TextView TVfechafin = findViewById(R.id.TVFechaFinM);
        final TextView TVmonto = findViewById(R.id.TVMontoPagarM);
        final TextView TVmes = findViewById(R.id.TVMontomesM);

        final EditText ETplazo = findViewById(R.id.ETVPlazo);
        final EditText ETmonto = findViewById(R.id.ETVMonton);

        final Spinner SanombreCliente = findViewById(R.id.TVNombreCliente);
        final Spinner Sainteres = findViewById(R.id.ETVinteres);

        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        final DecimalFormat dosDecimales = new DecimalFormat("0.##");
        final Date date = new Date();

        Button BTNGuardar = findViewById(R.id.BTSiguiente);
        Button BTNCancelar = findViewById(R.id.BTAnterior);

        ArrayList<String> nombreClientes;

        if (getIntent().getExtras() != null){
            nombreClientes =  getIntent().getStringArrayListExtra("nombreClientes");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nombreClientes);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            SanombreCliente.setAdapter(dataAdapter);
        }


        TVfechainicial.setText(dateFormat.format(date));

        ETplazo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){

                    if (!TextUtils.isEmpty(ETplazo.getText().toString()) && !TextUtils.isEmpty(ETmonto.getText().toString())) {
                        //Recibimos la Fecha Actual y la enviamos a la funcion sumarMeses que retorna la fecha con los meses agregados
                        // Se formatea "dd-MM-yyyy" y se muestra en pantalla
                        TVfechafin.setText(dateFormat.format(sumarMeses(date, Integer.parseInt(ETplazo.getText().toString()))));

                        TVmonto.setText(dosDecimales.format(total(Double.parseDouble(ETmonto.getText().toString()), Sainteres)));
                       TVmes.setText(dosDecimales.format(total(Double.parseDouble(ETmonto.getText().toString()), Sainteres) / Integer.parseInt(ETplazo.getText().toString())));
                    }else{
                        TVmes.setText(" ");
                        TVmonto.setText(" ");
                        TVfechafin.setText(" ");
                    }

                }


            }
        });

        ETplazo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!TextUtils.isEmpty(ETplazo.getText().toString()) && !TextUtils.isEmpty(ETmonto.getText().toString())) {
                    //Recibimos la Fecha Actual y la enviamos a la funcion sumarMeses que retorna la fecha con los meses agregados
                    // Se formatea "dd-MM-yyyy" y se muestra en pantalla
                    TVfechafin.setText(dateFormat.format(sumarMeses(date, Integer.parseInt(ETplazo.getText().toString()))));

                    TVmonto.setText(dosDecimales.format(total(Double.parseDouble(ETmonto.getText().toString()), Sainteres)));
                    TVmes.setText(dosDecimales.format(total(Double.parseDouble(ETmonto.getText().toString()), Sainteres) / Integer.parseInt(ETplazo.getText().toString())));
                }else{
                    TVmes.setText(" ");
                    TVmonto.setText(" ");
                    TVfechafin.setText(" ");
                }
            }
        });

        ETmonto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(ETplazo.getText().toString()) && !TextUtils.isEmpty(ETmonto.getText().toString())) {
                    //Recibimos la Fecha Actual y la enviamos a la funcion sumarMeses que retorna la fecha con los meses agregados
                    // Se formatea "dd-MM-yyyy" y se muestra en pantalla
                    TVfechafin.setText(dateFormat.format(sumarMeses(date, Integer.parseInt(ETplazo.getText().toString()))));

                    TVmonto.setText(dosDecimales.format(total(Double.parseDouble(ETmonto.getText().toString()), Sainteres)));
                    TVmes.setText(dosDecimales.format( total(Double.parseDouble(ETmonto.getText().toString()), Sainteres)/ Integer.parseInt(ETplazo.getText().toString())));
                }else{
                    TVmes.setText(" ");
                    TVmonto.setText(" ");
                    TVfechafin.setText(" ");
                }
            }
        });

        ETmonto.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){

                    if (!TextUtils.isEmpty(ETplazo.getText().toString()) && !TextUtils.isEmpty(ETmonto.getText().toString())) {
                        //Recibimos la Fecha Actual y la enviamos a la funcion sumarMeses que retorna la fecha con los meses agregados
                        // Se formatea "dd-MM-yyyy" y se muestra en pantalla
                        TVfechafin.setText(dateFormat.format(sumarMeses(date, Integer.parseInt(ETplazo.getText().toString()))));

                        TVmonto.setText(dosDecimales.format(total(Double.parseDouble(ETmonto.getText().toString()), Sainteres)));
                        TVmes.setText(dosDecimales.format(total(Double.parseDouble(ETmonto.getText().toString()), Sainteres)/ Integer.parseInt(ETplazo.getText().toString())));
                    }else{
                        TVmes.setText(" ");
                        TVmonto.setText(" ");
                        TVfechafin.setText(" ");
                    }
                }

            }
        });

        Sainteres.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!TextUtils.isEmpty(ETplazo.getText().toString()) && !TextUtils.isEmpty(ETmonto.getText().toString())) {
                    //Recibimos la Fecha Actual y la enviamos a la funcion sumarMeses que retorna la fecha con los meses agregados
                    // Se formatea "dd-MM-yyyy" y se muestra en pantalla
                    TVfechafin.setText(dateFormat.format(sumarMeses(date, Integer.parseInt(ETplazo.getText().toString()))));

                    TVmonto.setText(dosDecimales.format(total(Double.parseDouble(ETmonto.getText().toString()), Sainteres)));
                    TVmes.setText(dosDecimales.format(total(Double.parseDouble(ETmonto.getText().toString()), Sainteres)/ Integer.parseInt(ETplazo.getText().toString())));
                }else{
                    TVmes.setText(" ");
                    TVmonto.setText(" ");
                    TVfechafin.setText(" ");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        BTNGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(TVfechafin.getText().toString())) {
                    Prestamo prestamo = new Prestamo();
                    prestamo.setMonto(Float.parseFloat(ETmonto.getText().toString().replace(',','.').trim()));
                    prestamo.setInteres(Float.parseFloat(Sainteres.getSelectedItem().toString()));
                    prestamo.setPlazo(Integer.parseInt(ETplazo.getText().toString()));
                    prestamo.setFechainicio(TVfechainicial.getText().toString());
                    prestamo.setFechafin(TVfechafin.getText().toString());
                    prestamo.setTotal(Float.parseFloat(TVmonto.getText().toString().replace(',','.').trim()));
                    prestamo.setCuota(Float.parseFloat(TVmes.getText().toString().replace(',', '.').trim()));

                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("Prestamo",prestamo);
                    returnIntent.putExtra("Cliente",SanombreCliente.getSelectedItemPosition());
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();


                    //Snackbar.make(v, getResources().getString(R.string.gracias),Snackbar.LENGTH_LONG).show();
                }else
                    Snackbar.make(v, getResources().getString(R.string.ErrorBTN),Snackbar.LENGTH_LONG).show();
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

    // funcion devuelve 0 si ha ocurrido un ERROR, en caso contrario devuelve el total del financiamiento
    // con intereses incluido. Recibe el monton inicial y el spinner para calcular el interes.
    private double total(double montoinicial, Spinner interes){
        if (montoinicial == 0)
            return 0;
        switch (Integer.parseInt(interes.getSelectedItem().toString())){
            case 15:
                return montoinicial+ (montoinicial*0.15);

            case 20:
                return montoinicial+(montoinicial*0.20);

            case 25:
                return montoinicial+(montoinicial*0.25);

        }

        return 0;
    }

    public Date sumarMeses(Date fecha, int meses){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe

        calendar.add(Calendar.MONTH,meses);// numero de meses a añadir, o restar en caso de meses<0



        return calendar.getTime(); // Devuelve el objeto Date con los nuevos meses añadidos

    }
}
