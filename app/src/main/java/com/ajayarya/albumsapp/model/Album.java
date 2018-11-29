package com.ajayarya.albumsapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Albums")
public class Album {

    public static final String TABLE_NAME = "Albums";
    public static final String COLUMN_USER_ID = "userId";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = COLUMN_USER_ID)
    private long userId;
    private String id;
    private String title;

    @NonNull
    public long getUserId() {
        return userId;
    }

    public void setUserId(@NonNull long userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
