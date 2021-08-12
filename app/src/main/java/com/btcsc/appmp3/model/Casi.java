
package com.btcsc.appmp3.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Casi implements Serializable {

    @SerializedName("Idcasi")
    @Expose
    private String idcasi;
    @SerializedName("Tencasi")
    @Expose
    private String tencasi;
    @SerializedName("Namsinh")
    @Expose
    private String namsinh;
    @SerializedName("Thongtin")
    @Expose
    private String thongtin;
    @SerializedName("Hinhcasi")
    @Expose
    private String hinhcasi;

    public String getIdcasi() {
        return idcasi;
    }

    public void setIdcasi(String idcasi) {
        this.idcasi = idcasi;
    }

    public String getTencasi() {
        return tencasi;
    }

    public void setTencasi(String tencasi) {
        this.tencasi = tencasi;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getThongtin() {
        return thongtin;
    }

    public void setThongtin(String thongtin) {
        this.thongtin = thongtin;
    }

    public String getHinhcasi() {
        return hinhcasi;
    }

    public void setHinhcasi(String hinhcasi) {
        this.hinhcasi = hinhcasi;
    }

}
