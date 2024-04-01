package com.example.tugasday_6;

public class ParfumModel {
    private String namaParfum;
    private int gambarParfum;
    private String deskripsiParfum;
    private double hargaParfum;

    public ParfumModel(String namaParfum, int gambarParfum, String deskripsiParfum, double hargaParfum) {
        this.namaParfum = namaParfum;
        this.gambarParfum = gambarParfum;
        this.deskripsiParfum = deskripsiParfum;
        this.hargaParfum = hargaParfum;
    }

    public String getNamaParfum() {
        return namaParfum;
    }

    public void setNamaParfum(String namaParfum) { this.namaParfum = namaParfum; }

    public int getGambarParfum() {
        return gambarParfum;
    }

    public void setGambarParfum(int gambarParfum) {
        this.gambarParfum = gambarParfum;
    }

    public String getDeskripsiParfum() {
        return deskripsiParfum;
    }

    public void setDeskripsiParfum(String deskripsiParfum) { this.deskripsiParfum = deskripsiParfum;}

    public double getHargaParfum() { return hargaParfum; }

    public void setHargaParfum(double hargaParfum) { this.hargaParfum = hargaParfum; }


}