package com.example.nh.sqliteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EmployeeInfo extends AppCompatActivity {

    private TextView name,address,jop,salary;
    private Employee employeeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_info);
        employeeData = (Employee) getIntent().getSerializableExtra("employeeData");

        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        salary = findViewById(R.id.salary);
        jop = findViewById(R.id.jop);

        name.setText("Name: " + employeeData.getName());
        address.setText("Address: "+employeeData.getAddress());
        salary.setText("Salary: "+employeeData.getSalary());
        jop.setText("Jop : "+employeeData.getJop());
    }

    public void toUpdateEmployee(View view) {

        Intent intent = new Intent(this,AddEmployee.class);
        intent.putExtra("employeeData",employeeData);
        startActivity(intent);
    }

    public void back_btn(View view) {
        Intent intent = new Intent(this,EmployeeList.class);
        startActivity(intent);
        finish();
    }

    public void delete(View view) {
        DatabaseHelper helper = new DatabaseHelper(this);
        helper.delete(employeeData);

        Intent intent = new Intent(this,EmployeeList.class);
        startActivity(intent);
        finish();
    }
}
