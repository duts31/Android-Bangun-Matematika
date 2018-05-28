package com.gusman_iakbali.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailBangundatarActivity extends AppCompatActivity {

    ImageView ivBantar;
    TextView tvDetailBantar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_bangundatar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setupUI();
    }

    private void setupUI(){
        ivBantar = (ImageView)findViewById(R.id.ivBantar);
        tvDetailBantar = (TextView)findViewById(R.id.tvDetailBantar);

        String bantarName = getIntent().getStringExtra("bantar");
        if (bantarName.equals("Jajar Genjang")){
            ivBantar.setImageResource(R.drawable.jajar);
            tvDetailBantar.setText(R.string.detailJajar);
        }else if (bantarName.equals("Layang - Layang")){
            ivBantar.setImageResource(R.drawable.layangan);
            tvDetailBantar.setText(R.string.detailLayang);
        }else if (bantarName.equals("Lingkaran")){
            ivBantar.setImageResource(R.drawable.lingkaran);
            tvDetailBantar.setText(R.string.detailLingkaran);
        }else if (bantarName.equals("Persegi")){
            ivBantar.setImageResource(R.drawable.persegi);
            tvDetailBantar.setText(R.string.detailPersegi);
        }else if (bantarName.equals("Persegi Panjang")){
            ivBantar.setImageResource(R.drawable.persegipanjang);
            tvDetailBantar.setText(R.string.detailPanjang);
        }else if (bantarName.equals("Segitiga")){
            ivBantar.setImageResource(R.drawable.segitiga);
            tvDetailBantar.setText(R.string.detailSegitiga);
        }else if (bantarName.equals("Trapesium")){
            ivBantar.setImageResource(R.drawable.trap);
            tvDetailBantar.setText(R.string.detailTrap);
        }else {
            Toast.makeText(this,"Undefined Bangun Datar",Toast.LENGTH_SHORT).show();
        }
    }
}
