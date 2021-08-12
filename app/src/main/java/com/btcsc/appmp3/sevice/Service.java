package com.btcsc.appmp3.sevice;

import com.btcsc.appmp3.model.Album;
import com.btcsc.appmp3.model.BaiHatHot;
import com.btcsc.appmp3.model.Banner;
import com.btcsc.appmp3.model.Casi;
import com.btcsc.appmp3.model.Chude;
import com.btcsc.appmp3.model.Playlist;
import com.btcsc.appmp3.model.Theloai;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Service {
    @GET("songbanner.php")
    Call<ArrayList<Banner>> getBanner ();

    @GET("playlist.php")
    Call<ArrayList<Playlist>> getPlaylist();

    @GET("album.php")
    Call<ArrayList<Album>> getAlbum();

    @GET("casi.php")
    Call<ArrayList<Casi>> getCasi();

    @GET("chude.php")
    Call<ArrayList<Chude>> getChude();

    @GET("theloai.php")
    Call<ArrayList<Theloai>> getTheloai();

    @GET("baihatyeuthich.php")
    Call<ArrayList<BaiHatHot>> getBaihatHot();

    @FormUrlEncoded
    @POST("baihatquangcao.php")
    Call<ArrayList<BaiHatHot>> getBaihatQuangCao(@Field("idquangcao") String id);

    @FormUrlEncoded
    @POST("baihatplaylist.php")
    Call<ArrayList<BaiHatHot>> getBaihatPlaylist(@Field("idplaylist") String id);

    @FormUrlEncoded
    @POST("baihatalbum.php")
    Call<ArrayList<BaiHatHot>> getBaihatAlbum(@Field("idalbum") String id);

    @FormUrlEncoded
    @POST("baihatcasi.php")
    Call<ArrayList<BaiHatHot>> getBaihatCaSi(@Field("idcasi") String id);

    @FormUrlEncoded
    @POST("baihattheloai.php")
    Call<ArrayList<BaiHatHot>> getBaihatTheLoai(@Field("idtheloai") String id);

    @GET("danhsachalbum.php")
    Call<ArrayList<Album>> getListAlbum();

    @GET("danhsachcasi.php")
    Call<ArrayList<Casi>> getListCaSi();

    @GET("danhsachplaylist.php")
    Call<ArrayList<Playlist>> getListPlayList();

    @GET("danhsachchude.php")
    Call<ArrayList<Chude>> getListChude();

    @GET("danhsachtheloai.php")
    Call<ArrayList<Theloai>> getListTheloai();
    @GET("baihatdexuat.php")
    Call<ArrayList<BaiHatHot>> getBaiHatDeXuat();

}
