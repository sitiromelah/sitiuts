package com.siti.sitiuts.entities;

public class Pesan {
    private int id;
    private String nama;
    private String nomor;
    private String pesan;
    private String jumlah;

    public Pesan()
    {
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setPesan(String pesan){
        this.pesan = pesan;
    }
    public String getPesan(){
        return pesan;
    }

    public String getJumlah(){
        return jumlah;
    }

    public void setJumlah(String jumlah){
        this.jumlah = jumlah;
    }
}
