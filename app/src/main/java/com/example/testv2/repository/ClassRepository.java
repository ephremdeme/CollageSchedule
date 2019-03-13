package com.example.testv2.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.testv2.AppExecutors;
import com.example.testv2.dao.ClassDao;
import com.example.testv2.database.TestDB;
import com.example.testv2.model.ClassEntry;

import java.util.List;

import androidx.lifecycle.LiveData;

public class ClassRepository {

    private static ClassDao classDao;
    private LiveData<List<ClassEntry>> mAllWords;
    private static AppExecutors executors;

    private static   ClassRepository instance;
    private static Object LOCK =new Object();

    private  ClassRepository(ClassDao classDao, AppExecutors executors) {
        this.classDao = classDao;
        this.executors=executors;
        executors.diskIO().execute(()->{
                    mAllWords = this.classDao.getAllClass();
                });

    }

    public static ClassRepository getInstance( ClassDao classDao, AppExecutors executors){
        if (instance ==null){
            synchronized (LOCK){
                instance=new ClassRepository(classDao, executors);
                return instance;
            }
        }
        return instance;
    }

    public LiveData<List<ClassEntry>> getAllWords() {
        return mAllWords;
    }


    public void insert (ClassEntry word) {
        executors.diskIO().execute(()->{
            classDao.insert(word);
        });
    }


}