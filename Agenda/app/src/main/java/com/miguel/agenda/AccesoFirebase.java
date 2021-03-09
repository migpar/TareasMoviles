package com.miguel.agenda;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AccesoFirebase {

    private static FirebaseDatabase database;

    public static void grabarContacto(Contacto c){
        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("contactos");
        myRef.push().setValue(c);
    }

    public static void getContactos(final IRecuperarDatos callback) {
        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("contactos");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Contacto> contactos=new ArrayList<Contacto>();
                Iterable<DataSnapshot> datos=dataSnapshot.getChildren();
                while(datos.iterator().hasNext())
                {
                    DataSnapshot d=datos.iterator().next();
                    Contacto c=d.getValue(Contacto.class);
                    contactos.add(c);

                }
                callback.recuperarCiudades(contactos);
                //Ya tengo el ArrayList releno, así que se lo pasaré a la clase principal
                //para rellenar el ArrayList de rutas con el que relleno el spinner
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public interface IRecuperarDatos
    {
        public void recuperarCiudades(ArrayList<Contacto> lista_rutas);
    }

}
