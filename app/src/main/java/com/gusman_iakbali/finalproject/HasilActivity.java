package com.gusman_iakbali.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HasilActivity extends AppCompatActivity {
    ImageView ivBantar;
    TextView tvDetailHitung, tvHasilHitung;
    String bantarName,detailHitung,hasilHitung;
    Button btnBack, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        bantarName = getIntent().getStringExtra("bantarName");
        detailHitung = getIntent().getStringExtra("Detail");
        hasilHitung = getIntent().getStringExtra("hasil");
        setupUI();
        setComponent();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtShare = "Hore! Saya telah berhasil menghitung luas "+ bantarName +
                        " dengan aplikasi bangun datar. Ayo! install aplikasinya sekarang juga";
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, txtShare);
                shareIntent.setType("text/plain");
                startActivity(shareIntent);
            }
        });
    }
    private void setComponent(){
        if (bantarName.equals("Jajar Genjang")){
            ivBantar.setImageResource(R.drawable.jajar);
        }else if (bantarName.equals("Layang - Layang")){
            ivBantar.setImageResource(R.drawable.layangan);
        }else if (bantarName.equals("Lingkaran")){
            ivBantar.setImageResource(R.drawable.lingkaran);
        }else if (bantarName.equals("Persegi")){
            ivBantar.setImageResource(R.drawable.persegi);
        }else if (bantarName.equals("Persegi Panjang")){
            ivBantar.setImageResource(R.drawable.persegipanjang);
        }else if (bantarName.equals("Segitiga")){
            ivBantar.setImageResource(R.drawable.segitiga);
        }else if (bantarName.equals("Trapesium")){
            ivBantar.setImageResource(R.drawable.trap);
        }else {
            Toast.makeText(this,"Undefined Bangun Datar",Toast.LENGTH_SHORT).show();
        }
        tvDetailHitung.setText(detailHitung);
        tvHasilHitung.setText(hasilHitung);
    }

    private void setupUI(){
        ivBantar = (ImageView)findViewById(R.id.ivBantarHasil);
        tvDetailHitung = (TextView)findViewById(R.id.tvDetailHitung);
        tvHasilHitung = (TextView)findViewById(R.id.tvHasilHitung);
        btnBack = (Button)findViewById(R.id.btnBackMenu);
        btnShare = (Button)findViewById(R.id.btnShare);
    }
}
