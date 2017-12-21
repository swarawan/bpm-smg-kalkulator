package com.swarawan.kalkulator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by rioswarawan on 12/21/17.
 */

public class KalkulatorActivity extends AppCompatActivity {

    Button buttonTambah, buttonKurang, buttonKali, buttonBagi;
    EditText inputNilai1, inputNilai2;
    TextView labelHasil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);

        buttonTambah = findViewById(R.id.button_tambah);
        buttonKurang = findViewById(R.id.button_kurang);
        buttonKali = findViewById(R.id.button_kali);
        buttonBagi = findViewById(R.id.button_bagi);
        labelHasil = findViewById(R.id.label_hasil);
        inputNilai1 = findViewById(R.id.input_nilai1);
        inputNilai2 = findViewById(R.id.input_nilai2);

        buttonTambah.setOnClickListener(onTambahClicked);
        buttonKurang.setOnClickListener(onKurangClicked);
        buttonKali.setOnClickListener(onKaliClicked);
        buttonBagi.setOnClickListener(onBagiClicked);
    }

    View.OnClickListener onTambahClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Double nilai1 = Double.valueOf(inputNilai1.getText().toString());
            Double nilai2 = Double.valueOf(inputNilai2.getText().toString());
            Double hasil = nilai1 + nilai2;
            labelHasil.setText(String.format("Hasil: %s", hasil));
        }
    };

    View.OnClickListener onKurangClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Double nilai1 = Double.valueOf(inputNilai1.getText().toString());
            Double nilai2 = Double.valueOf(inputNilai2.getText().toString());
            Double hasil = nilai1 - nilai2;
            labelHasil.setText(String.format("Hasil: %s", hasil));
        }
    };

    View.OnClickListener onKaliClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Double nilai1 = Double.valueOf(inputNilai1.getText().toString());
            Double nilai2 = Double.valueOf(inputNilai2.getText().toString());
            Double hasil = nilai1 * nilai2;
            labelHasil.setText(String.format("Hasil: %s", hasil));
        }
    };

    View.OnClickListener onBagiClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Double nilai1 = Double.valueOf(inputNilai1.getText().toString());
            Double nilai2 = Double.valueOf(inputNilai2.getText().toString());
            Double hasil = nilai1 / nilai2;
            labelHasil.setText(String.format("Hasil: %s", hasil));
        }
    };
}
