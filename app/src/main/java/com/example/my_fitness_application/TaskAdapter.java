package com.example.my_fitness_application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<ScheduledTasks> scheduledTasks;

    public TaskAdapter(Context c, ArrayList<ScheduledTasks> p){
        this.context = c;
        this.scheduledTasks = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.scheduled_task,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.taskTitle.setText(scheduledTasks.get(position).getTaskTitle());
        holder.taskDate.setText(scheduledTasks.get(position).getTaskDate());
        holder.taskDesc.setText(scheduledTasks.get(position).getTaskDesc());
    }

    @Override
    public int getItemCount() {
        return scheduledTasks.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView taskTitle, taskDate, taskDesc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            taskTitle = (TextView) itemView.findViewById(R.id.tvTaskTitle);
            taskDate = (TextView) itemView.findViewById(R.id.tvTaskDate);
            taskDesc = (TextView) itemView.findViewById(R.id.tvTaskDesc);
        }
    }


}
