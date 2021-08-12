package com.btcsc.appmp3.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.model.BaiHatHot;
import com.squareup.picasso.Picasso;

import java.util.StringTokenizer;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlayNhacInformationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayNhacInformationFragment extends Fragment {
    TextView txtName, txtCaSi, txtTheLoai , txtAlbum ;
    ImageView imageBaihatHot;
    BaiHatHot baiHatHot;
    RecyclerView recyclerView;
    String id;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PlayNhacInformationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlayNhacInformationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlayNhacInformationFragment newInstance(String param1, String param2) {
        PlayNhacInformationFragment fragment = new PlayNhacInformationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public static PlayNhacInformationFragment getInstance(BaiHatHot  baiHatHot) {
        PlayNhacInformationFragment fragment = new PlayNhacInformationFragment();
        Bundle args = new Bundle();
        args.putSerializable("baihathot",baiHatHot);
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
//        BaiHatHot baiHat  = (BaiHatHot) getArguments().getSerializable("baihathot");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play_nhac_information, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtTheLoai = view.findViewById(R.id.txtTheLoaiPhatNhac);
        txtAlbum = view.findViewById(R.id.txtNameAlbumPhatNhac);
        txtCaSi = view.findViewById(R.id.txtNameCaSiPhatNhac);
        txtName = view.findViewById(R.id.txtNameBaiHatPhatNhac);
        imageBaihatHot = view.findViewById(R.id.imgBaiHatPhatNhac);
        if(getArguments()!=null)
        {
            baiHatHot = (BaiHatHot) getArguments().getSerializable("baihathot");
            txtName.setText("Bài hát : "+baiHatHot.getTenbaihat());
            txtCaSi.setText("Ca sĩ : "+baiHatHot.getTencasi());
            layIdAlbum();
            txtTheLoai.setText("Thể loại : "+baiHatHot.getIdtheloai());
            Picasso.get().load(baiHatHot.getHinhbaihat()).into(imageBaihatHot);
        }
        else
        {
            Log.d("ABC","null In4");
        }
    }

    void layIdAlbum()
    {
        StringTokenizer stringTokenizer = new StringTokenizer(baiHatHot.getIdalbum(),",");
        id = "";
        while (stringTokenizer.hasMoreTokens())
        {
            id+=stringTokenizer.nextToken();
        }
        txtAlbum.setText(id);


    }

}