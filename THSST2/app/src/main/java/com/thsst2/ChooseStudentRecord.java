package com.thsst2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gyra on 02/04/2018.
 */
public class ChooseStudentRecord extends AppCompatActivity {

    DBHelper database;
    int schoolID;

    ListView viewStudents;

    List<String> studentList;
    ArrayAdapter<String> studentListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_student_record);

        this.initComponents();
    }

    public void getStudentRecords() {

    }

    private void initComponents() {
        Intent intent = getIntent();
        this.schoolID = intent.getIntExtra("SchoolID", 0);

        viewStudents = (ListView) findViewById(R.id.listStudents);

        this.database = new DBHelper(this);

        studentList = new ArrayList<String>();
        Cursor res = this.database.getAllStudentRecordsFromSchool(this.schoolID);
        if(res.getCount() == 0) {
            Toast.makeText(this, "No such student.", Toast.LENGTH_SHORT).show();
        }

        while(res.moveToNext()) {
            String firstname = res.getString(res.getColumnIndex("col_student_fname"));
            String middlename = res.getString(res.getColumnIndex("col_student_mname"));
            String lastname = res.getString(res.getColumnIndex("col_student_lname"));
            String suffixCheck = res.getString(res.getColumnIndex("col_student_suffix"));
            String suffix = (suffixCheck == null || suffixCheck.equals("-") ? " " : suffixCheck);

            studentList.add(lastname+", "+firstname+" "+suffix+" "+middlename+"");
        }

        studentListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, studentList);
        viewStudents.setAdapter(studentListAdapter);
    }
}
