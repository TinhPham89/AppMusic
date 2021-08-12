package com.btcsc.appmp3.adapter;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.btcsc.appmp3.fragment.PlayNhacDanhSachFragment;
import com.btcsc.appmp3.fragment.PlayNhacDiskFragment;
import com.btcsc.appmp3.fragment.PlayNhacInformationFragment;
import com.btcsc.appmp3.model.BaiHatHot;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    BaiHatHot  baiHatHot;
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior, BaiHatHot baiHatHot ) {
        super(fm, behavior);
        this.baiHatHot = baiHatHot;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position)
        {
            case 0 :
            {
                fragment = PlayNhacInformationFragment.getInstance(baiHatHot);
                return fragment;
            }
            case 1 :
            {
                fragment = PlayNhacDiskFragment.getInstance(baiHatHot.getHinhbaihat());
                return fragment;
            }
            case 2 :
            {
                fragment = PlayNhacDanhSachFragment.getnstance(baiHatHot);
                return fragment;
            }
            default: return fragment;

        }

    }


    @Override
    public int getCount() {
        return 3;
    }

    public BaiHatHot getBaiHatHot() {
        return baiHatHot;
    }

    public void setBaiHatHot(BaiHatHot baiHatHot) {
        this.baiHatHot = baiHatHot;
    }
}
