package com.btcsc.appmp3.adapter;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.btcsc.appmp3.fragment.AlbumFragment;
import com.btcsc.appmp3.fragment.CasiFragment;
import com.btcsc.appmp3.fragment.ChudeFragment;
import com.btcsc.appmp3.fragment.HomeFragment;
import com.btcsc.appmp3.fragment.PlaylistFragment;
import com.btcsc.appmp3.fragment.TheloaiFragment;

public class FragmentAdapterTypeChoose extends FragmentStatePagerAdapter {


    public FragmentAdapterTypeChoose(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch(position)
        {
            case 0 :
            {
                fragment= new PlaylistFragment();
                break;
            }
            case 1:
            {
                fragment= new AlbumFragment();
                break;
            }
            case 2:
            {
                fragment= new CasiFragment();
                break;

            }
            default: fragment= null;
        }
        return  fragment;
    }
    @Override
    public int getCount() {
        return 3;
    }
}
