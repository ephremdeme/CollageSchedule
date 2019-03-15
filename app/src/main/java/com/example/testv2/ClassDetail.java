package com.example.testv2;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testv2.model.ClassEntry;

import org.w3c.dom.Text;

public class ClassDetail extends Fragment {

    private ClassDetailViewModel mViewModel;

    private TextView subject;
    private TextView room;
    private TextView building;
    private TextView time;
    private TextView date;
    private int id;


    public static ClassDetail newInstance() {
        return new ClassDetail();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.class_detail_fragment, container, false);

        subject=view.findViewById(R.id.class_detail_subject);
        room=view.findViewById(R.id.class_detail_room);
        building=view.findViewById(R.id.class_detail_building);
        time=view.findViewById(R.id.class_detail_time);
        date=view.findViewById(R.id.class_detail_date);

        id=getArguments().getInt("ID");

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ClassDetailViewModel.class);
        mViewModel.getClassById(id).observe(this, new Observer<ClassEntry>() {
            @Override
            public void onChanged(ClassEntry classEntry) {
                bindToUI(classEntry);
            }
        });
    }

    void bindToUI(ClassEntry classEntry){
        subject.setText(classEntry.getSubject());
        room.setText(classEntry.getRoom());
        building.setText(classEntry.getBuilding());
        time.setText("test time");
        date.setText(classEntry.getDays());
    }
}
