package com.example.nh.sqliteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddEmployee extends AppCompatActivity {

    private EditText name,address,salary,jop;
    private Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        salary = findViewById(R.id.salary);
        jop = findViewById(R.id.jop);

        if ( getIntent().getSerializableExtra("employeeData")!= null) {

            Toast.makeText(this, "Update Data", Toast.LENGTH_SHORT).show();

            employee = (Employee) getIntent().getSerializableExtra("employeeData");

            name.setText(employee.getName());
            address.setText(employee.getAddress());
            salary.setText(String.valueOf(employee.getSalary()));
            jop.setText(employee.getJop());
        }
    }

     public void save_btn(View view) {

         DatabaseHelper helper = new DatabaseHelper(this);

        if(employee == null){
            Employee emp = new Employee(name.getText().toString(),address.getText().toString(),
                    Double.parseDouble(salary.getText().toString()),jop.getText().toString());
            helper.addEmployee(emp);
            Toast.makeText(this,"Added",Toast.LENGTH_SHORT).show();

        } else {
            Employee emp = new Employee(employee.getId(),name.getText().toString(),address.getText().toString(),
                    Double.parseDouble(salary.getText().toString()),jop.getText().toString());
            helper.updateData(emp);
            Toast.makeText(this,"updated",Toast.LENGTH_SHORT).show();
        }
         Intent intent = new Intent(this,EmployeeList.class);
         startActivity(intent);
         finish();
    }

}
