package com.example.probadispositivosmoveis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.room.Room;

import com.example.probadispositivosmoveis.databinding.FragmentoBinding;

import java.util.ArrayList;
import java.util.List;

public class Fragmento extends Fragment {

    FragmentoBinding binding;

    public Fragmento(){
        super(R.layout.fragmento);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentoBinding.inflate(inflater, container, false);
        AppBanco db = Room.databaseBuilder(this.getContext(), AppBanco.class, "database-name").allowMainThreadQueries().build();
        TextosDao textosDao = db.textosDao();
        ArrayList<Textos> todosostextos = new ArrayList<Textos>();
        ArrayList<String> textos = new ArrayList<String>();
        for (Textos texto : todosostextos) {
            textos.add(String.valueOf(texto));
        }
        ArrayAdapter<Adapter> adapter;
        //eu sei que teria que usar o R.android.layout no adapter, porém não tá funcionando aqui nesse pc
        adapter = new ArrayAdapter<Adapter>(this.getContext(), R.layout.fragmento);
        ListView listView = binding.listview;
        listView.setAdapter(adapter);
        Button botaoSalvar = binding.button;
        Button botaoExcluir = binding.button2;
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Navigation.createNavigateOnClickListener(R.id.blankFragment2, null);
            }
        });
        botaoExcluir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                //textosDao.deletarTudo();
            }
        });
        return binding.getRoot();
    }
}
