package com.gusman_iakbali.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListBantarHitungActivity extends AppCompatActivity {
    ListView list;
    ArrayList<Model> arrayList = new ArrayList<>();
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bantar_hitung);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        list = (ListView)findViewById(R.id.listBangunDatar);

        arrayList.add(new Model(
                R.drawable.ic_jajar,
                "Jajar Genjang")
        );
        arrayList.add(new Model(
                R.drawable.ic_layangan,
                "Layang - Layang")
        );
        arrayList.add(new Model(
                R.drawable.ic_lingkaran,
                "Lingkaran")
        );
        arrayList.add(new Model(
                R.drawable.ic_persegi,
                "Persegi")
        );
        arrayList.add(new Model(
                R.drawable.ic_persegipanjang,
                "Persegi Panjang")
        );
        arrayList.add(new Model(
                R.drawable.ic_segitiga,
                "Segitiga")
        );
        arrayList.add(new Model(
                R.drawable.ic_trap,
                "Trapesium")
        );

        adapter = new CustomAdapter(this,R.layout.list_item,arrayList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Model model = arrayList.get(i);
                String bantarName = model.title;
                Intent intent = new Intent(ListBantarHitungActivity.this,HitungActivity.class);
                intent.putExtra("bantar",bantarName);
                startActivity(intent);
            }
        });

    }
}
