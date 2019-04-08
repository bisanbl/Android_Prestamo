package com.bisanbl.prestamo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Registro_Credito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro__credito);

        TextView TVfechainicial = findViewById(R.id.TVFechaInicialM);
        final TextView TVfechafin = findViewById(R.id.TVFechaFinM);
        final TextView TVmonto = findViewById(R.id.TVMontoPagarM);
        final TextView TVmes = findViewById(R.id.TVMontomesM);

        final EditText ETplazo = findViewById(R.id.ETPlazo);
        final EditText ETmonto = findViewById(R.id.ETMonton);
        final Spinner Sainteres = findViewById(R.id.SAinteres);

        final float total = 0;

        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        final DecimalFormat dosDecimales = new DecimalFormat("0.##");
        final Date date = new Date();

        TVfechainicial.setText(dateFormat.format(date));

        ETplazo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){

                    if (!TextUtils.isEmpty(ETplazo.getText().toString())) {
                        //Recibimos la Fecha Actual y la enviamos a la funcion sumarMeses que retorna la fecha con los meses agregados
                        // Se formatea "dd-MM-yyyy" y se muestra en pantalla
                        TVfechafin.setText(dateFormat.format(sumarMeses(date, Integer.parseInt(ETplazo.getText().toString()))));

                        TVmonto.setText(dosDecimales.format(total(Double.parseDouble(ETmonto.getText().toString()), Sainteres)));
                       TVmes.setText(dosDecimales.format(Double.parseDouble(TVmonto.getText().toString()) / Integer.parseInt(ETplazo.getText().toString())));
                    }else
                        return;
                }else
                    return;

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

                if (!TextUtils.isEmpty(ETplazo.getText().toString())) {
                    //Recibimos la Fecha Actual y la enviamos a la funcion sumarMeses que retorna la fecha con los meses agregados
                    // Se formatea "dd-MM-yyyy" y se muestra en pantalla
                    TVfechafin.setText(dateFormat.format(sumarMeses(date, Integer.parseInt(ETplazo.getText().toString()))));

                    TVmonto.setText(dosDecimales.format(total(Double.parseDouble(ETmonto.getText().toString()), Sainteres)));
                    TVmes.setText(dosDecimales.format(Double.parseDouble(TVmonto.getText().toString()) / Integer.parseInt(ETplazo.getText().toString())));
                }else
                    return;
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
                if (!TextUtils.isEmpty(ETplazo.getText().toString())) {
                    //Recibimos la Fecha Actual y la enviamos a la funcion sumarMeses que retorna la fecha con los meses agregados
                    // Se formatea "dd-MM-yyyy" y se muestra en pantalla
                    TVfechafin.setText(dateFormat.format(sumarMeses(date, Integer.parseInt(ETplazo.getText().toString()))));

                    TVmonto.setText(dosDecimales.format(total(Double.parseDouble(ETmonto.getText().toString()), Sainteres)));
                    TVmes.setText(dosDecimales.format(Double.parseDouble(TVmonto.getText().toString()) / Integer.parseInt(ETplazo.getText().toString())));
                }else
                    return;
            }
        });

        ETmonto.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){

                    if (!TextUtils.isEmpty(ETplazo.getText().toString())) {
                        //Recibimos la Fecha Actual y la enviamos a la funcion sumarMeses que retorna la fecha con los meses agregados
                        // Se formatea "dd-MM-yyyy" y se muestra en pantalla
                        TVfechafin.setText(dateFormat.format(sumarMeses(date, Integer.parseInt(ETplazo.getText().toString()))));

                        TVmonto.setText(dosDecimales.format(total(Double.parseDouble(ETmonto.getText().toString()), Sainteres)));
                        TVmes.setText(dosDecimales.format(Double.parseDouble(TVmonto.getText().toString()) / Integer.parseInt(ETplazo.getText().toString())));
                    }else
                        return;
                }else
                    return;
            }
        });

        Sainteres.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!TextUtils.isEmpty(ETplazo.getText().toString())) {
                    //Recibimos la Fecha Actual y la enviamos a la funcion sumarMeses que retorna la fecha con los meses agregados
                    // Se formatea "dd-MM-yyyy" y se muestra en pantalla
                    TVfechafin.setText(dateFormat.format(sumarMeses(date, Integer.parseInt(ETplazo.getText().toString()))));

                    TVmonto.setText(dosDecimales.format(total(Double.parseDouble(ETmonto.getText().toString()), Sainteres)));
                    TVmes.setText(dosDecimales.format(Double.parseDouble(TVmonto.getText().toString()) / Integer.parseInt(ETplazo.getText().toString())));
                }else
                    return;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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

        calendar.add(Calendar.MONTH,meses);  // numero de meses a añadir, o restar en caso de meses<0


        return calendar.getTime(); // Devuelve el objeto Date con los nuevos meses añadidos

    }
}
