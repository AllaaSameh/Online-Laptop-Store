package com.example.laptopshope;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText ed_email, ed_pass;

    Button btn_newacc, btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ed_email = findViewById(R.id.ed_email);
        ed_pass = findViewById(R.id.ed_pass);
        btn_login = findViewById(R.id.btn_login);





            btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences data = getSharedPreferences("file",0);
                    String email = data.getString("new email","nouser");
                    String pass = data.getString("new pass","no data");
                    String token = data.getString("token","");
                    if(email.equals(ed_email.getText().toString()) && pass.equals(ed_pass.getText().toString())
                    && token.equals("")) {
                        Intent go = new Intent(LoginActivity.this, LaptopHomeActivity.class);
                        startActivity(go);
                        finish();
                    }
                     else
        {
            Toast.makeText(LoginActivity.this,"Email or Password are incorrect",Toast.LENGTH_SHORT).show();
        }
                }
            });



        btn_newacc = findViewById(R.id.btn_newAccount);
        btn_newacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(go);
            }
        });
    }
}
