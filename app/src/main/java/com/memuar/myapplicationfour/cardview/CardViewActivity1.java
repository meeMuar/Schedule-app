package com.memuar.myapplicationfour.cardview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.widget.ProgressBar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.memuar.myapplicationfour.MainActivity;
import com.memuar.myapplicationfour.NormalRecyclerView;
import com.memuar.myapplicationfour.R;
import com.memuar.myapplicationfour.cardsaved.SavedActivity;

import java.util.ArrayList;

public class CardViewActivity1 extends AppCompatActivity {

    // creating a variable for our array list, adapter class,
    // recycler view, progressbar, nested scroll view
    private ArrayList<UserModal> userModalArrayList;
    private UserRVAdapter userRVAdapter;
    private RecyclerView userRV;
    private ProgressBar loadingPB;
    private RequestQueue mQueue;
    SharedPreferences sp;
    Button btn3, btn4;
    String save_s,save_p,save_t,save_c;
    String time, prof_name,cabinet,subjectName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn3 = findViewById(R.id.button_save);
        btn4 = findViewById(R.id.button_show);
        // creating a new array list.
        userModalArrayList = new ArrayList<>();

        // initializing our views.
        userRV = findViewById(R.id.idRVUsers);
        loadingPB = findViewById(R.id.idPBLoading);
        mQueue = Volley.newRequestQueue(this);

        // calling a method to load our API.
        jsonParse();

        sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sp.edit();
                editor.putString("cabinet", cabinet);
                editor.putString("subject",subjectName);
                editor.putString("prof",prof_name);
                editor.putString("time",time);
                editor.commit();
                Toast.makeText(CardViewActivity1.this, "Збережено",Toast.LENGTH_LONG).show();



            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CardViewActivity1.this, SavedActivity.class);
                startActivity(i);




            }
        });

    }

    private void jsonParse() {

        String url = "https://opensheet.elk.sh/1UnmhMV2xlm5oIQzDNlJNqYoH2ZKQcxc3H_kpq8jvMEc/sheet4";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {

                    try {
                        JSONObject responseObj = response.getJSONObject(i);

                         subjectName = responseObj.getString("subject_name");
                         prof_name = responseObj.getString("prof_name");
                         cabinet = responseObj.getString("cabinet");
                         time = responseObj.getString("time");



                        userModalArrayList.add(new UserModal(subjectName, prof_name, cabinet, time));

                        // passing array list to our adapter class.
                        userRVAdapter = new UserRVAdapter(userModalArrayList, CardViewActivity1.this);

                        // setting layout manager to our recycler view.
                        userRV.setLayoutManager(new LinearLayoutManager(CardViewActivity1.this));

                        // setting adapter to our recycler view.
                        userRV.setAdapter(userRVAdapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(com.memuar.myapplicationfour.cardview.CardViewActivity1.this, "Fail to get the data..", Toast.LENGTH_SHORT).show();
            }
        });

        mQueue.add(request);
    }
}