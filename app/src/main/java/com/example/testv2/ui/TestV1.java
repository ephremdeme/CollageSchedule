package com.example.testv2.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testv2.database.TestDB;
import com.example.testv2.model.ClassEntry;
import com.example.testv2.repository.ClassRepository;
import com.example.testv2.viewModel.ClassViewModel;
import com.example.testv2.R;
import com.example.testv2.adapter.ClassAdapter;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestV1 extends Fragment {

    ClassViewModel viewModel;
    TestDB testDB;
    ClassRepository repository;

    public TestV1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_test_v1, container, false);

        RecyclerView recyclerView=view.findViewById(R.id.recyclerView);

        testDB=TestDB.getInstance(getContext());

        final ClassAdapter classAdapter=new ClassAdapter(getContext());

        recyclerView.setAdapter(classAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        viewModel= ViewModelProviders.of(this).get(ClassViewModel.class);
        System.out.println(testDB.getClassDao().getAllClass().getValue()+ "test classs");
        viewModel.getmAllClass().observe(this, new Observer<List<ClassEntry>>() {
            @Override
            public void onChanged(List<ClassEntry> classEntries) {
                classAdapter.setmClassList(classEntries);
            }
        });
        return view;
    }

}
