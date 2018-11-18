package com.rozadin.motivationalquote;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

@android.arch.persistence.room.Database(entities = {Room_List.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract DAO_List getPersonDao();
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}
