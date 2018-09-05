package com.example.ps08392.lab2bai3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TinhActivity extends AppCompatActivity {

    double number1, number2, ketqua;
    Button btnTong, btnHieu, btnTich, btnThuong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinh);
        btnTong = findViewById(R.id.buttonTong);
        btnHieu = findViewById(R.id.buttonHieu);
        btnTich = findViewById(R.id.buttonTich);
        btnThuong = findViewById(R.id.buttonThuong);
        //Lấy dữ liệu bên Main truyền qua
        number1 = getIntent().getExtras().getDouble("so1");
        number2 = getIntent().getExtras().getDouble("so2");

        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketqua = number1 + number2;
                traVe();
            }
        });
        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketqua = number1 - number2;
                traVe();
            }
        });
        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketqua = number1 * number2;
                traVe();
            }
        });
        btnThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketqua = number1 / number2;
                traVe();
            }
        });
    }

    protected void traVe() {
        //Intent không đối số dùng để trả về cho thằng nào gọi nó.
        Intent tinh = new Intent();
        tinh.putExtra("ketqua", ketqua);
        setResult(RESULT_OK, tinh);
        //Kill activity hiện tại khi hàm này chạy xong
        finish();
    }
}
