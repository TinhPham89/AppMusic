package com.btcsc.appmp3.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.adapter.ViewPagerAdapter;
import com.btcsc.appmp3.fragment.PlayNhacDiskFragment;
import com.btcsc.appmp3.model.BaiHatHot;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.zip.Inflater;

import me.relex.circleindicator.CircleIndicator;

public class PhatNhacActivity extends AppCompatActivity {
    TextView txtCasi, txtBaihat , txtTimePlay , txtSumPlay;
    ImageView btnPlay , btnRepeat,btnSuffle,btnNext,btnPreview;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    SeekBar seekBar;
    ViewPagerAdapter adapter;
    Toolbar toolbar;
    BaiHatHot baiHatHot = null;
    MediaPlayer mediaPlayer ;
    ArrayList<BaiHatHot> arrayListBaiHatHot;
    boolean repeat = false , random = false , next;
    int  position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phat_nhac);
        anhxa();
        dataIntent();
        phatNhac();
        showFragmet();

    }

    void anhxa ()
    {
        viewPager = findViewById(R.id.viewpagerplaynhac);
        txtSumPlay=findViewById(R.id.txtPlaySum);
        txtTimePlay=findViewById(R.id.txtTimeplay);
        btnNext=findViewById(R.id.next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next();
            }
        });
        btnPlay=findViewById(R.id.play);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 PlayandPause();
            }
        });
        btnPreview=findViewById(R.id.preview);
        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preview();
            }
        });
        btnRepeat =findViewById(R.id.repeat);
        btnRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Repeat();
            }
        });
        btnSuffle=findViewById(R.id.suffle);
        btnSuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RandomBaiHat();
            }
        });
        circleIndicator=findViewById(R.id.indicatorPlayNhac);
        seekBar=findViewById(R.id.seekBarNhac);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());

            }
        });
        toolbar = findViewById(R.id.toolbarPhatNhac);
        txtBaihat =toolbar.findViewById(R.id.txtNameBaiHat);
        txtCasi =toolbar.findViewById(R.id.txtCasiPlayNhac);
        setSupportActionBar(toolbar);

    }

    private void Preview() {
        if(arrayListBaiHatHot.size()>0)
        {
            if (mediaPlayer.isPlaying() || mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer= null;
            }
            if(position<arrayListBaiHatHot.size())
            {
                btnPlay.setImageResource(R.drawable.iconpause);
                position--;
                if(position<0)
                {
                    position = arrayListBaiHatHot.size()-1;
                }
                if(repeat == true)
                {
                    if(position==0)
                    {
                        position = arrayListBaiHatHot.size();
                    }
                    position +=1;
                }
                if(random == true)
                {
                    Random  random1 = new Random();
                    int index = random1.nextInt(arrayListBaiHatHot.size());
                    if(index == position)
                    {
                        position = index +1 ;

                    }
                    position = index;
                }
                if(position>(arrayListBaiHatHot.size()-1))
                {
                    position=0;
                }
                baiHatHot = arrayListBaiHatHot.get(position);
                baiHatHot = arrayListBaiHatHot.get(position);
                phatNhac();
                txtCasi.setText(baiHatHot.getTencasi());
                txtBaihat.setText(baiHatHot.getTenbaihat());
                showFragmet();
                updateTime();
            }
        }
    }

    private void Next() {
        if(arrayListBaiHatHot.size()>0)
        {
            if (mediaPlayer.isPlaying() || mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer= null;
            }
            if(position<arrayListBaiHatHot.size())
            {
                btnPlay.setImageResource(R.drawable.iconpause);
                position++;
                if(repeat == true)
                {
                    if(position==0)
                    {
                        position = arrayListBaiHatHot.size();
                    }
                    position -=1;
                }
                if(random == true)
                {
                    Random  random1 = new Random();
                    int index = random1.nextInt(arrayListBaiHatHot.size());
                    if(index == position)
                    {
                        position = index -1 ;

                    }
                    position = index;
                }
                if(position>(arrayListBaiHatHot.size()-1))
                {
                    position=0;
                }
                baiHatHot = arrayListBaiHatHot.get(position);
                phatNhac();
                txtCasi.setText(baiHatHot.getTencasi());
                txtBaihat.setText(baiHatHot.getTenbaihat());
                showFragmet();
                updateTime();

            }
        }
        btnNext.setClickable(false);
        btnPreview.setClickable(false);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                btnNext.setClickable(true);
                btnPreview.setClickable(true);
            }
        }, 3000);

    }

    private void RandomBaiHat() {
        if(random == false)
        {
            if(repeat == true)
            {
                repeat= false;
                btnRepeat.setImageResource(R.drawable.iconrepeat);
                btnSuffle.setImageResource(R.drawable.iconshuffled);
            }
            random = true ;
            btnSuffle.setImageResource(R.drawable.iconshuffled);
        }
        else
        {
            random= false;
            btnSuffle.setImageResource(R.drawable.iconsuffle);
        }
    }

    private void Repeat() {
        if(repeat == false)
        {
            if(random == true)
            {
                random = false;
                btnSuffle.setImageResource(R.drawable.iconsuffle);
                btnRepeat.setImageResource(R.drawable.iconsyned);
            }
            repeat= true;;
            btnRepeat.setImageResource(R.drawable.iconsyned);
        }
        else
        {
            repeat= false;
            btnRepeat.setImageResource(R.drawable.iconrepeat);
        }
    }

    private void PlayandPause() {
        if(!mediaPlayer.isPlaying())
        {
            mediaPlayer.start();
            btnPlay.setImageResource(R.drawable.iconpause);
        }
        else
        {
            mediaPlayer.pause();
            btnPlay.setImageResource(R.drawable.iconplay);
        }
    }

    void showFragmet()
    {
        adapter = new ViewPagerAdapter(getSupportFragmentManager() ,
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,baiHatHot);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);
        circleIndicator.setViewPager(viewPager);
    }
    void dataIntent()
    {
        Intent intent = getIntent();
        baiHatHot = (BaiHatHot) intent.getSerializableExtra("baihat");
        arrayListBaiHatHot = (ArrayList<BaiHatHot>) intent.getSerializableExtra("danhsachbaihat");
        if( baiHatHot != null &&!baiHatHot.getTenbaihat().equals(""))
        {
            arrayListBaiHatHot = new ArrayList<>();
            arrayListBaiHatHot.add(baiHatHot);
            txtBaihat.setText(baiHatHot.getTenbaihat());
            txtCasi.setText(baiHatHot.getTencasi());
        }
        else
        {
            baiHatHot=arrayListBaiHatHot.get(0);
            txtBaihat.setText(baiHatHot.getTenbaihat());
            txtCasi.setText(baiHatHot.getTencasi());
        }

    }
    void phatNhac()
    {
        PhatNhac  phatNhac = new PhatNhac();
        phatNhac.onPostExecute(baiHatHot.getLinkbaihat());
    }
    class PhatNhac extends AsyncTask<String, Void, String>
    {

        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String baihat) {
            super.onPostExecute(baihat);
            try {
                mediaPlayer = new MediaPlayer();
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
                else {
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mediaPlayer.stop();
                            mediaPlayer.reset();
                        }
                    });
                    mediaPlayer.setDataSource(baiHatHot.getLinkbaihat());
                    mediaPlayer.prepare();
                    btnPlay.setImageResource(R.drawable.iconpause);
                    mediaPlayer.start();
                    timeSong();
                    updateTime();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void timeSong()
    {
        int sumTime = mediaPlayer.getDuration();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        txtSumPlay.setText(simpleDateFormat.format(sumTime));
        seekBar.setMax(mediaPlayer.getDuration());
    }
    void updateTime()
    {
        Handler  handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mediaPlayer !=  null)
                {
                    seekBar.setProgress(mediaPlayer.getCurrentPosition());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                    txtTimePlay.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition()));
                    handler.postDelayed(this,300);
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            next = true ;
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }

            }
        },300);
        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(next == true)
                {
                    if(position<arrayListBaiHatHot.size())
                    {
                        btnPlay.setImageResource(R.drawable.iconpause);
                        position++;
                        if(repeat == true)
                        {
                            if(position==0)
                            {
                                position = arrayListBaiHatHot.size();
                            }
                            position -=1;
                        }
                        if(random == true)
                        {
                            Random  random1 = new Random();
                            int index = random1.nextInt(arrayListBaiHatHot.size());
                            if(index == position)
                            {
                                position = index -1 ;

                            }
                            position = index;
                        }
                        if(position>(arrayListBaiHatHot.size()-1))
                        {
                            position=0;
                        }
                        baiHatHot = arrayListBaiHatHot.get(position);
                        phatNhac();
                        txtCasi.setText(baiHatHot.getTencasi());
                        txtBaihat.setText(baiHatHot.getTenbaihat());
                        adapter = new ViewPagerAdapter(getSupportFragmentManager(),
                                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,baiHatHot);
                        viewPager.setAdapter(adapter);
                        viewPager.setCurrentItem(1);
                        circleIndicator.setViewPager(viewPager);

                    }
                    next = false;
                }
                else
                {
                    handler1.postDelayed(this, 10000);
                }

            }
        },1000);
    }
}