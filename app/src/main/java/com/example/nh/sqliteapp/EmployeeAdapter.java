package com.example.nh.sqliteapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EmployeeAdapter extends ArrayAdapter<Employee> {
    private Context context ;
    private ArrayList<Employee> employee ;

    public EmployeeAdapter(@NonNull Context context, ArrayList<Employee> employee) {
        super(context, 0, employee);
        this.context = context;
        this.employee = employee;
    }

    @Override
    public int getCount() {
        return employee.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_desigen,parent,false);
        TextView employeeName = view.findViewById(R.id.employee_name);
        TextView employeeJop = view.findViewById(R.id.employee_jop);

        employeeName.setText(employee.get(position).getName());
        employeeJop.setText(employee.get(position).getJop());

        return view;
    }
}