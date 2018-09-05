package com.example.ps08392.lab2bai3;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtSo1, edtSo2;
    Button btnTinh;
    TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ánh xạ
        edtSo1 = findViewById(R.id.editTextSo1);
        edtSo2 = findViewById(R.id.editTextSo2);
        btnTinh = findViewById(R.id.buttonTinhToan);
        tvKetQua = findViewById(R.id.textViewKetQua);

        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sữa lỗi khi để trống dữ liệu
                if (edtSo1.getText().toString().trim().length() == 0 || edtSo2.getText().toString().trim().length() == 0) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số vào!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent tinh = new Intent(MainActivity.this, TinhActivity.class);
                    //Ép kiểu dữ liệu về kiểu số thập phân
                    double so1 = Double.parseDouble(edtSo1.getText().toString());
                    double so2 = Double.parseDouble(edtSo2.getText().toString());
                    //Truyền dữ liệu qua activity Tính toán
                    tinh.putExtra("so1", so1);
                    tinh.putExtra("so2", so2);
                    startActivityForResult(tinh, 123);
                }
            }
        });
    }
    //Nhận dữ liệu trả về
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Nếu đúng requestCde và có kết quả trả về thì in kết quả ra
        if (requestCode == 123 && resultCode == RESULT_OK) {
            double ketqua = data.getExtras().getDouble("ketqua");
            tvKetQua.setText(String.valueOf(ketqua));
        }
    }
}