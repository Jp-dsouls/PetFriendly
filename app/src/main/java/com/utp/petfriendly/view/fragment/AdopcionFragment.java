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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
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
import com.utp.petfriendly.viewModel.AdopcionViewModel;

import java.util.ArrayList;
import java.util.List;


public class AdopcionFragment extends Fragment {

    private AdopcionAdapter adapter;
    private List<AdopcionModel> list;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayout;
    private AdopcionViewModel adopcionViewModel;

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
        adopcionViewModel = new ViewModelProvider(this).get(AdopcionViewModel.class);
        setToolbar(view);

        recyclerView = view.findViewById(R.id.rv_adopcion);
        linearLayout = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayout);
        list = new ArrayList<>();
        adapter = new AdopcionAdapter(getContext());
        recyclerView.setAdapter(adapter);

        obtenerAdopcion();
    }

    private void obtenerAdopcion(){
        adopcionViewModel.obtenerAdopcion().observe(getActivity(), new Observer<List<AdopcionModel>>() {
            @Override
            public void onChanged(List<AdopcionModel> adopcionModels) {
                if(!adopcionModels.isEmpty()){
                    adapter.setItemAdopcion(adopcionModels);
                }
            }
        });
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