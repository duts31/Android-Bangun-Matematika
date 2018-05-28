package com.gusman_iakbali.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HitungActivity extends AppCompatActivity {

    LinearLayout inputPersegi, inputPanjang, inputJajar,
            inputLayang, inputLingkaran, inputSegitiga, inputTrap;
    EditText etSisiPersegi, etPanjangPersegi, etLebarPersegi,
            etAlasJajar, etTinggiJajar, etDiagonal1, etDiagonal2,
            etJari, etAlasSegitiga, etTinggiSegitiga, etAlasTrap, etAtasTrap, etTinggiTrap;
    Button btnHitung;
    ImageView ivBantar;
    String bantarName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bantarName = getIntent().getStringExtra("bantar");
        setupUI();
        showComponent();
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitungLuas();
            }
        });
    }

    private void setupUI(){
        inputPersegi = (LinearLayout)findViewById(R.id.inputPersegi);
        inputPanjang = (LinearLayout)findViewById(R.id.inputPanjang);
        inputJajar = (LinearLayout)findViewById(R.id.inputJajar);
        inputLayang = (LinearLayout)findViewById(R.id.inputLayang);
        inputLingkaran = (LinearLayout)findViewById(R.id.inputLingkaran);
        inputSegitiga =  (LinearLayout)findViewById(R.id.inputSegitiga);
        inputTrap = (LinearLayout)findViewById(R.id.inputTrap);

        etSisiPersegi = (EditText)findViewById(R.id.etSisiPersegi);

        etPanjangPersegi =(EditText)findViewById(R.id.etPanjangPersegi);
        etLebarPersegi = (EditText)findViewById(R.id.etLebarPersegi);

        etAlasJajar = (EditText)findViewById(R.id.etAlasJajar);
        etTinggiJajar = (EditText)findViewById(R.id.etTinggiJajar);

        etDiagonal1 = (EditText)findViewById(R.id.etDiagonal1);
        etDiagonal2 = (EditText)findViewById(R.id.etDiagonal2);

        etJari = (EditText)findViewById(R.id.etJari);

        etAlasSegitiga = (EditText)findViewById(R.id.etAlasSegitiga);
        etTinggiSegitiga = (EditText)findViewById(R.id.etTinggiSegitiga);

        etAlasTrap = (EditText)findViewById(R.id.etALasTrap);
        etAtasTrap = (EditText)findViewById(R.id.etAtasTrap);
        etTinggiTrap = (EditText)findViewById(R.id.etTinggiTrap);

        btnHitung = (Button)findViewById(R.id.btnHitung);

        ivBantar = (ImageView)findViewById(R.id.ivGambarBantar);
    }

    private void showComponent(){
        if (bantarName.equals("Jajar Genjang")){
            ivBantar.setImageResource(R.drawable.jajar);
            inputJajar.setVisibility(View.VISIBLE);
        }else if (bantarName.equals("Layang - Layang")){
            ivBantar.setImageResource(R.drawable.layangan);
            inputLayang.setVisibility(View.VISIBLE);
        }else if (bantarName.equals("Lingkaran")){
            ivBantar.setImageResource(R.drawable.lingkaran);
            inputLingkaran.setVisibility(View.VISIBLE);
        }else if (bantarName.equals("Persegi")){
            ivBantar.setImageResource(R.drawable.persegi);
            inputPersegi.setVisibility(View.VISIBLE);
        }else if (bantarName.equals("Persegi Panjang")){
            ivBantar.setImageResource(R.drawable.persegipanjang);
            inputPanjang.setVisibility(View.VISIBLE);
        }else if (bantarName.equals("Segitiga")){
            ivBantar.setImageResource(R.drawable.segitiga);
            inputSegitiga.setVisibility(View.VISIBLE);
        }else if (bantarName.equals("Trapesium")){
            ivBantar.setImageResource(R.drawable.trap);
            inputTrap.setVisibility(View.VISIBLE);
        }else {
            Toast.makeText(this,"Undefined Bangun Datar",Toast.LENGTH_SHORT).show();
        }
    }

    private void hitungLuas(){
        if (bantarName.equals("Jajar Genjang")){
            luasJajarGenjang();
        }else if (bantarName.equals("Layang - Layang")){
            luasLayangLayang();
        }else if (bantarName.equals("Lingkaran")){
            luasLingkaran();
        }else if (bantarName.equals("Persegi")){
            luasPersegi();
        }else if (bantarName.equals("Persegi Panjang")){
            luasPersegiPanjang();
        }else if (bantarName.equals("Segitiga")){
            luasSegitiga();
        }else if (bantarName.equals("Trapesium")){
            luasTrapesium();
        }else {
            Toast.makeText(this,"Undefined Bangun Datar",Toast.LENGTH_SHORT).show();
        }
    }

    private void luasPersegi(){
        if(etSisiPersegi.getText().toString().trim().equals("")){
            etSisiPersegi.setError("Masukkan Panjang sisi");
        }else{
            float sisi = Float.valueOf(etSisiPersegi.getText().toString());
            float hasil = sisi*sisi;
            Intent intent = new Intent(HitungActivity.this, HasilActivity.class);
            intent.putExtra("bantarName",bantarName);
            intent.putExtra("Detail",
                    "Luas Persegi" +
                    "\ndengan panjang sisi = "+sisi);
            intent.putExtra("hasil",String.valueOf(hasil));
            startActivity(intent);
        }
    }

    private void luasPersegiPanjang(){
        if (etPanjangPersegi.getText().toString().trim().equals("")){
            etPanjangPersegi.setError("Masukkan Nilai Panjang");
        }else if(etLebarPersegi.getText().toString().trim().equals("")){
            etLebarPersegi.setError("Masukkan Nilai Lebar");
        }else {
            float panjang = Float.valueOf(etPanjangPersegi.getText().toString());
            float lebar = Float.valueOf(etLebarPersegi.getText().toString());
            float hasil = panjang*lebar;
            Intent intent = new Intent(HitungActivity.this, HasilActivity.class);
            intent.putExtra("bantarName",bantarName);
            intent.putExtra("Detail",
                    "Luas Persegi Panjang" +
                    "\ndengan panjang = "+panjang+"" +
                    "\ndan lebar = "+lebar);
            intent.putExtra("hasil",String.valueOf(hasil));
            startActivity(intent);
        }
    }

    private void luasJajarGenjang(){
        if(etAlasJajar.getText().toString().trim().equals("")){
            etAlasJajar.setError("Masukkan Nilai Alas");
        }else if(etTinggiJajar.getText().toString().trim().equals("")){
            etTinggiJajar.setError("Masukkan Nilai Tinggi");
        }else {
            float alas = Float.valueOf(etAlasJajar.getText().toString());
            float tinggi = Float.valueOf(etTinggiJajar.getText().toString());
            float hasil = alas*tinggi;
            Intent intent = new Intent(HitungActivity.this, HasilActivity.class);
            intent.putExtra("bantarName",bantarName);
            intent.putExtra("Detail",
                    "Luas Jajar Genjang" +
                    "\ndengan alas = "+alas+"" +
                    "\ndan tinggi = "+tinggi);
            intent.putExtra("hasil",String.valueOf(hasil));
            startActivity(intent);
        }
    }

    private void luasLayangLayang(){
        if (etDiagonal1.getText().toString().trim().equals("")){
            etDiagonal1.setError("Masukkan Nilai Diagonal 1");
        }else if (etDiagonal2.getText().toString().trim().equals("")){
            etDiagonal2.setError("Masukkan Nilai Diagonal 2");
        }else {
            float d1 = Float.valueOf(etDiagonal1.getText().toString());
            float d2 = Float.valueOf(etDiagonal2.getText().toString());
            float hasil = (float) 1/2*d1*d2;
            Intent intent = new Intent(HitungActivity.this, HasilActivity.class);
            intent.putExtra("bantarName",bantarName);
            intent.putExtra("Detail",
                    "Luas Layang - Layang" +
                    "\ndengan diagonal 1 = "+d1+"" +
                    "\ndan diagonal 2 = "+d2);
            intent.putExtra("hasil",String.valueOf(hasil));
            startActivity(intent);
        }
    }

    private void luasLingkaran(){
        if (etJari.getText().toString().trim().equals("")){
            etJari.setError("Masukkan Nilai Jari -Jari");
        }else {
            float jariJari = Float.valueOf(etJari.getText().toString());
            float hasil = (float) 22/7*jariJari*jariJari;
            Intent intent = new Intent(HitungActivity.this, HasilActivity.class);
            intent.putExtra("bantarName",bantarName);
            intent.putExtra("Detail",
                    "Luas Lingkaran" +
                    "\ndengan jari - jari= "+jariJari);
            intent.putExtra("hasil",String.valueOf(hasil));
            startActivity(intent);
        }
    }

    private void luasSegitiga(){
        if (etAlasSegitiga.getText().toString().trim().equals("")){
            etAlasSegitiga.setError("Masukkan Nilai ALas");
        }else if (etTinggiSegitiga.getText().toString().trim().equals("")){
            etTinggiSegitiga.setError("Masukkan Nilai Tinggi");
        }else {
            float alas = Float.valueOf(etAlasSegitiga.getText().toString());
            float tinggi = Float.valueOf(etTinggiSegitiga.getText().toString());
            float hasil = (float) 1/2*alas*tinggi;
            Intent intent = new Intent(HitungActivity.this, HasilActivity.class);
            intent.putExtra("bantarName",bantarName);
            intent.putExtra("Detail",
                    "Luas Segitiga" +
                    "\ndengan alas = "+alas+
                    "\ndan tinggi = "+tinggi);
            intent.putExtra("hasil",String.valueOf(hasil));
            startActivity(intent);
        }
    }

    private void luasTrapesium(){
        if (etAlasTrap.getText().toString().trim().equals("")){
            etAlasTrap.setError("Masukkan Nilai Alas");
        }else if (etAtasTrap.getText().toString().trim().equals("")){
            etAtasTrap.setError("Masukkan Nilai Atas");
        }else if (etTinggiTrap.getText().toString().trim().equals("")){
            etTinggiTrap.setError("Masukkan Nilai Tinggi");
        }else {
            float alas = Float.valueOf(etAlasTrap.getText().toString());
            float atas = Float.valueOf(etAtasTrap.getText().toString());
            float tinggi = Float.valueOf(etTinggiTrap.getText().toString());
            float hasil = (float)1/2*(alas+atas)*tinggi;
            Intent intent = new Intent(HitungActivity.this, HasilActivity.class);
            intent.putExtra("bantarName",bantarName);
            intent.putExtra("Detail",
                    "Luas Trapesium" +
                    "\ndengan alas = "+alas+"" +
                    "\ndan sisi atas = "+atas+"" +
                    "\ndan tinggi = "+tinggi);
            intent.putExtra("hasil",String.valueOf(hasil));
            startActivity(intent);
        }
    }

}
