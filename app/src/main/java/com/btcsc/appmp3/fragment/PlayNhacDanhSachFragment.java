package com.btcsc.appmp3.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.activity.PhatNhacActivity;
import com.btcsc.appmp3.adapter.BaiHatDeXuatAdapter;
import com.btcsc.appmp3.adapter.BaiHatHotAdapter;
import com.btcsc.appmp3.adapter.BaiHatQuangCaoAdapter;
import com.btcsc.appmp3.model.BaiHatHot;
import com.btcsc.appmp3.sevice.APIService;
import com.btcsc.appmp3.sevice.Service;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlayNhacDanhSachFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayNhacDanhSachFragment extends Fragment  {

    RecyclerView recyclerView ,rvDeXuat ;
    ArrayList<BaiHatHot> arrayList, arrayListDeXuat;
    BaiHatDeXuatAdapter adapter ;
    BaiHatHotAdapter adapterDexuat ;
    Switch  aSwitch;
    BaiHatHot  status ;
    BaiHatHot baiHatHot = null , baiHat1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PlayNhacDanhSachFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlayNhacDanhSachFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlayNhacDanhSachFragment newInstance(String param1, String param2) {
        PlayNhacDanhSachFragment fragment = new PlayNhacDanhSachFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public static PlayNhacDanhSachFragment getnstance(BaiHatHot baiHat) {
        PlayNhacDanhSachFragment fragment = new PlayNhacDanhSachFragment();
        Bundle args = new Bundle();
        args.putSerializable("baihatdanhsach",baiHat);
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play_nhac_danh_sach, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvDanhSachPlayNhac);
        rvDeXuat = view.findViewById(R.id.rvDanhSachDeXuat);
        aSwitch = view.findViewById(R.id.switchHienThiDeXuat);
        dataIntent();

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(aSwitch.isChecked())
                {
                    dexuat();
                    rvDeXuat.setVisibility(View.VISIBLE);
                }
                else
                {
                    rvDeXuat.setVisibility(View.GONE);
                }
            }
        });
    }
    void dataIntent()
    {
        Intent intent = getActivity().getIntent();
        baiHatHot = (BaiHatHot) intent.getSerializableExtra("baihat");
        arrayList = (ArrayList<BaiHatHot>) intent.getSerializableExtra("danhsachbaihat");
        if( baiHatHot != null &&!baiHatHot.getTenbaihat().equals(""))
        {
            arrayList = new ArrayList<>();
            arrayList.add(baiHatHot);
            if(getArguments() !=  null)
            {
                baiHat1 = new BaiHatHot();
                baiHat1 = (BaiHatHot) getArguments().getSerializable("baihatdanhsach");

            }
            Log.e("ABC", "fragment"+baiHat1.getTenbaihat());
            adapter = new BaiHatDeXuatAdapter(arrayList,getContext(),baiHat1);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                    RecyclerView.VERTICAL,false));
            recyclerView.setAdapter(adapter);
        }
        else
        {
            if(getArguments() !=  null)
            {
                baiHat1 = new BaiHatHot();
                baiHat1 = (BaiHatHot) getArguments().getSerializable("baihatdanhsach");

            }
            Log.e("ABC", "fragment"+baiHat1.getTenbaihat());
            adapter = new BaiHatDeXuatAdapter(arrayList,getContext(),baiHat1);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                    RecyclerView.VERTICAL,false));
            recyclerView.setAdapter(adapter);
        }

    }
    void dexuat()
    {
        Service service = APIService.getService();
        Call<ArrayList<BaiHatHot>>   call = service.getBaiHatDeXuat();
        call.enqueue(new Callback<ArrayList<BaiHatHot>>() {
            @Override
            public void onResponse(Call<ArrayList<BaiHatHot>> call, Response<ArrayList<BaiHatHot>> response) {
                arrayListDeXuat = response.body();
                adapterDexuat = new BaiHatHotAdapter(arrayListDeXuat,(PhatNhacActivity)getActivity());
                rvDeXuat.setLayoutManager(new LinearLayoutManager(getActivity()
                ,RecyclerView.VERTICAL,false));
                rvDeXuat.setAdapter(adapterDexuat);
            }

            @Override
            public void onFailure(Call<ArrayList<BaiHatHot>> call, Throwable t) {

            }
        });
    }

}