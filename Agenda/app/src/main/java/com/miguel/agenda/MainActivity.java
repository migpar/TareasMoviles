package com.miguel.agenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AccesoFirebase.IRecuperarDatos {

    private RecyclerView myrec;
    private AccesoFirebase.IRecuperarDatos a = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myrec = findViewById(R.id.myrecycler);
        AccesoFirebase.getContactos(a);

    }

    @Override
    public void recuperarCiudades(ArrayList<Contacto> lista) {
        RecyclerView.LayoutManager gestor = new LinearLayoutManager(this);
        MiAdaptador adaptador = new MiAdaptador(lista);
        myrec.setLayoutManager(gestor);
        myrec.setAdapter(adaptador);
    }
}