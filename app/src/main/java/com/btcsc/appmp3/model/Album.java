
package com.btcsc.appmp3.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Album implements Serializable {

    @SerializedName("Idalbum")
    @Expose
    private String idalbum;
    @SerializedName("Tenalbum")
    @Expose
    private String tenalbum;
    @SerializedName("Tencasi")
    @Expose
    private String tencasi;
    @SerializedName("Hinhalbum")
    @Expose
    private String hinhalbum;
    @SerializedName("Idcasi")
    @Expose
    private String idcasi;

    public String getIdalbum() {
        return idalbum;
    }

    public void setIdalbum(String idalbum) {
        this.idalbum = idalbum;
    }

    public String getTenalbum() {
        return tenalbum;
    }

    public void setTenalbum(String tenalbum) {
        this.tenalbum = tenalbum;
    }

    public String getTencasi() {
        return tencasi;
    }

    public void setTencasi(String tencasi) {
        this.tencasi = tencasi;
    }

    public String getHinhalbum() {
        return hinhalbum;
    }

    public void setHinhalbum(String hinhalbum) {
        this.hinhalbum = hinhalbum;
    }

    public String getIdcasi() {
        return idcasi;
    }

    public void setIdcasi(String idcasi) {
        this.idcasi = idcasi;
    }

}
