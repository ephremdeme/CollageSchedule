package com.example.testv2;


import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.testv2.model.Task;
import com.example.testv2.viewModel.TaskDetailViewModel;
import com.example.testv2.viewModel.TaskViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddTaskFragment extends Fragment {

    SimpleDateFormat format=new SimpleDateFormat("E, dd MMM yyyy");
    final String[] date = new String[1];
    Spinner subject;
    Spinner type;
    EditText title;
    EditText detail;
    TextView dueDate;

    TextView save;

    public AddTaskFragment() {
        // Required empty public constructor
    }


    public static AddTaskFragment newInstanc() {
        return new AddTaskFragment();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_add_task, container, false);
        subject=view.findViewById(R.id.subject);
        type=view.findViewById(R.id.type);

        title=view.findViewById(R.id.title);

        detail=view.findViewById(R.id.detail);

        dueDate=view.findViewById(R.id.duedate);

        save=view.findViewById(R.id.save);

        Calendar calendar=Calendar.getInstance();

        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DATE);

        date[0] =year+"-"+ month+ "-"+ day;

        List<String> categories = new ArrayList<String>();
        categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, categories);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        subject.setAdapter(adapter);
        type.setAdapter(adapter);



        Toolbar toolbar=view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);

        DatePickerDialog datePickerDialog=new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                date[0] =year+"-"+ month+ "-"+ dayOfMonth;
                try {
                    dueDate.setText(format.format(sdf1.parse(date[0])));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        },  year, month, day);



        dueDate.setText(format.format(new Date()));

        dueDate.setOnClickListener(v -> datePickerDialog.show());

        save.setOnClickListener(v -> {
            insertTask();
            getActivity().finish();
        });

        return view;
    }


    public  void  insertTask(){

        if (TextUtils.isEmpty(title.getText()) && TextUtils.isEmpty(detail.getText())){

        }else{
            Task task=new Task();
            task.setDetail(detail.getText().toString());
            task.setType("subjectTest");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                task.setDueDate(sdf1.parse(date[0]));
            } catch (ParseException e) {
                e.printStackTrace();
                task.setDueDate(new Date());
            }
            task.setProgress(34);
            task.setSubject(title.getText().toString());
            TaskViewModel mViewModel = ViewModelProviders.of(this).get(TaskViewModel.class);
            mViewModel.insert(task);


        }
    }



}
