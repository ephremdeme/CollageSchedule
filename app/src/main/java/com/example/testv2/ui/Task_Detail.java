package com.example.testv2.ui;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.testv2.R;
import com.example.testv2.model.Task;
import com.example.testv2.viewModel.TaskDetailViewModel;

public class Task_Detail extends Fragment {

    private TextView subject;
    private SeekBar progress;
    private TextView detail;
    private TextView type;
    private TextView dueDate;
    private TextView progressText;
    private static int id;

    private TaskDetailViewModel mViewModel;

    public static Task_Detail newInstanc() {
        return new Task_Detail();

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.task__detail_fragment, container, false);
        subject=root.findViewById(R.id.task_detail_subject);
        progress=root.findViewById(R.id.task_progress);
        detail=root.findViewById(R.id.task_detail_detail);
        type=root.findViewById(R.id.task_detail_type);
        dueDate=root.findViewById(R.id.task_detail_duedate);
        progressText=root.findViewById(R.id.progress_text);

        progressText.setText("0% complete ");

        id=getArguments().getInt("ID");

        progress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int pprogress, boolean fromUser) {
                progressText.setText(pprogress +"% complete");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return  root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TaskDetailViewModel.class);
        mViewModel.getTaskById(id).observe(this, new Observer<Task>() {
            @Override
            public void onChanged(Task tasks) {
                System.out.println(tasks.getDetail());
                bindToUI(tasks);
            }
        });

        // TODO: Use the ViewModel
    }

    public void bindToUI(Task task){
        subject.setText(task.getSubject());
        progress.setProgress(task.getProgress());
        detail.setText(task.getDetail());
        type.setText(task.getType());
        dueDate.setText("monday morning");
    }
}
