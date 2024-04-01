package com.example.tugasday_6;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.NumberFormat;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        String namaParfum = getIntent().getStringExtra("namabarang");
        String deskripsiParfum = getIntent().getStringExtra("deskripsibarang");
        double hargaParfum = getIntent().getDoubleExtra("hargabarang", 0.0);
        int gambarParfum = getIntent().getIntExtra("gambarbarang", R.drawable.ic_launcher_background);

        TextView namaTextView = findViewById(R.id.namabarang);
        TextView deskripsiTextView = findViewById(R.id.deskripsibarang);
        TextView hargaTextView = findViewById(R.id.hargabarang);
        ImageView gambarImageView = findViewById(R.id.gambarbarang);
        Button bagikanButton = findViewById(R.id.bagikan);

        namaTextView.setText(namaParfum);
        deskripsiTextView.setText(deskripsiParfum);
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        String formattedHarga = formatter.format(hargaParfum);
        hargaTextView.setText("Harga: " + formattedHarga);
        gambarImageView.setImageResource(gambarParfum);

        bagikanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), gambarParfum);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, bytes);
                String path = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "Title", null);
                Uri imageUri = Uri.parse(path);

                String shareText = "Check out this parfume: " + namaParfum + "\n\nDescription: " + deskripsiParfum + "\n\nPrice: " + hargaParfum;
                Intent shareIntent = new Intent(Intent.ACTION_SEND);

                shareIntent.setType("image/*");
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }
        });
    }
}