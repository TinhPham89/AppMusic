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
import com.btcsc.appmp3.model.Album;
import com.btcsc.appmp3.model.Casi;
import com.btcsc.appmp3.model.Playlist;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class CaSiAdapter extends RecyclerView.Adapter<CaSiAdapter.CasiVh> {
    ArrayList<Casi> arrayCasi;
    Context context;

    public CaSiAdapter(ArrayList<Casi> arrayCasi, Context context) {
        this.arrayCasi = arrayCasi;
        this.context = context;
    }

    @NonNull
    @Override
    public CasiVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.casi_item,parent,false);
        return new CasiVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CasiVh holder, int position) {
        Casi casi = arrayCasi.get(position);

        Picasso.get().load(casi.getHinhcasi()).into(holder.imageCasi);

        holder.nameCasi.setText(casi.getTencasi());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity3.class);
                intent.putExtra("casi",casi);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayCasi.size();
    }

    class CasiVh extends RecyclerView.ViewHolder {
        ImageView imageCasi ;
        TextView nameCasi ;

        public CasiVh(@NonNull View itemView) {
            super(itemView);

            imageCasi = itemView.findViewById(R.id.imageCaSi);
            nameCasi = itemView.findViewById(R.id.txtNameCasi);

        }
    }
}
