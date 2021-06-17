package com.rjasso.smsdashboard.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import java.util.List;

@Dao
public interface InboxDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Inbox message);

    @Delete
    void delete(Inbox message);

    @Query("DELETE FROM Inbox")
    void deleteAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public List<Long> insertAll(List<Inbox> messages);

    @Query("SELECT * FROM Inbox")
    List<Inbox> getAll();
}