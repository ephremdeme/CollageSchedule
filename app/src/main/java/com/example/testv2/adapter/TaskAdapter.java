package com.example.testv2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testv2.R;
import com.example.testv2.model.Task;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    public Context mContext;
    public List<Task> allTask;
    public Task task;

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

        public TaskViewHolder(View inflate) {
            super(inflate);
            title = inflate.findViewById(R.id.card_title);
            description=inflate.findViewById(R.id.card_descriptio);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
