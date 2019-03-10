package com.example.testcasesusingespresso.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testcasesusingespresso.R;
import com.example.testcasesusingespresso.model.Courses;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    Context context;
    List<Courses> list;

    public CourseAdapter(Context context, List<Courses> list) {
        this.context = context;
        this.list = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView tvShort;
        TextView tvLong;

        public ViewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imageViewCourse);
            tvShort = itemView.findViewById(R.id.textViewShort);
            tvLong = itemView.findViewById(R.id.textViewLong);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_design_courses, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Courses obj = list.get(position);            //saving positon data into Course object
        holder.img.setImageResource(obj.getCourseImage());      //setting all the data to holder
        holder.tvShort.setText(obj.getCourseShortName());
        holder.tvLong.setText(obj.getCourseLongName());


        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context, SummaryPageActivity.class);
//
//                String data = obj.getCourseShortName().concat("-->").concat(obj.getCourseLongName());
//                intent.putExtra("DATA_IMAGE", data);
//                intent.putExtra("STUDENT_DETAILS",data);
//                context.startActivity(intent);

            }
        });
        holder.tvLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        holder.tvShort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
