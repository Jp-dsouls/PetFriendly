package com.utp.petfriendly.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.utp.petfriendly.R;
import com.utp.petfriendly.model.AdopcionModel;
import com.utp.petfriendly.util.Constante;
import com.utp.petfriendly.viewModel.AdopcionViewModel;

import java.util.List;
import java.util.UUID;

public class WelcomeActivity extends AppCompatActivity {

    private CardView cardStart;
    private FirebaseDatabase database;
    private AdopcionViewModel adopcionViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        adopcionViewModel = new ViewModelProvider(this).get(AdopcionViewModel.class);

        cardStart = findViewById(R.id.cardStart);
        cardStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(WelcomeActivity.this, HomeActivity.class);
                startActivity(myIntent);
            }
        });

        database = FirebaseDatabase.getInstance();
       // obtenerAdopcion();
       // obtenerAdopcionFireBase();
        //crearAdopcion();
    }

    //TEST OBTENER DATA DE FIREBASE
    private void obtenerAdopcionFireBase() {

       /* DatabaseReference ref = FirebaseDatabase.getInstance(Constante.URL_DATABASEFIRE).getReference().child(Constante.TABLA_ADOPCION);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("onDataChange", "dataa");

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    AdopcionModel adopcionModel = postSnapshot.getValue(AdopcionModel.class);
                    Log.e("onDataChange", " : " + adopcionModel.toString());
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("TAG", "loadPost:onCancelled", databaseError.toException());
            }
        });*/
    }

    //TEST CREAR DATA EN FIREBASE
    private void crearAdopcion(){
        DatabaseReference reference = database.getReference("adopcion");
        UUID uuid1 = UUID.randomUUID();

        AdopcionModel adopcionModel1 = new AdopcionModel();
        adopcionModel1.setRaza("Dálmata");
        adopcionModel1.setDescripcion("El dálmata es una raza canina que debe su nombre a la histórica región de Dalmacia. Su característica principal es su singular pelaje moteado de color negro, hígado o limón. Al nacer, las crías carecen de manchas, las cuales van apareciendo por todo su cuerpo durante el primer año de vida");
        adopcionModel1.setEspecialidad("Juguetón, Amigable");
        adopcionModel1.setRangoEdad("10-13 años");
        adopcionModel1.setTamanio("10-14 Lbs");
        adopcionModel1.setImagen("");
        adopcionModel1.setTipo(1);
        reference.child(uuid1.toString()).setValue(adopcionModel1);

        UUID uuid2 = UUID.randomUUID();
        AdopcionModel adopcionModel2 = new AdopcionModel();
        adopcionModel2.setRaza("Chihuahua");
        adopcionModel2.setDescripcion("El dálmata es una raza canina que debe su nombre a la histórica región de Dalmacia. Su característica principal es su singular pelaje moteado de color negro, hígado o limón. Al nacer, las crías carecen de manchas, las cuales van apareciendo por todo su cuerpo durante el primer año de vida");
        adopcionModel2.setEspecialidad("Juguetón, Amigable");
        adopcionModel2.setRangoEdad("10-13 años");
        adopcionModel2.setTamanio("10-14 Lbs");
        adopcionModel2.setImagen("");
        adopcionModel2.setTipo(1);
        reference.child(uuid2.toString()).setValue(adopcionModel2);

        UUID uuid3 = UUID.randomUUID();
        AdopcionModel adopcionModel3 = new AdopcionModel();
        adopcionModel3.setRaza("Pitbull");
        adopcionModel3.setDescripcion("El dálmata es una raza canina que debe su nombre a la histórica región de Dalmacia. Su característica principal es su singular pelaje moteado de color negro, hígado o limón. Al nacer, las crías carecen de manchas, las cuales van apareciendo por todo su cuerpo durante el primer año de vida");
        adopcionModel3.setEspecialidad("Juguetón, Amigable");
        adopcionModel3.setRangoEdad("10-13 años");
        adopcionModel3.setTamanio("10-14 Lbs");
        adopcionModel3.setImagen("");
        adopcionModel3.setTipo(1);
        reference.child(uuid3.toString()).setValue(adopcionModel3);

        UUID uuid4 = UUID.randomUUID();
        AdopcionModel adopcionModel4 = new AdopcionModel();
        adopcionModel4.setRaza("Russell Terrier");
        adopcionModel4.setDescripcion("El dálmata es una raza canina que debe su nombre a la histórica región de Dalmacia. Su característica principal es su singular pelaje moteado de color negro, hígado o limón. Al nacer, las crías carecen de manchas, las cuales van apareciendo por todo su cuerpo durante el primer año de vida");
        adopcionModel4.setEspecialidad("Juguetón, Amigable");
        adopcionModel4.setRangoEdad("10-13 años");
        adopcionModel4.setTamanio("10-14 Lbs");
        adopcionModel4.setImagen("");
        adopcionModel4.setTipo(1);
        reference.child(uuid4.toString()).setValue(adopcionModel4);

        UUID uuid5 = UUID.randomUUID();
        AdopcionModel adopcionModel5 = new AdopcionModel();
        adopcionModel5.setRaza("Golden Retriever");
        adopcionModel5.setDescripcion("El dálmata es una raza canina que debe su nombre a la histórica región de Dalmacia. Su característica principal es su singular pelaje moteado de color negro, hígado o limón. Al nacer, las crías carecen de manchas, las cuales van apareciendo por todo su cuerpo durante el primer año de vida");
        adopcionModel5.setEspecialidad("Juguetón, Amigable");
        adopcionModel5.setRangoEdad("10-13 años");
        adopcionModel5.setTamanio("10-14 Lbs");
        adopcionModel5.setImagen("");
        adopcionModel5.setTipo(1);
        reference.child(uuid5.toString()).setValue(adopcionModel5);
    }



}