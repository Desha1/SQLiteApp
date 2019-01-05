package com.example.nh.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String  DATABASE_NAME = "EmployeesDB";
    private static final int DATABASE_VERSION = 1;

    private static final String EMPLOYEE_TABLE = "Employees";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_SALARY = "salary";
    private static final String KEY_JOP = "jop";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createStatement = "CREATE TABLE "+EMPLOYEE_TABLE+"("+
                KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
                KEY_NAME+" VARCHAR(100),"+
                KEY_ADDRESS+" VARCHAR(255)," +
                KEY_SALARY + " DOUBLE," +
                KEY_JOP +" VARCHAR(100))";
        db.execSQL(createStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropStatement = "DROP TABLE IF EXISTS "+EMPLOYEE_TABLE;
        db.execSQL(dropStatement);
        onCreate(db);
    }

    public void addEmployee(Employee employee){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put(KEY_ID,employee.getId());
        values.put(KEY_NAME,employee.getName());
        values.put(KEY_ADDRESS,employee.getAddress());
        values.put(KEY_SALARY,employee.getSalary());
        values.put(KEY_JOP,employee.getJop());
        db.insert(EMPLOYEE_TABLE,null,values);
        db.close();
    }

    public ArrayList<Employee> getAllEmployees(){
        ArrayList<Employee> allStores = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+EMPLOYEE_TABLE,null);
        while (cursor.moveToNext()){
            Employee employee = new Employee(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getDouble(3),
                    cursor.getString(4));
            allStores.add(employee);
        }

        cursor.close();
        db.close();
        return allStores;
    }
    public void updateData(Employee employee){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,employee.getName());
        values.put(KEY_ADDRESS,employee.getAddress());
        values.put(KEY_SALARY,employee.getSalary());
        values.put(KEY_JOP,employee.getJop());
        db.update(EMPLOYEE_TABLE,values,KEY_ID + "=?", new String[]{String.valueOf(employee.getId())});
        db.close();
    }

    public void delete(Employee employee) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(EMPLOYEE_TABLE,KEY_ID + "=?",new String[]{String.valueOf(employee.getId())});
    }
}
