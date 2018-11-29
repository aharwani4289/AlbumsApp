package com.ajayarya.albumsapp.repo;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.ajayarya.albumsapp.model.Album;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface AlbumDao {

    @Insert(onConflict = REPLACE)
    void insertAlbums(List<Album> albums);

    @Query("SELECT * from "+Album.TABLE_NAME +" where userId = :userId")
    LiveData<Album> getAlbumLiveData(long userId);

}
