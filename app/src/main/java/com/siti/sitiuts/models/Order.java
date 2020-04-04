package com.siti.sitiuts.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Order implements Parcelable {

    private String nama;
    private String nomor;
    private String pesan;
    private String jumlah;

    public Order(String nama, String nomor, String pesan, String jumlah) {
        this.nama = nama;
        this.nomor = nomor;
        this.pesan = pesan;
        this.jumlah = jumlah;
    }

    public Order() {

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    protected Order(Parcel in) {
        this.nama = in.readString();
        this.nomor = in.readString();
        this.pesan = in.readString();
        this.jumlah = in.readString();
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel source) {
            return new Order(source);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.nomor);
        dest.writeString(this.pesan);
        dest.writeString(this.jumlah);
    }
}