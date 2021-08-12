package com.btcsc.appmp3.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.activity.MainActivity3;
import com.btcsc.appmp3.model.Album;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumVh> {
    ArrayList<Album> arrayAlbum;
    Context context;

    public AlbumAdapter(ArrayList<Album> arrayAlbum, Context context) {
        this.arrayAlbum = arrayAlbum;
        this.context = context;
    }

    @NonNull
    @Override
    public AlbumVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.album_item,parent,false);
        return new AlbumVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumVh holder, int position) {
        Album album = arrayAlbum.get(position);

        Picasso.get().load(album.getHinhalbum()).into(holder.imageAlbum);

        holder.nameAlbum.setText(album.getTenalbum());
        holder.nameCasi.setText(album.getTencasi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity3.class);
                intent.putExtra("album",album);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayAlbum.size();
    }

    class AlbumVh extends RecyclerView.ViewHolder {
        ImageView imageAlbum ;
        TextView nameAlbum,nameCasi ;

        public AlbumVh(@NonNull View itemView) {
            super(itemView);

            imageAlbum = itemView.findViewById(R.id.imageBaiHatHot);
            nameCasi = itemView.findViewById(R.id.txtCaSiBaiHatHot);
            nameAlbum = itemView.findViewById(R.id.txtNameBaiHatHot);

        }
    }
}
