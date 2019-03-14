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

import com.example.testv2.R;
import com.example.testv2.adapter.TaskAdapter;
import com.example.testv2.database.TestDB;
import com.example.testv2.model.Task;
import com.example.testv2.viewModel.TaskViewModel;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestV2 extends Fragment {

    TestDB testDB;


    public TestV2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_test_v2, container, false);
        RecyclerView recyclerView=root.findViewById(R.id.task_recycler_view);

        TaskAdapter adapter=new TaskAdapter(getContext());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));


        TaskViewModel viewModel= ViewModelProviders.of(this).get(TaskViewModel.class);
        System.out.println(viewModel.repository.getAllTask()+"from view");
        //viewModel.initialize();
        viewModel.getAllTask().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {
                adapter.setAllTask(tasks);
                System.out.println(tasks.size() +"from ob");
            }
        });

        return root;
    }

}
