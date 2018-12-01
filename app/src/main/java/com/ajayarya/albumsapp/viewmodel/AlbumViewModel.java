package com.ajayarya.albumsapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.ajayarya.albumsapp.model.Album;
import com.ajayarya.albumsapp.repo.AlbumsLocalRepository;

public class AlbumViewModel extends ViewModel {

    public LiveData<Album> getAlbumLiveData() {
        return AlbumsLocalRepository.getInstance().getAlbumLiveData(0);
    }

    public LiveData<Album> getAlbumsLiveData() {
        return AlbumsLocalRepository.getInstance().getAlbumsLiveData();
    }
}
