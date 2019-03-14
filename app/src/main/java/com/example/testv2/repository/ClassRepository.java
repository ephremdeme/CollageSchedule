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

    private  ClassRepository(Application application) {
        this.classDao = TestDB.getInstance(application).getClassDao();
        this.executors=AppExecutors.getInstance();
        mAllWords=classDao.getAllClass();
    }

    public static ClassRepository getInstance( Application application){
        if (instance ==null){
            synchronized (LOCK){
                instance=new ClassRepository(application);
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