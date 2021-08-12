
package com.btcsc.appmp3.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BaiHatHot implements Serializable {

    @SerializedName("Idbaihat")
    @Expose
    private String idbaihat;
    @SerializedName("Idalbum")
    @Expose
    private String idalbum;
    @SerializedName("Idtheloai")
    @Expose
    private String idtheloai;
    @SerializedName("Idplaylist")
    @Expose
    private String idplaylist;
    @SerializedName("Idcasi")
    @Expose
    private String idcasi;
    @SerializedName("Tenbaihat")
    @Expose
    private String tenbaihat;
    @SerializedName("Hinhbaihat")
    @Expose
    private String hinhbaihat;
    @SerializedName("Tencasi")
    @Expose
    private String tencasi;
    @SerializedName("Linkbaihat")
    @Expose
    private String linkbaihat;
    @SerializedName("Luotthich")
    @Expose
    private String luotthich;

    public String getIdbaihat() {
        return idbaihat;
    }

    public void setIdbaihat(String idbaihat) {
        this.idbaihat = idbaihat;
    }

    public String getIdalbum() {
        return idalbum;
    }

    public void setIdalbum(String idalbum) {
        this.idalbum = idalbum;
    }

    public String getIdtheloai() {
        return idtheloai;
    }

    public void setIdtheloai(String idtheloai) {
        this.idtheloai = idtheloai;
    }

    public String getIdplaylist() {
        return idplaylist;
    }

    public void setIdplaylist(String idplaylist) {
        this.idplaylist = idplaylist;
    }

    public String getIdcasi() {
        return idcasi;
    }

    public void setIdcasi(String idcasi) {
        this.idcasi = idcasi;
    }

    public String getTenbaihat() {
        return tenbaihat;
    }

    public void setTenbaihat(String tenbaihat) {
        this.tenbaihat = tenbaihat;
    }

    public String getHinhbaihat() {
        return hinhbaihat;
    }

    public void setHinhbaihat(String hinhbaihat) {
        this.hinhbaihat = hinhbaihat;
    }

    public String getTencasi() {
        return tencasi;
    }

    public void setTencasi(String tencasi) {
        this.tencasi = tencasi;
    }

    public String getLinkbaihat() {
        return linkbaihat;
    }

    public void setLinkbaihat(String linkbaihat) {
        this.linkbaihat = linkbaihat;
    }

    public String getLuotthich() {
        return luotthich;
    }

    public void setLuotthich(String luotthich) {
        this.luotthich = luotthich;
    }

}
