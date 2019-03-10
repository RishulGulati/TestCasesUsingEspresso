package com.example.testcasesusingespresso.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.testcasesusingespresso.R;
import com.example.testcasesusingespresso.adapter.CourseAdapter;
import com.example.testcasesusingespresso.model.Courses;

import java.util.ArrayList;
import java.util.List;

public class CoursesDetailsActivity extends AppCompatActivity {

    String arrShort[] = {"B.A.C", "B.A.St", "B.A.Ec", "B.A.C", "B.A.So", "B.A.P",
            "B.A.En", "B.A.P.S", "B.A.P", "B.A.G", "B.A.M"};

    String arrLong[] = {" B.A. Programme in Computer Science",
            "B.A. Programme in Statistics",
            "B.A. Programme in Economics",
            "B.A. Programme in Commerce",
            "B.A. Programme in Sociology",
            "B.A. Programme in Philosophy",
            "B.A. Programme in English",
            "B.A. Programme in Political Science",
            "B.A. Programme in Psychology",
            "B.A. Programme in Geography",
            "B.A. Programme in Mathematics"};

    int imageId[] = {R.drawable.no_image, R.drawable.no_image, R.drawable.no_image, R.drawable.no_image,
            R.drawable.no_image, R.drawable.no_image, R.drawable.no_image, R.drawable.no_image,
            R.drawable.no_image, R.drawable.no_image, R.drawable.no_image};
    RecyclerView recyclerView;

    List<Courses> list;
    CourseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_details);

        getIntent().getStringExtra("STUDENT_DETAILS");

        recyclerView = findViewById(R.id.recyclerViewCources);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(CoursesDetailsActivity.this,SummaryPageActivity.class);
//                startActivity(intent);
            }
        });

        list = new ArrayList<Courses>();         //initializing the list object
        for (int i = 0; i < arrLong.length; i++) {
            Courses obj = new Courses(arrShort[i], arrLong[i], imageId[i]);
            list.add(obj);
        }

        adapter = new CourseAdapter(CoursesDetailsActivity.this, list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

    }
}
