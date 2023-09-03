package com.example.mabasafinalapp;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Logindetails extends AppCompatActivity {
    private EditText edt_username, edt_password, edt_passwordagain;
    private Button bt_login, bt_register;
    private DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logindetails);
        edt_username = findViewById(R.id.editTextTextPersonName2);
        edt_password = findViewById(R.id.editTextTextPassword3);
        edt_passwordagain = findViewById(R.id.editTextTextPassword4);
        bt_login = findViewById(R.id.btn_loginform);
        bt_register= findViewById(R.id.btn_sub);
        db = new DBHelper(this);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log_in = new Intent(Logindetails.this, MainActivity2.class);
                startActivity(log_in);
            }
        });
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edt_username.getText().toString();
                String pass = edt_password.getText().toString();
                String passagain= edt_passwordagain.getText().toString();

                if(user.equals("")|| pass.equals("")|| passagain.equals(""))
                {
                    Toast.makeText(Logindetails.this, "Please fill all requirements!", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                    if(pass.equals(passagain))
                    {
                        Boolean uv = db.userVerify(user);
                        if(uv == false)
                        {
                            Boolean reg_msg = db.addMyusers(user,pass);
                            if(reg_msg==true)
                            {
                                Toast.makeText(Logindetails.this, "Congratulations!", Toast.LENGTH_SHORT).show();
                                Intent to_login = new Intent(Logindetails.this, MainActivity2.class);
                                startActivity(to_login);
                            }
                            else
                                {
                                Toast.makeText(Logindetails.this, "Opps registration failed!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                            {
                            Toast.makeText(Logindetails.this, "User already registered!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                        {
                        Toast.makeText(Logindetails.this, "Your password doesn't match!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}