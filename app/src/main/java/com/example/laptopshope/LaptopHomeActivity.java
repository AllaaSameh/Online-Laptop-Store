package com.example.laptopshope;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LaptopHomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop_home);

        recyclerView = findViewById(R.id.recyclerView);
    }

    void GrtHomeBrands ()
    {
        StringRequest task = new StringRequest(Request.Method.POST, VollyData.GetHomebrands, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject object = new JSONObject(response);
                    int status = object.getInt("status");
                    if(status ==0)
                    {
                        JSONArray array = object.getJSONArray("data");
                        ArrayList<laptop> laptops = new ArrayList<>();
                        for (int i = 0 ; i<laptops.size();i++)
                        {

                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
}
