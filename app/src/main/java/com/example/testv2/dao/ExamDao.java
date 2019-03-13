package com.example.testv2.dao;

import com.example.testv2.model.Exam;

import java.util.Date;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ExamDao {
    @Query("Select * from exam")
    LiveData<List<Exam>> getAllExams();

    @Query("SELECT * FROM exam where date>= :date")
    LiveData<List<Exam>> getCurrentExam(Date date);



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertExam(Exam exam);

    @Delete
    void delete(Exam exam);

    @Query("delete from exam")
    void deleteAll();
}
