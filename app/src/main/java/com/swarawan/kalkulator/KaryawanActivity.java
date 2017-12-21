package com.swarawan.kalkulator;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rioswarawan on 12/20/17.
 */

public class KaryawanActivity extends AppCompatActivity {

    RecyclerView recyclerKaryawan;

    KaryawanAdapter adapter;
    List<KaryawanModel> dataKaryawan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karyawan);

        recyclerKaryawan = findViewById(R.id.recycler_karyawan);

        dataKaryawan = new ArrayList<>();
        adapter = new KaryawanAdapter(dataKaryawan);
        recyclerKaryawan.setAdapter(adapter);
        recyclerKaryawan.setLayoutManager(new LinearLayoutManager(this));

        tambahKaryawan();
        sampleAsync();
    }

    private void tambahKaryawan() {
        KaryawanModel yosi = new KaryawanModel();
        yosi.nama = "Yosi";
        yosi.email = "yosi@gmail.com";
        yosi.image = "https://static0.therichestimages.com/wp-content/uploads/2014/03/344225_jackie-chan_dzheki-chan_chyen_3500x2356_www.GdeFon.ru_.jpg";

        KaryawanModel jackie = new KaryawanModel();
        jackie.nama = "Jackie";
        jackie.email = "jackie@gmail.com";
        jackie.image = "https://www.famousbirthdays.com/headshots/jackie-chan-4.jpg";

        dataKaryawan.add(yosi);
        dataKaryawan.add(jackie);
        adapter.notifyDataSetChanged();
    }

    private void sampleAsync() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 200) {
                    Log.d("Thread-1", String.valueOf(i));
                    i++;
                }
            }
        }).start();

        int a = 0;
        while (a < 200) {
            Log.d("Thread-2", String.valueOf(a));
            a++;
        }
    }
}
