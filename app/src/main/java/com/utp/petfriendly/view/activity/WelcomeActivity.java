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
import com.utp.petfriendly.model.TiendaModel;
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
                Intent myIntent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(myIntent);
            }
        });

        database = FirebaseDatabase.getInstance();
      // crearAdopcion();
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
        DatabaseReference reference = database.getReference("productos");

        UUID uuid1 = UUID.randomUUID();
        TiendaModel adopcionModel1 = new TiendaModel();
        adopcionModel1.setNombreProducto("Alimento Cat Chow para Gatos Esterilizados 6 Kg");
        adopcionModel1.setCantidad("100");
        adopcionModel1.setPrecio("116.70");
        adopcionModel1.setCategoria(1);
        adopcionModel1.setImagen("https://firebasestorage.googleapis.com/v0/b/petfriendly-cf1bf.appspot.com/o/catchow-3.jpg?alt=media&token=b51dc2ac-3ca6-4d4e-8494-597713ca7b95");
        reference.child(uuid1.toString()).setValue(adopcionModel1);

        UUID uuid2 = UUID.randomUUID();
        TiendaModel adopcionModel2 = new TiendaModel();
        adopcionModel2.setNombreProducto("Cama Hipoalergénica Cueva");
        adopcionModel2.setCantidad("100");
        adopcionModel2.setPrecio("139.00");
        adopcionModel2.setCategoria(1);
        adopcionModel2.setImagen("https://firebasestorage.googleapis.com/v0/b/petfriendly-cf1bf.appspot.com/o/Cueva-1-1-937x937.png?alt=media&token=67699ecb-fd4b-46af-976d-4547dc33e441");
        reference.child(uuid2.toString()).setValue(adopcionModel2);

        UUID uuid3 = UUID.randomUUID();

        TiendaModel adopcionModel3 = new TiendaModel();
        adopcionModel3.setNombreProducto("Acondicionador pelo grande");
        adopcionModel3.setCantidad("100");
        adopcionModel3.setPrecio("36.90");
        adopcionModel3.setCategoria(2);
        adopcionModel3.setImagen("https://canicat.pe/wp-content/uploads/2022/03/grooming-41.jpg");
        reference.child(uuid3.toString()).setValue(adopcionModel3);

        UUID uuid4 = UUID.randomUUID();
        TiendaModel adopcionModel4 = new TiendaModel();
        adopcionModel4.setNombreProducto("Shampoo Baño seco en espuma Gatos");
        adopcionModel4.setCantidad("100");
        adopcionModel4.setPrecio("29.90");
        adopcionModel4.setCategoria(3);
        adopcionModel4.setImagen("https://canicat.pe/wp-content/uploads/2022/03/grooming-30.jpg");
        reference.child(uuid4.toString()).setValue(adopcionModel4);

        UUID uuid5 = UUID.randomUUID();
        TiendaModel adopcionModel5 = new TiendaModel();
        adopcionModel5.setNombreProducto("Bandana Escocés Can");
        adopcionModel5.setCantidad("100");
        adopcionModel5.setPrecio("9.90");
        adopcionModel5.setCategoria(4);
        adopcionModel5.setImagen("https://canicat.pe/wp-content/uploads/2020/12/ROJO-BANDA-2.png");
        reference.child(uuid5.toString()).setValue(adopcionModel5);
    }

}