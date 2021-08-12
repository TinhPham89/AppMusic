package com.btcsc.appmp3.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.activity.TheloaiActivity;
import com.btcsc.appmp3.adapter.TheloaiAdapter;
import com.btcsc.appmp3.model.Theloai;
import com.btcsc.appmp3.sevice.APIService;
import com.btcsc.appmp3.sevice.Service;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TheloaiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TheloaiFragment extends Fragment {
    RecyclerView recyclerView;
    TheloaiAdapter theloaiAdapter;
    ArrayList<Theloai> theloaiArrayList;
    LinearLayout  linearLayout;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TheloaiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TheloaiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TheloaiFragment newInstance(String param1, String param2) {
        TheloaiFragment fragment = new TheloaiFragment();
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
        return inflater.inflate(R.layout.fragment_theloai, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recylerviewTheloai);
        linearLayout = view.findViewById(R.id.linearlayouttheloai);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), TheloaiActivity.class));
            }
        });
        getData();
    }
    void getData()
    {
        Service service = APIService.getService();
        Call<ArrayList<Theloai>> call = service.getTheloai();
        call.enqueue(new Callback<ArrayList<Theloai>>() {
            @Override
            public void onResponse(Call<ArrayList<Theloai>> call, Response<ArrayList<Theloai>> response) {
                theloaiArrayList = response.body();
                theloaiAdapter = new TheloaiAdapter(getContext(),theloaiArrayList);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                        LinearLayoutManager.HORIZONTAL,false));
                recyclerView.setAdapter(theloaiAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Theloai>> call, Throwable t) {
                Log.d("ABC",t.getMessage());

            }
        });
    }
}