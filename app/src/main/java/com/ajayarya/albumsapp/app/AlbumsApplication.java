package com.ajayarya.albumsapp.app;

import android.app.Application;

public class AlbumsApplication extends Application {

    private static AlbumsApplication sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }

    public static AlbumsApplication getAppContext(){
        return sContext;
    }

}
