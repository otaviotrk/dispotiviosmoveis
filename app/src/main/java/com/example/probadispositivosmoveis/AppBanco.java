package com.example.probadispositivosmoveis;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database (entities = {Textos.class}, version = 1)
public abstract class AppBanco extends RoomDatabase {
    public abstract TextosDao textosDao();
}

