package com.btcsc.appmp3.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.adapter.TheloaiAdapter;
import com.btcsc.appmp3.model.Theloai;
import com.btcsc.appmp3.sevice.APIService;
import com.btcsc.appmp3.sevice.Service;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TheloaiActivity extends AppCompatActivity {
    ArrayList<Theloai>  theloaiArrayList;
    RecyclerView  recyclerView;
    Toolbar toolbar;
    TheloaiAdapter theloaiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theloai);
        anhxa();
        getData();
    }
     void anhxa()
     {
         recyclerView= findViewById(R.id.rvTheloai);
         toolbar = findViewById(R.id.toolbarTheloai);
         toolbar.setTitle("Tất cả Thể Loại");
         setSupportActionBar(toolbar);
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     }
     void getData()
     {
         Service service = APIService.getService();
         Call<ArrayList<Theloai>> call = service.getListTheloai();
         call.enqueue(new Callback<ArrayList<Theloai>>() {
             @Override
             public void onResponse(Call<ArrayList<Theloai>> call, Response<ArrayList<Theloai>> response) {
                 theloaiArrayList = response.body();
                 theloaiAdapter = new TheloaiAdapter(TheloaiActivity.this, theloaiArrayList);
                 recyclerView.setLayoutManager(new GridLayoutManager(TheloaiActivity.this,2));
                 recyclerView.setAdapter(theloaiAdapter);
             }

             @Override
             public void onFailure(Call<ArrayList<Theloai>> call, Throwable t) {

             }
         });
     }
}