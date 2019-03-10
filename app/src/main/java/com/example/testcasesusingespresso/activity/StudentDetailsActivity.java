package com.example.testcasesusingespresso.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.testcasesusingespresso.R;

import java.io.Serializable;
import java.util.Calendar;

public class StudentDetailsActivity extends AppCompatActivity {

    TextView DateOfBirth;
    Switch scNationality;
    ScrollView scrollView;
    Spinner SpinnerTitle, SpinnerGender, SpinnerYearOfPassing;
    EditText edphone, edemail;
    RadioGroup radioGroupMartialStatus;
    RadioButton radioBtnMarried, radioBtnUnmarried;
    EditText edFullName, edMotherName, edFatherName;
    EditText edAadharCardNumber;
    EditText edStreet, edArea, edCity, edPostalCode;
    CheckBox checkDeclaration;
    TextView ButtonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Student Details");

        initializeWidgets();

        DateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.dateOfBirth) {
                    Calendar cal = Calendar.getInstance();
                    int yearC = cal.get(Calendar.YEAR);
                    int monthC = cal.get(Calendar.MONTH);
                    int dayC = cal.get(Calendar.DAY_OF_MONTH);

                    int temp = monthC + 1;
                    DateOfBirth.setText(dayC + "/" + temp + "/" + yearC);

                    DatePickerDialog dialog = new DatePickerDialog(StudentDetailsActivity.this,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                                    month = month + 1;
                                    DateOfBirth.setText(dayOfMonth + "/" + month + "/" + year);
                                }

                            }, yearC, monthC, dayC);
                    dialog.getDatePicker().setMinDate(System.currentTimeMillis());
                    dialog.show();
                }

            }
        });

        scNationality.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    //switch is checked on
                    scNationality.setText(" ");
                    scNationality.setText("Indian");

                } else {
                    //switch is off
                    scNationality.setText(" ");
                    scNationality.setText("NRI");
                }
            }
        });

        final StringBuilder info = new StringBuilder();

        String name = edFullName.getText().toString();
        String email = edemail.getText().toString();
        String phone = edphone.getText().toString();
        String MotherName = edMotherName.getText().toString();
        String FatherName = edFatherName.getText().toString();
        String City = edCity.getText().toString();

        info.append(name);
        info.append(email);
        info.append(phone);
        info.append(MotherName);
        info.append(FatherName);
        info.append(City);

        ButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentDetailsActivity.this, CoursesDetailsActivity.class);
                intent.putExtra("STUDENT_DETAILS", (Serializable) info);
                startActivity(intent);
            }
        });
    }

    private void initializeWidgets() {
        DateOfBirth = (TextView) findViewById(R.id.dateOfBirth);
        scNationality = (Switch) findViewById(R.id.scNationality);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        SpinnerTitle = (Spinner) findViewById(R.id.title_spinner);
        edFullName = (EditText) findViewById(R.id.fullName);
        SpinnerGender = (Spinner) findViewById(R.id.gender_spinner);
        SpinnerYearOfPassing = (Spinner) findViewById(R.id.yearOfPassing);
        edphone = (EditText) findViewById(R.id.phone);
        edemail = (EditText) findViewById(R.id.email);
        radioGroupMartialStatus = (RadioGroup) findViewById(R.id.radio_martialStatus);
        radioBtnMarried = (RadioButton) findViewById(R.id.radio_married);
        radioBtnUnmarried = (RadioButton) findViewById(R.id.radio_unmarried);
        edMotherName = (EditText) findViewById(R.id.motherName);
        edFatherName = (EditText) findViewById(R.id.fatherName);
        edAadharCardNumber = (EditText) findViewById(R.id.aadharCardNumber);
        edStreet = (EditText) findViewById(R.id.street);
        edArea = (EditText) findViewById(R.id.area);
        edCity = (EditText) findViewById(R.id.city);
        edPostalCode = (EditText) findViewById(R.id.postal);
        checkDeclaration = (CheckBox) findViewById(R.id.check_declaration);
        ButtonSubmit = (TextView) findViewById(R.id.buttonNext);
    }
}
