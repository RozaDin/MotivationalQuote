package com.rozadin.motivationalquote;

import android.app.Application;
import android.arch.persistence.room.Room;

public class App extends Application {
    public static App instance;

    private Database database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(getApplicationContext(), Database.class, "List.sql").build();
    }

    public static App getInstance() {
        return instance;
    }

    public Database getDatabase() {
        return database;
    }
}
