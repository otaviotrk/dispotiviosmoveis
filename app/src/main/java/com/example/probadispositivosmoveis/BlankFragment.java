package com.example.probadispositivosmoveis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.room.Room;

import com.example.probadispositivosmoveis.databinding.FragmentBlankBinding;

public class BlankFragment extends Fragment {

    FragmentBlankBinding binding;

    public BlankFragment(){
        super(R.layout.fragment_blank);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBlankBinding.inflate(inflater, container, false);
        AppBanco db = Room.databaseBuilder(this.getContext(), AppBanco.class, "database-name").allowMainThreadQueries().build();
        TextosDao textosDao = db.textosDao();
        Button botaoAtualizar = binding.button3;
        Button botaoExcluir = binding.button4;
        Textos texto = new Textos();
        TextView texto1 = binding.textView;
        TextView texto2 = binding.textView2;
        botaoAtualizar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                texto.id = texto.id+1;
                texto.titulo = texto1.getText().toString();
                texto.texto = texto2.getText().toString();
                textosDao.inserir(texto);
                Navigation.createNavigateOnClickListener(R.id.fragmento, null);
            }
        });
        botaoExcluir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                textosDao.deletar(texto);
                Navigation.createNavigateOnClickListener(R.id.fragmento, null);
            }
        });

        return binding.getRoot();
    }
}
