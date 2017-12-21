package com.swarawan.kalkulator;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button tombolMasuk;
    Button tombolDaftar;
    EditText inputNamaPengguna;
    EditText inputKataSandi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instansiasi Object View
        tombolMasuk = findViewById(R.id.button_login);
        tombolDaftar = findViewById(R.id.button_register);
        inputNamaPengguna = findViewById(R.id.input_username);
        inputKataSandi = findViewById(R.id.input_password);

        tombolMasuk.setOnClickListener(onLoginClicked);
        tombolDaftar.setOnClickListener(onRegisterClicked);
    }

    View.OnClickListener onLoginClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String username = inputNamaPengguna.getText().toString();
            String password = inputKataSandi.getText().toString();

            String message = "";
            if (username.equals("michael") && password.equals("beton123")) {
                message = "Login berhasil";

                Intent intentToListKaryawan = new Intent(MainActivity.this, KaryawanActivity.class);
                startActivity(intentToListKaryawan);
            } else {
                message = "Username / password salah. Silakan coba lagi";
            }
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener onRegisterClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intentToRegister = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intentToRegister);
        }
    };
}
