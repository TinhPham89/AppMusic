package com.btcsc.appmp3.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.adapter.AlbumAdapter;
import com.btcsc.appmp3.model.Album;
import com.btcsc.appmp3.sevice.APIService;
import com.btcsc.appmp3.sevice.Service;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    AlbumAdapter albumAdapter;
    ArrayList<Album> albumArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        anhxa();
        getData();
    }

    private void getData() {
        Service service= APIService.getService();
        Call<ArrayList<Album>> call = service.getListAlbum();
        call.enqueue(new Callback<ArrayList<Album>>() {
            @Override
            public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                albumArrayList = response.body();
                albumAdapter = new AlbumAdapter(albumArrayList,AlbumActivity.this);
                recyclerView.setLayoutManager(new GridLayoutManager(AlbumActivity.this,2));
                recyclerView.setAdapter(albumAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

            }
        });
    }

    private void anhxa() {
        toolbar = findViewById(R.id.toolbarAlbum);
        recyclerView = findViewById(R.id.rvAlbum);
        toolbar.setTitle("Tất cả Album");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}