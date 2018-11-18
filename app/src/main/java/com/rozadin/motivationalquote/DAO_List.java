package com.rozadin.motivationalquote;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DAO_List {

    // Добавление в бд
    @Insert
    void insertAll(Room_List... list);

    // Удаление из бд
    @Delete
    void delete(Room_List list);

    // Получение всех из бд
    @Query("SELECT * FROM List")
    List<Room_List> getAll();

    // Получение всех Person из бд с условием
    @Query("SELECT * FROM List WHERE id = :id")
    List<Room_List> getById(int id);

    @Query("SELECT COUNT() FROM List")
    int getCount();
}
