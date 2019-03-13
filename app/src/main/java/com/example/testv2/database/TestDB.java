package com.example.testv2.database;

import android.content.Context;
import android.os.AsyncTask;

import com.example.testv2.dao.ClassDao;
import com.example.testv2.dao.ExamDao;
import com.example.testv2.dao.TaskDao;
import com.example.testv2.model.ClassEntry;
import com.example.testv2.model.Exam;
import com.example.testv2.model.Task;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Exam.class, Task.class, ClassEntry.class}, version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class TestDB extends RoomDatabase {
    public static Object LOCK=new Object();
    private static TestDB testV1;

    public static synchronized TestDB getInstance(Context context){
        if(testV1==null){
            synchronized (LOCK){
                if (testV1==null)
                    testV1= Room.databaseBuilder(context.getApplicationContext(), TestDB.class,"testdb" ).addCallback(sRoomDatabaseCallback).build();
            }
        }
        return testV1;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(testV1).execute();
                }
            };

    public abstract TaskDao getTaskDao();
    public abstract ClassDao getClassDao();

}

 class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final ClassDao mDao;

    PopulateDbAsync(TestDB db) {
        mDao = db.getClassDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
        ClassEntry classEntry=new ClassEntry("subject1", "rooom11", null, false, null, null, null);
        mDao.insert(classEntry);
        classEntry=new ClassEntry("subject122", "rooom1122", null, false, null, null, null);
        mDao.insert(classEntry);
        return null;
    }
}