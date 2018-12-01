package com.ajayarya.albumsapp.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ajayarya.albumsapp.R;
import com.ajayarya.albumsapp.databinding.ActivityMainBinding;
import com.ajayarya.albumsapp.model.Album;
import com.ajayarya.albumsapp.repo.AlbumsLocalRepository;
import com.ajayarya.albumsapp.viewmodel.AlbumViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ActivityMainBinding mAlbumBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAlbumBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        subscribeAlbums();

        mUIHandler.sendEmptyMessageDelayed(1 , 1000);

    }

    private void subscribeAlbums(){
        AlbumViewModel albumViewModel = ViewModelProviders.of( this ).get( AlbumViewModel.class );
        albumViewModel.getAlbumsLiveData().observe(this , album ->{
            Log.d(TAG , "Received Album Details in Activity " + album);
            mAlbumBinding.setAlbum(album);
        });
    }

    private Handler mUIHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            insertAlbumList();
        }
    };

    private void insertAlbumList(){

        ArrayList<Album> albums = new ArrayList<>();
        Album album = new Album();
        album.setUserId(0);
        album.setTitle("Sunil Nariane");
        album.setId("9000");

        albums.add(album);

        AlbumsLocalRepository.getInstance().insertAlbums(albums);

    }

}
