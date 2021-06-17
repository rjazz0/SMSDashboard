package com.rjasso.smsdashboard.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SpamDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Spam message);

    @Delete
    void delete(Spam message);

    @Query("DELETE FROM Spam")
    void deleteAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAll(List<Spam> messages);

    @Query("SELECT * FROM Spam")
    List<Spam> getAll();
}