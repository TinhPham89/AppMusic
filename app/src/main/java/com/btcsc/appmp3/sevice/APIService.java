package com.btcsc.appmp3.sevice;

public class APIService {
    public  static String url = "https://tinhpham08091998.000webhostapp.com/Server/" ;
    public  static   Service getService ()
    {
        return  APIRetrofit.getRetrofit(url).create(Service.class);
    }
}
