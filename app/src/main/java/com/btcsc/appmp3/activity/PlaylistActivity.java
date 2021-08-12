package com.btcsc.appmp3.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.adapter.PlaylistAdapter;
import com.btcsc.appmp3.model.Playlist;
import com.btcsc.appmp3.sevice.APIService;
import com.btcsc.appmp3.sevice.Service;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaylistActivity extends AppCompatActivity {
    ArrayList<Playlist> playlistArrayList;
    PlaylistAdapter playlistAdapter;
    RecyclerView recyclerView;
    Toolbar  toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        anhxa();
        getData();
    }

    private void getData() {
        Service  service = APIService.getService();
        Call<ArrayList<Playlist>>  call = service.getListPlayList();
        call.enqueue(new Callback<ArrayList<Playlist>>() {
            @Override
            public void onResponse(Call<ArrayList<Playlist>> call, Response<ArrayList<Playlist>> response) {
                playlistArrayList = response.body();
                playlistAdapter = new PlaylistAdapter(playlistArrayList,PlaylistActivity.this);
                recyclerView.setLayoutManager(new LinearLayoutManager(PlaylistActivity.this,
                        RecyclerView.VERTICAL,false));
                recyclerView.setAdapter(playlistAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Playlist>> call, Throwable t) {

            }
        });

    }

    private void anhxa() {
        toolbar = findViewById(R.id.toolbarPlaylist);
        recyclerView = findViewById(R.id.rvPlaylist);
        toolbar.setTitle("Tất cả Playlist");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}