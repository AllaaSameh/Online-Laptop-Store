package com.example.laptopshope;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {

    EditText ed_newName, ed_newEmail, ed_newPass, ed_ConfPass;
    Button btn_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        ed_newName = findViewById(R.id.ed_newname);
        ed_newEmail = findViewById(R.id.ed_newEmail);
        ed_newPass = findViewById(R.id.ed_newpass);
        ed_ConfPass = findViewById(R.id.ed_conPass);
        btn_submit = findViewById(R.id.btn_submit);



        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ed_newName.getText().toString().trim().length() > 0 && ed_newPass.getText().toString().trim().length() > 0
                        && ed_newEmail.getText().toString().trim().length() > 0 && ed_ConfPass.getText().toString().trim().length() > 0) {

                    SharedPreferences data = getSharedPreferences("file", 0);
                    SharedPreferences.Editor pin = data.edit();
                    pin.putString("new user", ed_newName.getText().toString());
                    pin.putString("new email", ed_newEmail.getText().toString());
                    pin.putString("new pass", ed_newPass.getText().toString());
                    if (ed_newPass.getText().toString().equals(ed_ConfPass.getText().toString())) {
                        pin.putString("confirm pass", ed_ConfPass.getText().toString());
                    }

                    pin.apply();
                    saveToken();


                    Intent go = new Intent(RegistrationActivity.this, LoginActivity.class);
                    startActivity(go);
                    finish();


                } else {
                    ed_newName.setError("Please enter data ");
                    ed_newEmail.setError("Please enter data ");
                    ed_newPass.setError("Please enter data ");
                    ed_ConfPass.setError("Please enter data ");
                }
            }
        });


    }

    public void saveToken() {
        StringRequest task = new StringRequest(Request.Method.POST, VollyData.BASEURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject object = new JSONObject(response);
                    int status = object.getInt("status");
                    if (status == 0) {
                        String token = object.getString("token");
                        SharedPreferences data = getSharedPreferences("file", 0);
                        SharedPreferences.Editor pin = data.edit();
                        pin.putString("token", token);
                        pin.apply();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameter = new HashMap<>();

                return parameter;

            }

        };
        Volley.newRequestQueue(RegistrationActivity.this).add(task);
    }

}
