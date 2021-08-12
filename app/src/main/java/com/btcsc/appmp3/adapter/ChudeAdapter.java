package com.btcsc.appmp3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.model.Chude;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChudeAdapter extends RecyclerView.Adapter<ChudeAdapter.ChudeVh> {
    ArrayList<Chude> chudeArrayList;
    Context context;

    public ChudeAdapter(ArrayList<Chude> chudeArrayList, Context context) {
        this.chudeArrayList = chudeArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChudeVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.chude_item,parent,false);
        return new ChudeVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChudeVh holder, int position) {
        Chude chude= chudeArrayList.get(position);

        Picasso.get().load(chude.getHinhchude()).into(holder.imageChude);
        holder.nameChude.setText(chude.getTenchude());

    }

    @Override
    public int getItemCount() {
        return chudeArrayList.size();
    }

    class ChudeVh extends RecyclerView.ViewHolder {
        ImageView imageChude;
        TextView nameChude;
        public ChudeVh(@NonNull View itemView) {
            super(itemView);
            imageChude= itemView.findViewById(R.id.imageChude);
            nameChude=itemView.findViewById(R.id.textChude);
        }
    }
}
