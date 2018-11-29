package com.ajayarya.albumsapp.repo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.ajayarya.albumsapp.app.AlbumsApplication;
import com.ajayarya.albumsapp.model.Album;

@Database(entities = Album.class, version = 1 , exportSchema = false)
public abstract class ApplicationDatabase extends RoomDatabase {

    private static ApplicationDatabase INSTANCE;


    public static synchronized ApplicationDatabase getInstance(){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(AlbumsApplication.getAppContext(),
                    ApplicationDatabase.class , "application_db")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public abstract AlbumDao albumDao();


}
