package com.utp.petfriendly.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.utp.petfriendly.model.VeterinariaModel;
import com.utp.petfriendly.respository.VeterinariaRepositori;
import java.util.List;

public class VeterinariaViewModel extends ViewModel {

    private VeterinariaRepositori vetrepositori;

    public MutableLiveData<List<VeterinariaModel>> obtenerVeterianrias() {
        vetrepositori = new VeterinariaRepositori();
        return vetrepositori.obtenerVeterinarias();
    }

}
