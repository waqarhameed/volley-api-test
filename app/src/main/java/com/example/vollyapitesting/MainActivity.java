package com.example.vollyapitesting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getName();
    private Button btnRequest;
    private StringRequest stringRequest;
    private RequestQueue requestQueue;
    private String url = "https://www.google.com/";
                         //http://www.mocky.io/v2/597c41390f0000d002f4dbd1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRequest = findViewById(R.id.btnRequest);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestResponseFromServer();
            }
        });
    }

    private void requestResponseFromServer() {

        //RequestQueue initialized
        requestQueue = Volley.newRequestQueue(this);

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            String context="";
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "RESPONSE  (" + response.contains("google") + ")", Toast.LENGTH_LONG).show();//display, the response on screen

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i(TAG, "Error :" + error.toString());
            }
        });

        requestQueue.add(stringRequest);
    }
}

