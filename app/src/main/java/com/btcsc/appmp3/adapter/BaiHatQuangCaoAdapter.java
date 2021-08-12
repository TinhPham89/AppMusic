package com.btcsc.appmp3.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.btcsc.appmp3.R;
import com.btcsc.appmp3.activity.PhatNhacActivity;
import com.btcsc.appmp3.model.BaiHatHot;

import java.util.ArrayList;

public class BaiHatQuangCaoAdapter extends RecyclerView.Adapter<BaiHatQuangCaoAdapter.BaiHatVh> {
    ArrayList<BaiHatHot> baiHatHotArrayList;
    Context context;

    public BaiHatQuangCaoAdapter(ArrayList<BaiHatHot> baiHatHotArrayList, Context context) {
        this.baiHatHotArrayList = baiHatHotArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public BaiHatVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View  view  = layoutInflater.inflate(R.layout.baihat_in_danh_sach_item,parent,false);
        BaiHatVh  baiHatVh = new BaiHatVh(view);
        return baiHatVh;
    }

    @Override
    public void onBindViewHolder(@NonNull BaiHatVh holder, int position) {
        BaiHatHot baiHatHot = baiHatHotArrayList.get(position);
        holder.txtSTT.setText(position+1+"");
        holder.txtCaKhuc.setText(baiHatHot.getTenbaihat());
        holder.txtCaSi.setText(baiHatHot.getTencasi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PhatNhacActivity.class);
                intent.putExtra("baihat",baiHatHot);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return baiHatHotArrayList.size();
    }

    class BaiHatVh extends RecyclerView.ViewHolder {
        TextView  txtCaKhuc , txtCaSi, txtSTT;
        public BaiHatVh(@NonNull View itemView) {
            super(itemView);

            txtCaKhuc= itemView.findViewById(R.id.txtBaiHatInDanhSach);
            txtCaSi=itemView.findViewById(R.id.txtCasiInDanhSach);
            txtSTT = itemView.findViewById(R.id.txtStt);
        }
    }
}
