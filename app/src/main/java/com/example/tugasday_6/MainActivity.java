package com.example.tugasday_6;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
//    private ParfumAdapter parfumAdapter;

    RecyclerView.Adapter recyclerViewAdapter;

    RecyclerView.LayoutManager recyclerViewLayoutManager;
    private ArrayList<ParfumModel> parfumModel;

    private ParfumAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        getData();

        recyclerView = findViewById(R.id.parfum);
        recyclerView.setHasFixedSize(true);

        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        setOnClickListener();
        recyclerViewAdapter = new ParfumAdapter(this, parfumModel,listener);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    private void setOnClickListener(){
        listener = new ParfumAdapter.RecyclerViewClickListener(){
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("namabarang", parfumModel.get(position).getNamaParfum());
                intent.putExtra("deskripsibarang", getDeskripsi(parfumModel.get(position).getNamaParfum()));
                intent.putExtra("hargabarang", getHarga(parfumModel.get(position).getNamaParfum()));
                intent.putExtra("gambarbarang",parfumModel.get(position).getGambarParfum());
                startActivity(intent);
            }
        };
    }

    private void getData() {
        parfumModel = new ArrayList<>();
        parfumModel.add(new ParfumModel("Chanel Coco Mademoiselle Intense Woman", R.drawable.parfcn1, "Parfum ini untuk Wanita jenisnya  EDP ukuran 100ml. Top Note : Orange, Mandarin Orange, Orange Blossom, Bergamot. Middle Note : Mimose, Jasmine, Turkish Rose, Ylang-Ylang. Base Note : Tonka Bean, Patchouli, Opoponax, Vanilla, Vetiver, White Musk. Parfum Chanel Coco Mademoiselle Intense Woman diluncurkan pada tahun 2001. No BPOM : NC14210600548", 3733000));
        parfumModel.add(new ParfumModel("Chanel Chance Eau Tendre Woman ED", R.drawable.parfcn2, "Parfum ini untuk wanita jenisnya EDT ukuran: 100 ml. Top Note: Grapefruit, Quince. Middle Note: Jasmine, Rose. Base Note: White Musk. Parfum Chanel Chance Eau Tendre Woman diluncurkan pada 2019. No BPOM : NC14180602506", 3298000));
        parfumModel.add(new ParfumModel("Chanel Gabrielle Essence EDP", R.drawable.parfcn3, "Parfum ini untuk wanita jenisnya EDP ukuran : 100ml. Top notes : Citruses, Peach, Red Fruits, Black Currant and Petitgrain. Middle notes : White Flowers, Tuberose, Ylang-Ylang, Jasmine, Orange Blossom and Coconut. Base notes : Musk, Vanilla and Sandalwood. Parfum Chanel Gabrielle Essence EDP diluncurkan pada tahun 2019. No BPOM : NC14210600537.", 3498000));
        parfumModel.add(new ParfumModel("Chanel Allure Homme Sport Eau Extreme Man", R.drawable.parfcn4, "Parfum ini untuk pria jenisnya EDT ukuran : 100ml. Top Note : Sage, Mandarin Orange, Mint, Cypress. Middle Note : Pepper. Base Note : Musk, Sandalwood, Cedar, Tonka Bean. Parfum Chanel Allure Homme Sport Eau Extreme Man diluncurkan pada tahun 2012. No BPOM : NC14210600506.", 3298000));
        parfumModel.add(new ParfumModel("Chanel Bleu De Chanel Man Parfum", R.drawable.parfcn5, "Parfum ini untuk Pria jenisnya Parfum ukuran : 100 ml. Top notes : Lemon Zest, Bergamot, Mint, Artemisia. Middle notes : Lavender, Geranium, Pineapple, Green Notes. Base notes : Sandalwood, Cedar, Amberwood, Iso E Super, Tonka Bean. Parfum Chanel Bleu De Chanel Man Parfum diluncurkan pada tahun 2018. No BPOM : NC14210600631.", 3498000));
        parfumModel.add(new ParfumModel("Gucci Flora by Gucci Gorgeous Gardenia Woman EDP", R.drawable.parfgc1, "Parfum ini untuk wanita jenisnya EDP ukuran : 100 ml. Top Notes : Pear Blossom, Red Berries and Italian Mandarin. Middle Notes : Gardenia, Jasmine and Frangipani. Base Notes : Brown sugar and Patchouli. Parfum Gucci Flora by Gucci Gorgeous Gardenia Woman EDP diluncurkan tahun 2021. No BPOM : NC47210600148.", 2248000));
        parfumModel.add(new ParfumModel("Gucci Bloom Woman", R.drawable.parfgc2, "Parfum ini untuk wanita jenisnya EDP ukuran : 100ml. Top Note: Green Notes, Orange. Middle Note: Honeysuckle, Tuberose. Base Note: Vanilla, Sandalwood. Parfum Gucci Bloom Woman diluncurkan pada tahun 2017. No BPOM : NC52170601605.", 1998000));
        parfumModel.add(new ParfumModel("Gucci Guilty Absolute Man", R.drawable.parfgc3, "Parfum ini ntuk pria jenisnya EDP ukuran : 90 ml. Top Note: Leather. Middle Note: Patchouli,Cypress. Base Note: Woody Notes, Vetiver. Parfum Gucci Absolute Man diluncurkan pada tahun 2017. No BPOM : NC52170601604.", 1948000));
        parfumModel.add(new ParfumModel("Gucci Bloom Acqua Di Fiori Woman EDT", R.drawable.parfgc4, "Parfum ini untuk Wanita jenisnya EDT ukuran : 100 ml. Top Notes : Galbanum Leaf, Cassis, Bergamot and Lemon. Middle Notes : Honeysuckle, Tuberose, Jasmine, Lily-of-the-Valley and Freesia. Base Notes : Musk, Iso E Super and Sandalwood. Parfum Gucci Bloom Acqua Di Fiori Woman EDT diluncurkan tahun 2018. No BPOM : NC16180602189.", 1948000));
        parfumModel.add(new ParfumModel("Gucci Guilty Pour Homme Man Parfum", R.drawable.parfgc5, "Parfum ini untuk pria jenisnya Parfum ukuran : 90 ml. Top Notes : Juniper, Lavender and Lemon. Middle Notes : Orange Blossom, Nutmeg and Spanish Labdanum. Base Notes : Patchouli, Dry Wood and Musk. Gucci Guilty Pour Homme Man Parfum diluncurkan tahun 2022. No BPOM : NC47220600010.", 2248000));
        parfumModel.add(new ParfumModel("Christian Dior Miss Dior Blooming Bouquet Woman", R.drawable.parfdr1, "Parfum ini untuk wanita jenisnya EDT ukuran : 100ml. Top Note : Sicilian Orange. Middle Note : Peony, Damask Rose, Apricot. Base Note : White Musk. Parfum Christian Dior Miss Dior Blooming Bouquet Woman diluncurkan pada tahun 2014. No BPOM: NC14210600278.", 2298000));
        parfumModel.add(new ParfumModel("Christian Dior J'adore Infinissime EDP", R.drawable.parfdr2, "Parfum ini untuk Wanita jenisnya EDP ukuran : 100 ml. Top Notes : Blood Orange, Pink Pepper and Bergamot. Middle Notes : Tuberose, Jasmine Sambac, Ylang-Ylang, Lily-of-the-Valley and Rose. Base Notes : Sandalwood. Parfum Christian Dior J’adore Infinissime EDP Intense diluncurkan pada tahun 2020. No BPOM : NC14200600182.", 3148000));
        parfumModel.add(new ParfumModel("Christian Dior Pure Poison Woman", R.drawable.parfdr3, "Parfum ini untuk wanita jenisnya EDP ukuran: 100ml. Top Note : Bergamot, Orange. Middle Notes: Neutral. Base Notes: Neutral. Christian Dior Pure Poison diluncurkan pada tahun 2004. No BPOM : NC14140602371.", 2948000));
        parfumModel.add(new ParfumModel("Christian Dior Sauvage Man", R.drawable.parfdr4, "Parfum ini untuk pria jenisnya Parfum ukuran: 100ml. Top Notes : Bergamot, Mandarin Orange and elemi. Middle Notes : Sandalwood. Base Notes : Olibanum, Tonka Bean and Vanilla. Parfum Christian Dior Sauvage Man diluncurkan pada tahun 2019. No BPOM : NC14190605184.", 2998000));
        parfumModel.add(new ParfumModel("Christian Dior Sauvage Elixir Man", R.drawable.parfdr5, "Parfum ini untuk pria jenisnya Elixir ukuran : 60 ML. Top Notes : Cinnamon, Nutmeg, Cardamom and Grapefruit. Middle Notes : Lavender. Base Notes : Licorice, Sandalwood, Amber, Patchouli and Haitian Vetiver. Parfum Christian Dior Sauvage Elixir Man diluncurkan pada tahun 2021. No BPOM : NC14210600217.", 3148000));
    }
    private String getDeskripsi(String namaParfum) {
        for (ParfumModel parfume : parfumModel) {
            if (parfume.getNamaParfum().equals(namaParfum)) {
                return parfume.getDeskripsiParfum();
            }
        }
        return "";
    }

    private double getHarga(String namaParfum) {
        for (ParfumModel parfum : parfumModel) {
            if (parfum.getNamaParfum().equals(namaParfum)) {
                return parfum.getHargaParfum();
            }
        }
        return 0.0;
    }
}