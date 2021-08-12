package com.btcsc.appmp3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.model.BaiHatHot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BaiHatHotAdapter extends RecyclerView.Adapter<BaiHatHotAdapter.BaiHatHotVh> {
    ArrayList<BaiHatHot> baiHatHotArrayList;
    Context context;

    public BaiHatHotAdapter(ArrayList<BaiHatHot> baiHatHotArrayList, Context context) {
        this.baiHatHotArrayList = baiHatHotArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public BaiHatHotVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.baihathot_item,parent,false);
        return new BaiHatHotVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaiHatHotVh holder, int position) {
        BaiHatHot baiHatHot = baiHatHotArrayList.get(position);
        Picasso.get().load(baiHatHot.getHinhbaihat()).into(holder.imageBaihat);
        holder.nameBaihat.setText(baiHatHot.getTenbaihat());
        holder.nameCasi.setText(baiHatHot.getTencasi());
        holder.soLuotThich.setText(baiHatHot.getLuotthich());

    }

    @Override
    public int getItemCount() {
        return baiHatHotArrayList.size();
    }

    class BaiHatHotVh extends RecyclerView.ViewHolder {
        ImageView imageBaihat;
        TextView nameBaihat , nameCasi, soLuotThich;
        public BaiHatHotVh(@NonNull View itemView) {
            super(itemView);
            imageBaihat = itemView.findViewById(R.id.imageBaiHatHot);
            nameBaihat = itemView.findViewById(R.id.txtNameBaiHatHot);
            nameCasi = itemView.findViewById(R.id.txtCaSiBaiHatHot);
            soLuotThich = itemView.findViewById(R.id.txtSoLuotThichBaiHatHot);
        }
    }
}
