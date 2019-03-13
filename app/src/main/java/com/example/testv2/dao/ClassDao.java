package com.example.testv2.dao;

import com.example.testv2.model.ClassEntry;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ClassDao {
    @Query("select * from class")
    LiveData<List<ClassEntry>> getAllClass();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ClassEntry classEntry);

    @Delete
    void delete(ClassEntry classEntry);

    @Query("select * from class where id= :id")
    LiveData<ClassEntry> findById(int id);

    @Query("delete from class")
    void deleteAll();
}
