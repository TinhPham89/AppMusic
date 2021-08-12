package com.btcsc.appmp3.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.adapter.BaiHatQuangCaoAdapter;
import com.btcsc.appmp3.model.Album;
import com.btcsc.appmp3.model.BaiHatHot;
import com.btcsc.appmp3.model.Banner;
import com.btcsc.appmp3.model.Casi;
import com.btcsc.appmp3.model.Playlist;
import com.btcsc.appmp3.model.Theloai;
import com.btcsc.appmp3.sevice.APIService;
import com.btcsc.appmp3.sevice.Service;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class MainActivity3 extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerView;
    FloatingActionButton  floatingActionButton;
    Banner banner;
    Playlist playlist;
    Casi casi;
    Theloai theloai;
    ImageView  imageView;
    Album album;
    ArrayList<BaiHatHot>  baiHatHotArrayList;
    BaiHatQuangCaoAdapter adapter;
    Bitmap bitmap ;
    URL url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        anhxa();
        getDataIntent();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, PhatNhacActivity.class);
                intent.putExtra("danhsachbaihat",baiHatHotArrayList);
                startActivity(intent);
            }
        });
        if(banner!= null && ! banner.getTenBaiHat().equals(""))
        {
            try {
                url = new URL(banner.getHinhanh());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            setValueView ();
            collapsingToolbarLayout.setTitle(banner.getTenBaiHat());
            Picasso.get().load(banner.getHinhBaiHat()).into(imageView);
            getDataQuangCao(banner.getIdQuangCao());
        }
        if(playlist!= null && ! playlist.getTen().equals(""))
        {
            try {
                url = new URL(playlist.getHinhNen());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            setValueView ();
            collapsingToolbarLayout.setTitle(playlist.getTen());
            Picasso.get().load(playlist.getHinhNen()).into(imageView);
            getDataPlaylist(playlist.getIdPlayList());
        }

        if(album!= null && ! album.getTenalbum().equals(""))
        {
            try {
                url = new URL(album.getHinhalbum());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            setValueView ();
            collapsingToolbarLayout.setTitle(album.getTenalbum());
            Picasso.get().load(album.getHinhalbum()).into(imageView);
            getDataAlbum(album.getIdalbum());
        }

        if(casi!= null && ! casi.getTencasi().equals(""))
        {
            try {
                url = new URL(casi.getHinhcasi());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            setValueView ();
            collapsingToolbarLayout.setTitle(casi.getTencasi());
            Picasso.get().load(casi.getHinhcasi()).into(imageView);
            getDataCaSi(casi.getIdcasi());
        }
        if(theloai!= null && ! theloai.getTentheloai().equals(""))
        {
            try {
                url = new URL(theloai.getHinhtheloai());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            setValueView ();
            collapsingToolbarLayout.setTitle(theloai.getTentheloai());
            Picasso.get().load(theloai.getHinhtheloai()).into(imageView);
            getDataTheloai(theloai.getIdtheloai());
        }


    }

    private void getDataTheloai(String idtheloai) {
        Service service = APIService.getService();
        Call<ArrayList<BaiHatHot>> call = service.getBaihatTheLoai(idtheloai);
        call.enqueue(new Callback<ArrayList<BaiHatHot>>() {
            @Override
            public void onResponse(Call<ArrayList<BaiHatHot>> call, Response<ArrayList<BaiHatHot>> response) {
                baiHatHotArrayList=response.body();
                adapter = new BaiHatQuangCaoAdapter(baiHatHotArrayList,MainActivity3.this);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity3.this,
                        LinearLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ArrayList<BaiHatHot>> call, Throwable t) {

            }
        });
    }

    private void getDataCaSi(String idcasi) {
        Service service = APIService.getService();
        Call<ArrayList<BaiHatHot>> call = service.getBaihatCaSi(idcasi);
        call.enqueue(new Callback<ArrayList<BaiHatHot>>() {
            @Override
            public void onResponse(Call<ArrayList<BaiHatHot>> call, Response<ArrayList<BaiHatHot>> response) {
                baiHatHotArrayList=response.body();
                adapter = new BaiHatQuangCaoAdapter(baiHatHotArrayList,MainActivity3.this);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity3.this,
                        LinearLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ArrayList<BaiHatHot>> call, Throwable t) {

            }
        });
    }

    private void getDataAlbum(String idalbum) {
        Service service = APIService.getService();
        Call<ArrayList<BaiHatHot>> call = service.getBaihatAlbum(idalbum);
        call.enqueue(new Callback<ArrayList<BaiHatHot>>() {
            @Override
            public void onResponse(Call<ArrayList<BaiHatHot>> call, Response<ArrayList<BaiHatHot>> response) {
                baiHatHotArrayList=response.body();
                adapter = new BaiHatQuangCaoAdapter(baiHatHotArrayList,MainActivity3.this);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity3.this,
                        LinearLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ArrayList<BaiHatHot>> call, Throwable t) {

            }
        });
    }

    private void getDataPlaylist(String idPlayList) {
        Service service = APIService.getService();
        Call<ArrayList<BaiHatHot>> call = service.getBaihatPlaylist(idPlayList);
        call.enqueue(new Callback<ArrayList<BaiHatHot>>() {
            @Override
            public void onResponse(Call<ArrayList<BaiHatHot>> call, Response<ArrayList<BaiHatHot>> response) {
                baiHatHotArrayList=response.body();
                adapter = new BaiHatQuangCaoAdapter(baiHatHotArrayList,MainActivity3.this);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity3.this,
                        LinearLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ArrayList<BaiHatHot>> call, Throwable t) {

            }
        });
    }

    private void getDataQuangCao(String id) {
        Service service = APIService.getService();
        Call<ArrayList<BaiHatHot>> call = service.getBaihatQuangCao(id);
        call.enqueue(new Callback<ArrayList<BaiHatHot>>() {
            @Override
            public void onResponse(Call<ArrayList<BaiHatHot>> call, Response<ArrayList<BaiHatHot>> response) {
                baiHatHotArrayList=response.body();
                Log.d("ABC",baiHatHotArrayList.get(0).getTenbaihat());
                adapter = new BaiHatQuangCaoAdapter(baiHatHotArrayList,MainActivity3.this);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity3.this,
                        LinearLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<BaiHatHot>> call, Throwable t) {

            }
        });
    }

    private void setValueView( ) {

        threadBitmap thread =new threadBitmap();
        thread.start();
    }

    void anhxa()
    {
        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        collapsingToolbarLayout=findViewById(R.id.collapsingLayout);
        toolbar=findViewById(R.id.toolbar);
        floatingActionButton = findViewById(R.id.buttonPlayZing);
        recyclerView=findViewById(R.id.recylerviewBaiHatPlay);
        imageView = findViewById(R.id.imageCakhuc);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
    }
    void getDataIntent()
    {
        Intent  intent  = getIntent();
        banner = (Banner) intent.getSerializableExtra("banner");
        playlist = (Playlist) intent.getSerializableExtra("playlist");
        album = (Album) intent.getSerializableExtra("album");
        casi = (Casi) intent.getSerializableExtra("casi");
        theloai = (Theloai) intent.getSerializableExtra("theloai");

    }

    class threadBitmap extends Thread
    {
        @Override
        public void run() {
            super.run();
                try {
                    bitmap = BitmapFactory.decodeStream(url.openStream());
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(),bitmap);
                    collapsingToolbarLayout.post(new Runnable() {
                        @Override
                        public void run() {
                            collapsingToolbarLayout.setBackground(bitmapDrawable);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

}