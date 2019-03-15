package com.example.testv2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testv2.DetailActivity;
import com.example.testv2.R;
import com.example.testv2.model.ClassEntry;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassViewHolder> {

    List<ClassEntry> mClassList;
    Context mContext;
    ClassEntry current;
    public ClassAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ClassViewHolder(LayoutInflater.from(mContext).inflate(R.layout.card_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        if(mClassList!=null){
            current=mClassList.get(position);
            holder.description.setText(current.getSubject());
            holder.title.setText(current.getRoom());
        }

    }

    @Override
    public int getItemCount() {
        if (mClassList==null)
            return 0;
        return mClassList.size();
    }


    public void setmClassList(List<ClassEntry> mClassList) {
        this.mClassList = mClassList;
    }

    public class ClassViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        final TextView title;
        final TextView description;

        public ClassViewHolder(View inflate) {
            super(inflate);
            inflate.setOnClickListener(this);
            title = inflate.findViewById(R.id.card_title);
            description=inflate.findViewById(R.id.card_descriptio);
        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(v.getContext(), DetailActivity.class);
            intent.setAction("CLASS");
            intent.putExtra("ID", current.getId());
            v.getContext().startActivity(intent);
        }
    }
}
