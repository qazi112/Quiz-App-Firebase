package com.example.quiz_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

public class ProgrammingAdaptor extends RecyclerView.Adapter<ProgrammingAdaptor.ProgrammingViewHolder> {
    private String[] data;

    public ProgrammingAdaptor(String[] data){
        this.data = data;
    }
    @Override
    public ProgrammingViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
       LayoutInflater inflater = LayoutInflater.from(parent.getContext());
       View view = inflater.inflate(R.layout.view_recycler,parent,false);
       return new ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ProgrammingViewHolder holder, int position) {
        String title = data[position];
        holder.text.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }
    // ViewHolder added
    public  class ProgrammingViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView text;
        public ProgrammingViewHolder( View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.listImage);
            text = itemView.findViewById(R.id.list_title);
        }
    }
}
