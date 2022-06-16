package com.memuar.myapplicationfour.cardsaved;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
import com.memuar.myapplicationfour.R;
import com.memuar.myapplicationfour.cardview.CardViewActivity1;
import com.memuar.myapplicationfour.cardview.UserModal;
import com.memuar.myapplicationfour.cardview.UserRVAdapter;

import java.util.ArrayList;

public class SavedActivity extends AppCompatActivity {

    // creating a variable for our array list, adapter class,
    // recycler view, progressbar, nested scroll view
    private ArrayList<UserModal> userModalArrayList;
    private UserRVAdapter userRVAdapter;
    private RecyclerView userRV;
    private ProgressBar loadingPB;
    private RequestQueue mQueue;

    Button btn3, btn4;
    String save_s,save_p,save_t,save_c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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
        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyPrefs",Context.MODE_PRIVATE);
        save_c = sp.getString("cabinet", "");
        save_p = sp.getString("prof", "");
        save_t = sp.getString("time", "");
        save_s = sp.getString("subject", "");

        userModalArrayList.add(new UserModal(save_s, save_p, save_c, save_t));

        // passing array list to our adapter class.
        userRVAdapter = new UserRVAdapter(userModalArrayList, SavedActivity.this);

        // setting layout manager to our recycler view.
        userRV.setLayoutManager(new LinearLayoutManager(SavedActivity.this));

        // setting adapter to our recycler view.
        userRV.setAdapter(userRVAdapter);






    }
}

