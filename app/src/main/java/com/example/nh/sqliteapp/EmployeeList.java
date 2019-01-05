package com.example.nh.sqliteapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EmployeeList extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private EmployeeAdapter adapter;
    private DatabaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        listView = findViewById(R.id.list);
        helper = new DatabaseHelper(this);

        adapter = new EmployeeAdapter(this,helper.getAllEmployees());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);


    }

    public void back_btn(View view) {
        SharedPreferences preferences = getSharedPreferences("App",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean("isLoggdIn",false);
        editor.apply();

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void add_employee(View view) {
        Intent intent = new Intent(this,AddEmployee.class);
        startActivity(intent);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Employee employeeClass = helper.getAllEmployees().get(position);

        Intent intent = new Intent(this,EmployeeInfo.class);
        intent.putExtra("employeeData",employeeClass);
        startActivity(intent);
    }
}
