package com.utp.petfriendly.view.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.utp.petfriendly.R;
import com.utp.petfriendly.model.AdopcionModel;
import com.utp.petfriendly.view.adapter.AdopcionAdapter;

import java.util.ArrayList;
import java.util.List;


public class AdopcionFragment extends Fragment {

    private AdopcionAdapter adapter;
    private List<AdopcionModel> list;

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayout;
    private FragmentManager fragmentManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_adopcion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setToolbar(view);

        recyclerView = view.findViewById(R.id.rv_adopcion);
        linearLayout = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayout);
        list = new ArrayList<>();
        adapter = new AdopcionAdapter(getContext());
        recyclerView.setAdapter(adapter);

        loadAdopcion();
    }

    private void loadAdopcion(){
        List<AdopcionModel> list = new ArrayList<>();

        AdopcionModel adopcionModel1 = new AdopcionModel();
        adopcionModel1.setRaza("Dálmata");
        adopcionModel1.setDescripcion("El dálmata es una raza canina que debe su nombre a la histórica región de Dalmacia. Su característica principal es su singular pelaje moteado de color negro, hígado o limón. Al nacer, las crías carecen de manchas, las cuales van apareciendo por todo su cuerpo durante el primer año de vida");
        adopcionModel1.setEspecialidad("Juguetón, Amigable");
        adopcionModel1.setRangoEdad("10-13 años");
        adopcionModel1.setTamanio("10-14 Lbs");
        list.add(adopcionModel1);

        AdopcionModel adopcionModel2 = new AdopcionModel();
        adopcionModel2.setRaza("Chihuahua");
        adopcionModel2.setDescripcion("El dálmata es una raza canina que debe su nombre a la histórica región de Dalmacia. Su característica principal es su singular pelaje moteado de color negro, hígado o limón. Al nacer, las crías carecen de manchas, las cuales van apareciendo por todo su cuerpo durante el primer año de vida");
        adopcionModel2.setEspecialidad("Juguetón, Amigable");
        adopcionModel2.setRangoEdad("10-13 años");
        adopcionModel2.setTamanio("10-14 Lbs");
        list.add(adopcionModel2);

        AdopcionModel adopcionModel3 = new AdopcionModel();
        adopcionModel3.setRaza("Pitbull");
        adopcionModel3.setDescripcion("El dálmata es una raza canina que debe su nombre a la histórica región de Dalmacia. Su característica principal es su singular pelaje moteado de color negro, hígado o limón. Al nacer, las crías carecen de manchas, las cuales van apareciendo por todo su cuerpo durante el primer año de vida");
        adopcionModel3.setEspecialidad("Juguetón, Amigable");
        adopcionModel3.setRangoEdad("10-13 años");
        adopcionModel3.setTamanio("10-14 Lbs");
        list.add(adopcionModel3);

        AdopcionModel adopcionModel4 = new AdopcionModel();
        adopcionModel4.setRaza("Russell Terrier");
        adopcionModel4.setDescripcion("El dálmata es una raza canina que debe su nombre a la histórica región de Dalmacia. Su característica principal es su singular pelaje moteado de color negro, hígado o limón. Al nacer, las crías carecen de manchas, las cuales van apareciendo por todo su cuerpo durante el primer año de vida");
        adopcionModel4.setEspecialidad("Juguetón, Amigable");
        adopcionModel4.setRangoEdad("10-13 años");
        adopcionModel4.setTamanio("10-14 Lbs");
        list.add(adopcionModel4);

        AdopcionModel adopcionModel5 = new AdopcionModel();
        adopcionModel5.setRaza("Golden Retriever");
        adopcionModel5.setDescripcion("El dálmata es una raza canina que debe su nombre a la histórica región de Dalmacia. Su característica principal es su singular pelaje moteado de color negro, hígado o limón. Al nacer, las crías carecen de manchas, las cuales van apareciendo por todo su cuerpo durante el primer año de vida");
        adopcionModel5.setEspecialidad("Juguetón, Amigable");
        adopcionModel5.setRangoEdad("10-13 años");
        adopcionModel5.setTamanio("10-14 Lbs");
        list.add(adopcionModel5);

        adapter.setItemAdopcion(list);
    }


    private void setToolbar(View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        final ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setDisplayShowHomeEnabled(true);
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_baseline_arrow_back_24, null);
            drawable = DrawableCompat.wrap(drawable);
            DrawableCompat.setTint(drawable, getResources().getColor(R.color.black));
            ab.setHomeAsUpIndicator(drawable);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}