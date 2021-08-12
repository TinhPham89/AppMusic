package com.btcsc.appmp3.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.btcsc.appmp3.R;
import com.btcsc.appmp3.activity.PhatNhacActivity;
import com.btcsc.appmp3.model.BaiHatHot;

import java.util.ArrayList;

public class BaiHatDeXuatAdapter extends RecyclerView.Adapter<BaiHatDeXuatAdapter.BaiHatVh> {
    ArrayList<BaiHatHot> baiHatHotArrayList;
    Context context;
    BaiHatHot  status;
    public BaiHatDeXuatAdapter(ArrayList<BaiHatHot> baiHatHotArrayList, Context context,BaiHatHot status) {
        this.baiHatHotArrayList = baiHatHotArrayList;
        this.context = context;
        this.status = status;
    }

    @NonNull
    @Override
    public BaiHatVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View  view  = layoutInflater.inflate(R.layout.play_bai_hat_item,parent,false);
        BaiHatVh  baiHatVh = new BaiHatVh(view);
        return baiHatVh;
    }

    @Override
    public void onBindViewHolder(@NonNull BaiHatVh holder, int position) {
        BaiHatHot baiHatHot = baiHatHotArrayList.get(position);
        holder.txtSTT.setText(position+1+"");
        holder.txtCaKhuc.setText(baiHatHot.getTenbaihat());
        holder.txtCaSi.setText(baiHatHot.getTencasi());
        if(status.getTenbaihat().equals(baiHatHot.getTenbaihat()))
        {
            holder.imageSongWave.setImageResource(R.drawable.ic_baseline_equalizer_24);

        }
        else
        {
            holder.imageSongWave.setImageResource(R.drawable.ic_baseline_equalizer_24_gray);
        }

    }
    @Override
    public int getItemCount() {
        return baiHatHotArrayList.size();
    }

  public  class BaiHatVh extends RecyclerView.ViewHolder {
        TextView  txtCaKhuc , txtCaSi, txtSTT;
        ImageView imageSongWave , imageLove;
        ConstraintLayout  background;
        public BaiHatVh(@NonNull View itemView) {
            super(itemView);
            txtCaKhuc= itemView.findViewById(R.id.txtPlayBaiHatInDanhSach);
            txtCaSi=itemView.findViewById(R.id.txtPlayCasiInDanhSach);
            txtSTT = itemView.findViewById(R.id.txtPlayStt);
            imageSongWave = itemView.findViewById(R.id.imageWaveSong);
            imageLove = itemView.findViewById(R.id.imageLoveInDanhSach);
            background = itemView.findViewById(R.id.backgroundPlaynhac);
            this.setIsRecyclable(false);
        }
    }
}
