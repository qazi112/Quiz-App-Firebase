package com.example.quiz_app.adapters;
import com.example.quiz_app.activities.QuizActivity;
import com.example.quiz_app.utils.ColorPicker;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.widget.TintTypedArray;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz_app.R;
import com.example.quiz_app.models.Quiz;
import com.example.quiz_app.utils.IconPicker;

import java.util.ArrayList;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder>{
    private ArrayList<Quiz> data;
    private Context context;

    public QuizAdapter(Context context,ArrayList<Quiz> quiz){
        this.data = quiz;
        this.context = context;
    }

    @Override
    public QuizViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.quiz_item_layout,parent,false);

        return new QuizViewHolder(view);
    }

    @Override
    public void onBindViewHolder( QuizViewHolder holder, int position) {
        String title = data.get(position).title;
        holder.text_title.setText(title);
        holder.card.setCardBackgroundColor(Color.parseColor(ColorPicker.getColor()));
        holder.image_quiz.setImageResource(IconPicker.getIcon());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,""+data.get(position).title,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, QuizActivity.class);
                // send particular quiz title
                intent.putExtra("DATE",data.get(position).title);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class QuizViewHolder extends RecyclerView.ViewHolder{
        TextView text_title;
        ImageView image_quiz;
        CardView card;
        public QuizViewHolder( View itemView) {
            super(itemView);
            text_title = itemView.findViewById(R.id.card_quiz_text);
            image_quiz = itemView.findViewById(R.id.card_quiz_image);
            card = itemView.findViewById(R.id.card_quiz_list);
        }
    }
}
