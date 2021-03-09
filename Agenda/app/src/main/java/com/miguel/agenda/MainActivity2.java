package com.miguel.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {

    EditText nombre;
    EditText email;
    Button grabar;
    Button agenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        grabar = findViewById(R.id.grabar);
        agenda = findViewById(R.id.agenda);
        nombre = findViewById(R.id.nombre);
        email = findViewById(R.id.email);

        grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contacto c = new Contacto(nombre.getText().toString(),email.getText().toString());
                AccesoFirebase.grabarContacto(c);
                nombre.setText("");
                email.setText("");
            }
        });

        agenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}