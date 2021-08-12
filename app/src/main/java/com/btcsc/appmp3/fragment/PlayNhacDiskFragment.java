package com.btcsc.appmp3.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.model.BaiHatHot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlayNhacDiskFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayNhacDiskFragment extends Fragment {
    CircleImageView imageDisk;
    BaiHatHot baiHatHot;
    ArrayList<BaiHatHot> arrayListBaiHatHot;
    String image ;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PlayNhacDiskFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlayNhacDiskFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlayNhacDiskFragment newInstance(String param1, String param2) {
        PlayNhacDiskFragment fragment = new PlayNhacDiskFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public static PlayNhacDiskFragment getInstance(String hinhanh) {
        PlayNhacDiskFragment fragment = new PlayNhacDiskFragment();
        Bundle args = new Bundle();
        args.putString("hinhanh",hinhanh);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_play_nhac_disk, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageDisk = view.findViewById(R.id.disk_song);
        if(getArguments()!= null)
        {
            image = getArguments().getString("hinhanh");
            Log.d("ABC",image);
            Picasso.get().load(image).into(imageDisk);
            Animation rotate = AnimationUtils.loadAnimation(getContext(),R.anim.rotation);
            rotate.setInterpolator(new LinearInterpolator());
            imageDisk.setAnimation(rotate);
        }
        else
        {
            Log.d("ABC", "null");
        }

    }
}