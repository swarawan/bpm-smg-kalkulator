package com.swarawan.kalkulator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by rioswarawan on 12/20/17.
 */

public class RegisterActivity extends AppCompatActivity {

    String dataJenjang[] = {"Pilih Jenjang", "SD", "SMP", "SMA", "D3", "S1", "S2", "S3"};

    Button tombolDaftar;
    EditText inputNamaLengkap;
    EditText inputEmail;
    EditText inputUsername;
    EditText inputPassword;
    RadioGroup radioJenisKelamin;
    Spinner spinnerJenjang;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tombolDaftar = findViewById(R.id.button_register);
        inputNamaLengkap = findViewById(R.id.input_nama_lengkap);
        inputEmail = findViewById(R.id.input_email);
        inputUsername = findViewById(R.id.input_username);
        inputPassword = findViewById(R.id.input_password);
        radioJenisKelamin = findViewById(R.id.radio_jenis_kelamin);
        spinnerJenjang = findViewById(R.id.spinner_jenjang);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataJenjang);
        spinnerJenjang.setAdapter(adapter);

        tombolDaftar.setOnClickListener(onRegisterClicked);
    }

    View.OnClickListener onRegisterClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String nama = inputNamaLengkap.getText().toString();
            String email = inputEmail.getText().toString();
            String username = inputUsername.getText().toString();
            String password = inputPassword.getText().toString();

            // fungsi untuk mengambil data spinner terpilih
            int selectedJenjang = spinnerJenjang.getSelectedItemPosition();
            String jenjang = adapter.getItem(selectedJenjang);

            // fungsi untuk mengambil radio button terpilih
            int id = radioJenisKelamin.getCheckedRadioButtonId();
            RadioButton selectedJenisKelamin = findViewById(id);

            // validasi radio button jenis kelamin
            if (selectedJenisKelamin == null) {
                Toast.makeText(RegisterActivity.this, "Jenis kelamin tidak boleh kosong", Toast.LENGTH_SHORT).show();
                return;
            }
            String jenisKelamin = selectedJenisKelamin.getText().toString();

            // validasi form (edittext)
            if (nama.equals("") || email.equals("") || username.equals("") || password.equals("")) {
                Toast.makeText(RegisterActivity.this,
                        "Form tidak boleh ada yang kosong",
                        Toast.LENGTH_SHORT).show();
                return;
            } else if (selectedJenjang == 0) {
                Toast.makeText(RegisterActivity.this,
                        "Anda belum memilih jenjang pendidikan",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            Log.d("Nama Lengkap Anda", nama);
            Log.d("Email", email);
            Log.d("Jenjang Pendidikan", jenjang);
            Log.d("Jenis Kelamin", jenisKelamin);
            Log.d("Username", username);
            Log.d("Password", password);
        }
    };
}
