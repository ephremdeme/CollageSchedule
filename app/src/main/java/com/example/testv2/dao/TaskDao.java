package com.example.testv2.dao;

import com.example.testv2.model.Task;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface TaskDao {

    @Query("select * from task")
    LiveData<List<Task>> getAllTask();

    @Query("select * from task where id= :id")
    LiveData<Task> getTaskById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Task task);

    @Delete
    void delete(Task task);

    @Query("delete from task")
    void deleteAll();

    @Query("select count(*) from task")
    int count();

}
