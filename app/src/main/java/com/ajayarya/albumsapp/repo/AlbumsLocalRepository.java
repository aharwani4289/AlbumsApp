package com.ajayarya.albumsapp.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.ajayarya.albumsapp.model.Album;

import java.util.List;

public class AlbumsLocalRepository {

    private static AlbumsLocalRepository sInstance;
    private final ApplicationDatabase mDatabase;

    private MutableLiveData<Album> albumLiveData;

    private AlbumsLocalRepository(final ApplicationDatabase database) {
        mDatabase = database;
        albumLiveData = new MutableLiveData<>();
    }

    public static AlbumsLocalRepository getInstance() {
        if (sInstance == null) {
            synchronized (AlbumsLocalRepository.class) {
                if (sInstance == null) {
                    sInstance = new AlbumsLocalRepository(ApplicationDatabase.getInstance());
                }
            }
        }
        return sInstance;
    }

    public LiveData<Album> getAlbumLiveData(long id ){
        return mDatabase.albumDao().getAlbumLiveData( id );
    }

    public LiveData<Album> getAlbumsLiveData(){
        return mDatabase.albumDao().getAlbumsLiveData();
    }

    public void insertAlbums(List<Album> albums){
        mDatabase.albumDao().insertAlbums(albums);
    }


}
