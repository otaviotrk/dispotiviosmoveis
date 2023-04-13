package com.example.probadispositivosmoveis;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Textos {
    @PrimaryKey
    public int id;
    public String titulo;
    public String texto;
}
