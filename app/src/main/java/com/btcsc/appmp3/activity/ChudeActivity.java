package com.btcsc.appmp3.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.adapter.AlbumAdapter;
import com.btcsc.appmp3.adapter.ChudeAdapter;
import com.btcsc.appmp3.model.Album;
import com.btcsc.appmp3.model.Chude;
import com.btcsc.appmp3.sevice.APIService;
import com.btcsc.appmp3.sevice.Service;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChudeActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    ChudeAdapter chudeAdapter;
    ArrayList<Chude> chudeArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chude);
        anhxa();
        getData();
    }

    void   getData()
    {
        Service service = APIService.getService();
        Call<ArrayList<Chude>> call = service.getListChude();
        call.enqueue(new Callback<ArrayList<Chude>>() {
            @Override
            public void onResponse(Call<ArrayList<Chude>> call, Response<ArrayList<Chude>> response) {
                chudeArrayList = response.body();
                chudeAdapter = new ChudeAdapter(chudeArrayList,ChudeActivity.this);
                recyclerView.setLayoutManager(new LinearLayoutManager(ChudeActivity.this,
                        LinearLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(chudeAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Chude>> call, Throwable t) {

            }
        });
    }

    private void anhxa() {
        toolbar = findViewById(R.id.toolbarChude);
        recyclerView = findViewById(R.id.rvChude);
        toolbar.setTitle("Tất cả Chủ Đề");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}