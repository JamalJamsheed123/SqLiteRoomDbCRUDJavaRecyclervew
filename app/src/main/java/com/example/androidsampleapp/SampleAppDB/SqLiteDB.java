package com.example.androidsampleapp.SampleAppDB;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.androidsampleapp.DaoClass.Daoclass;
import com.example.androidsampleapp.EntityClass.PurchaseModel;

@Database(entities = {PurchaseModel.class}, version = 1)
public abstract class SqLiteDB extends RoomDatabase {


    public abstract Daoclass getDao();

    private static SqLiteDB instance;


    public static SqLiteDB getDatabase(final Context context) {
        if (instance == null) {
            synchronized (SqLiteDB.class) {
                instance = Room.databaseBuilder(context, SqLiteDB.class, "SampleAppDB").allowMainThreadQueries().build();
            }
        }
        return instance;


    }

}
