package com.example.mabasafinalapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private EditText ed_username, ed_password;
    private Button btn_login, bt_toregister;
    private DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ed_username = findViewById(R.id.editTextTextPersonName);
        ed_password = findViewById(R.id.editTextTextPassword);
        btn_login = findViewById(R.id.button);
        bt_toregister= findViewById(R.id.bt_reg);
        db = new DBHelper(this);
        bt_toregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg = new Intent(MainActivity2.this, Logindetails.class);
                startActivity(reg);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = ed_username.getText().toString();
                String pass = ed_password.getText().toString();

                if(user.equals("")|| pass.equals("")){
                    Toast.makeText(MainActivity2.this, "Enter your login details!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean res = db.passwordVerify(user,pass);
                    if(res==true){
                        Toast.makeText(MainActivity2.this, "Welcome to Main Page!", Toast.LENGTH_SHORT).show();
                        Intent to_main = new Intent(MainActivity2.this, MainActivity.class);
                        startActivity(to_main);
                    }else{
                        Toast.makeText(MainActivity2.this, "Ooops,Enter correct details!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}