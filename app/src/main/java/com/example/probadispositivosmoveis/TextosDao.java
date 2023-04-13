package com.example.probadispositivosmoveis;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TextosDao {

    // deixei como observação pois não lembro direito como faz o Query

    //@Query("SELECT * FROM textos")
    //List<Textos> TextosDao.pegarTudo();

   // @Query ("DELETE FROM textos")
    //TextosDao textosDao = deletarTudo();

    @Insert
    void inserir(Textos textos);

    @Delete
    void deletar(Textos textos);
}
