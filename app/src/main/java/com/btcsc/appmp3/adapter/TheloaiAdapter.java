package com.btcsc.appmp3.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.telecom.PhoneAccount;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.activity.MainActivity3;
import com.btcsc.appmp3.model.Theloai;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TheloaiAdapter extends RecyclerView.Adapter<TheloaiAdapter.TheloaiVh> {
    Context context;
    ArrayList<Theloai> theloaiArrayList;


    public TheloaiAdapter(Context context, ArrayList<Theloai> theloaiArrayList) {
        this.context = context;
        this.theloaiArrayList = theloaiArrayList;
    }

    @NonNull
    @Override
    public TheloaiVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.theloai_item,parent,false);
        return new TheloaiVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TheloaiVh holder, int position) {
        Theloai theloai = theloaiArrayList.get(position);

        Picasso.get().load(theloai.getHinhtheloai()).into(holder.imageTheloai);
        holder.nameTheloai.setText(theloai.getTentheloai());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity3.class);
                intent.putExtra("theloai",theloai);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return theloaiArrayList.size();
    }

    class TheloaiVh extends RecyclerView.ViewHolder {
        ImageView imageTheloai;
        TextView nameTheloai;
        public TheloaiVh(@NonNull View itemView) {
            super(itemView);
            imageTheloai=itemView.findViewById(R.id.imageTheloai);
            nameTheloai=itemView.findViewById(R.id.txtTheloai);
        }
    }
}
