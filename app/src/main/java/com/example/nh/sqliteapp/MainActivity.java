package com.example.nh.sqliteapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText usernameED,passwordED;
    private Button loginBtn;
    private final String username="mostafa",password="111";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameED = findViewById(R.id.username);
        passwordED = findViewById(R.id.password);
        loginBtn = findViewById(R.id.login);
        loginBtn.setOnClickListener(this);

        SharedPreferences preferences= getSharedPreferences("App",MODE_PRIVATE);
        boolean isLoggedIn=preferences.getBoolean("isLoggdIn",false);
        if (isLoggedIn){
            Intent intent = new Intent(this,EmployeeList.class);
            startActivity(intent);
            finish();

        }


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login){
            if (!(usernameED.getText().toString().equals(username)))
                Toast.makeText(this,R.string.invalid_username,Toast.LENGTH_SHORT).show();
            else if (!passwordED.getText().toString().equals(password))
                Toast.makeText(this,R.string.invalid_password,Toast.LENGTH_SHORT).show();
            else {

                SharedPreferences references =  getSharedPreferences("App",MODE_PRIVATE);
                SharedPreferences.Editor editor=references.edit();
                editor.putBoolean("isLoggdIn",true);
                editor.apply();

                Intent intent = new Intent(this,EmployeeList.class);
                startActivity(intent);
                finish();

            }


        }
    }
}
