package com.btcsc.appmp3.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.adapter.FragmentAdapterTypeChoose;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabChooseTypeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabChooseTypeFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentAdapterTypeChoose  adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TabChooseTypeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabChooseTypeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TabChooseTypeFragment newInstance(String param1, String param2) {
        TabChooseTypeFragment fragment = new TabChooseTypeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
        View view =inflater.inflate(R.layout.fragment_tab_choose_type, container, false);
        // Inflate the layout for this fragment
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = (ViewPager)view.findViewById(R.id.viewpager1);

        tabLayout.setupWithViewPager(viewPager);

        FragmentManager fm = getChildFragmentManager();
        adapter = new FragmentAdapterTypeChoose(fm,
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);

        tabLayout.getTabAt(0).setText("Playlist");
        tabLayout.getTabAt(1).setText("Album");
        tabLayout.getTabAt(2).setText("Ca sĩ");
    }
}