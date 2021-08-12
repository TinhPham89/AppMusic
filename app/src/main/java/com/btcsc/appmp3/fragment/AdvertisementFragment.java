package com.btcsc.appmp3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.adapter.BannerAdapter;
import com.btcsc.appmp3.model.Banner;
import com.btcsc.appmp3.sevice.APIService;
import com.btcsc.appmp3.sevice.Service;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdvertisementFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdvertisementFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ViewPager viewPager;
    CircleIndicator circleIndicator;
    BannerAdapter bannerAdapter;
    Runnable runnable;
    Handler handler;
    int time;

    public AdvertisementFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AdvertisementFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AdvertisementFragment newInstance(String param1, String param2) {
        AdvertisementFragment fragment = new AdvertisementFragment();
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
        View view = inflater.inflate(R.layout.fragment_advertisement, container, false);
        viewPager = view.findViewById(R.id.viewpager);
        circleIndicator= view.findViewById(R.id.indicator);
        // Inflate the layout for this fragment

        getData();

        return view ;
    }

    private  void getData()
    {
        Service service = APIService.getService();
        Call<ArrayList<Banner>> call = service.getBanner();
        call.enqueue(new Callback<ArrayList<Banner>>() {
            @Override
            public void onResponse(Call<ArrayList<Banner>> call, Response<ArrayList<Banner>> response) {
                ArrayList<Banner> banners =  response.body();
                bannerAdapter = new BannerAdapter(getContext(),banners);
                viewPager.setAdapter(bannerAdapter);
                circleIndicator.setViewPager(viewPager);

                handler = new Handler() ;
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        time = viewPager.getCurrentItem();
                        time++;
                        if(time>= viewPager.getAdapter().getCount())
                        {
                            time=0;
                        }
                        viewPager.setCurrentItem(time,true);
                        handler.postDelayed(runnable,4500);
                    }
                };
                handler.postDelayed(runnable,4500);
            }

            @Override
            public void onFailure(Call<ArrayList<Banner>> call, Throwable t) {
                Log.d("ABC",t.getMessage());

            }
        });
    }


}