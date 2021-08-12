package com.btcsc.appmp3.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.activity.MainActivity3;
import com.btcsc.appmp3.model.Banner;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    Context context;
    ArrayList<Banner>  bannerArrayList;

    public BannerAdapter(Context context, ArrayList<Banner> bannerArrayList) {
        this.context = context;
        this.bannerArrayList = bannerArrayList;
    }

    @Override
    public int getCount() {
        return bannerArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.banner_item,null);

        ImageView imageSong = view.findViewById(R.id.imageSong);
        ImageView iconSong = view.findViewById(R.id.iconSong);
        TextView nameSong = view.findViewById(R.id.nameSong);
        TextView noidungSong = view.findViewById(R.id.noidungSong);

        Picasso.get().load(bannerArrayList.get(position).getHinhanh()).into(imageSong);
        Picasso.get().load(bannerArrayList.get(position).getHinhBaiHat()).into(iconSong);

        nameSong .setText(bannerArrayList.get(position).getTenBaiHat());
        noidungSong.setText(bannerArrayList.get(position).getNoidung());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity3.class);
                intent.putExtra("banner",  bannerArrayList.get(position));
                context.startActivity(intent);
            }
        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
