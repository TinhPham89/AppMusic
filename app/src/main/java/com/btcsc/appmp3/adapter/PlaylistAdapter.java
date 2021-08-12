package com.btcsc.appmp3.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.activity.MainActivity3;
import com.btcsc.appmp3.model.Playlist;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.PlaylistVh> {
    ArrayList<Playlist> arrayPlaylist;
    Context context;

    public PlaylistAdapter(ArrayList<Playlist> arrayPlaylist, Context context) {
        this.arrayPlaylist = arrayPlaylist;
        this.context = context;
    }
    interface onClick
    {
        void setOnClick();
    }

    @NonNull
    @Override
    public PlaylistVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.playlist_item,parent,false);
        return new PlaylistVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistVh holder, int position) {
        Playlist playlist = arrayPlaylist.get(position);

        Picasso.get().load(playlist.getHinhNen()).into(holder.imagePlaylist);
        Picasso.get().load(playlist.getHinhICon()).into(holder.imageIconPlaylist);

        holder.namePlaylist.setText(playlist.getTen());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity3.class);
                intent.putExtra("playlist",playlist);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayPlaylist.size();
    }

    class PlaylistVh extends RecyclerView.ViewHolder {
        ImageView imagePlaylist , imageIconPlaylist;
        TextView namePlaylist ;

        public PlaylistVh(@NonNull View itemView) {
            super(itemView);

            imagePlaylist = itemView.findViewById(R.id.imagePlaylist);
            imageIconPlaylist = itemView.findViewById(R.id.imageIconPlaylist);
            namePlaylist = itemView.findViewById(R.id.textPlaylist);

        }
    }
}
