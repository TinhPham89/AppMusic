package com.btcsc.appmp3.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.adapter.BaiHatHotAdapter;
import com.btcsc.appmp3.model.BaiHatHot;
import com.btcsc.appmp3.sevice.APIService;
import com.btcsc.appmp3.sevice.Service;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BaihathotFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BaihathotFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<BaiHatHot> baiHatHotArrayList;
    BaiHatHotAdapter baiHatHotAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BaihathotFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BaihathotFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BaihathotFragment newInstance(String param1, String param2) {
        BaihathotFragment fragment = new BaihathotFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_baihathot, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recylerviewBaihathot);
        getData();
    }

    private void getData() {
        Service service = APIService.getService();
        Call<ArrayList<BaiHatHot>> call = service.getBaihatHot();
        call.enqueue(new Callback<ArrayList<BaiHatHot>>() {
            @Override
            public void onResponse(Call<ArrayList<BaiHatHot>> call, Response<ArrayList<BaiHatHot>> response) {
                baiHatHotArrayList = response.body();
                baiHatHotAdapter = new BaiHatHotAdapter(baiHatHotArrayList,getContext());
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                        LinearLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(baiHatHotAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<BaiHatHot>> call, Throwable t) {

            }
        });
    }
}