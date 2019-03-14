package com.example.testv2.viewModel;

import android.app.Application;

import com.example.testv2.model.ClassEntry;
import com.example.testv2.repository.ClassRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class ClassViewModel extends AndroidViewModel {

    ClassRepository repository;
    LiveData<ClassEntry> classEntryLiveData;
    LiveData<List<ClassEntry>> mAllClass;

    public ClassViewModel(Application application) {
        super(application);
        this.repository = ClassRepository.getInstance(application);
        mAllClass=repository.getAllWords();
    }

    public LiveData<List<ClassEntry>> getmAllClass() {
        return mAllClass;
    }

    public void insert(ClassEntry classEntry){
        repository.insert(classEntry);
    }
}
