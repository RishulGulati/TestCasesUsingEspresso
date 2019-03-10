package com.example.testcasesusingespresso.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.testcasesusingespresso.R;

public class LoginActivity extends AppCompatActivity {
    protected EditText Enrolment, password;
    private TextView login;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Enrolment = (EditText) findViewById(R.id.enrolment);
        password = (EditText) findViewById(R.id.password);
        progressBar=(ProgressBar)findViewById(R.id.progress_circular);

        login = (TextView) findViewById(R.id.buttonLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                Intent intent = new Intent(LoginActivity.this, StudentDetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}
