package com.bisanbl.prestamo;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Ver_Prestamos extends AppCompatActivity {
    ArrayList<VerPrestamo> Prestamos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver__prestamos);



        if (getIntent().getExtras() != null){
            Prestamos = getIntent().getParcelableArrayListExtra("Prestamos");
            ListView listView = findViewById(R.id.ListPrestamos);
            PrestamosAdapter prestamosAdapter = new PrestamosAdapter(this,Prestamos);

            listView.setAdapter(prestamosAdapter);
        }


    }

}
