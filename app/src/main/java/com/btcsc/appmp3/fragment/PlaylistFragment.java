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
import android.widget.Toast;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.activity.PlaylistActivity;
import com.btcsc.appmp3.adapter.PlaylistAdapter;
import com.btcsc.appmp3.model.Playlist;
import com.btcsc.appmp3.sevice.APIService;
import com.btcsc.appmp3.sevice.Service;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlaylistFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlaylistFragment extends Fragment {

    RecyclerView  recyclerView;
    ArrayList<Playlist> playlists;
    PlaylistAdapter adapter;
    LinearLayout linearLayout;
    
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PlaylistFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlaylistFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlaylistFragment newInstance(String param1, String param2) {
        PlaylistFragment fragment = new PlaylistFragment();
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
        View view = inflater.inflate(R.layout.fragment_playlist, container, false);
        // Inflate the layout for this fragment
        return view ;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
        recyclerView = view.findViewById(R.id.recylerViewPlaylist);
        linearLayout = view.findViewById(R.id.linearlayoutplaylist);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PlaylistActivity.class));
            }
        });

    }

    private void getData() {
        Service service= APIService.getService();
        Call<ArrayList<Playlist>> call = service.getPlaylist();
        call.enqueue(new Callback<ArrayList<Playlist>>() {
            @Override
            public void onResponse(Call<ArrayList<Playlist>> call, Response<ArrayList<Playlist>> response) {

               playlists = response.body();
                adapter = new PlaylistAdapter(playlists,getContext());
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                        LinearLayoutManager.HORIZONTAL,false));
                recyclerView.setAdapter(adapter);


            }
            @Override
            public void onFailure(Call<ArrayList<Playlist>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }

}