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

import com.example.testv2.AppExecutors;
import com.example.testv2.R;
import com.example.testv2.adapter.TaskAdapter;
import com.example.testv2.database.TestDB;
import com.example.testv2.model.Task;
import com.example.testv2.repository.TaskRepository;
import com.example.testv2.viewModel.TaskViewModel;
import com.example.testv2.viewModel.TaskViewModelFactory;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestV2 extends Fragment {


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
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        TaskViewModelFactory factory=new TaskViewModelFactory(TaskRepository.getInstance(TestDB.getInstance(getContext()).getTaskDao(), AppExecutors.getInstance()));

        TaskViewModel viewModel= ViewModelProviders.of(this, factory).get(TaskViewModel.class);
        viewModel.getAllTask().observe(this, tasks -> adapter.setAllTask(tasks));
        return root;
    }

}
