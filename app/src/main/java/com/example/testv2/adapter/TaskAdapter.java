package com.example.testv2.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testv2.DetailActivity;
import com.example.testv2.MainActivity;
import com.example.testv2.R;
import com.example.testv2.model.Task;
import com.example.testv2.ui.TestV2;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    public Context mContext;
    public List<Task> allTask;

    public static Task task;

    public TaskAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new TaskAdapter.TaskViewHolder(LayoutInflater.from(mContext).inflate(R.layout.card_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        if(allTask!=null){
            task=allTask.get(position);
            holder.id=task.getId();
            holder.description.setText(task.getDetail());
            holder.title.setText(task.getSubject());
        }
    }

    @Override
    public int getItemCount() {
        if(allTask!=null)
            return allTask.size();
        return 0;
    }


    public void setAllTask(List<Task> allTask) {
        this.allTask = allTask;
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        final TextView title;
        final TextView description;
        public  int id=0;

        public TaskViewHolder(View inflate) {
            super(inflate);
            inflate.setOnClickListener(this);
            title = inflate.findViewById(R.id.card_title);
            description=inflate.findViewById(R.id.card_descriptio);
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(v.getContext(), DetailActivity.class);
            intent.putExtra("ID", task.getId());
            intent.setAction("TASK");
            v.getContext().startActivity(intent );

        }
    }
}
