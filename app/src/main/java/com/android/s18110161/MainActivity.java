package com.android.s18110161;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextSoTienGui, editTextLaiSuatGui, editTextKyHanGui;
    Button buttonKetQua;

    void AnhXa() {
        editTextSoTienGui = (EditText) findViewById(R.id.edtSoTienGui);
        editTextLaiSuatGui = (EditText) findViewById(R.id.edtLaiXuatGui);
        editTextKyHanGui = (EditText) findViewById(R.id.edtKyHanGui);
        buttonKetQua = (Button) findViewById(R.id.btnXemKetQua);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        buttonKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Result_Activity.class);
                if (editTextSoTienGui
                        .getText()
                        .toString()
                        .isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số tiền gửi!",
                            Toast.LENGTH_SHORT).show();
                } else if (editTextLaiSuatGui.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập lãi suất gửi!",
                            Toast.LENGTH_SHORT).show();
                } else if (editTextKyHanGui.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập kỳ hạn gửi!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    double value_soTienGui = Double.parseDouble(editTextSoTienGui.getText().toString());
                    double value_laiXuatGui = Double.parseDouble(editTextLaiSuatGui.getText().toString());
                    double value_kyHanGui = Double.parseDouble(editTextKyHanGui.getText().toString());

                    if (value_soTienGui == 0 || value_laiXuatGui == 0 || value_kyHanGui == 0) {
                        Toast.makeText(MainActivity.this, "Thông tin không hợp lệ. Vui lòng kiểm tra lại!",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        double value_soTienLai = value_soTienGui * (value_laiXuatGui / 100) * (value_kyHanGui / 12);
                        double value_tongSoTienNhan = value_soTienLai + value_soTienGui;
                        Bundle bundle = new Bundle();
                        bundle.putDouble("soTienLai", value_soTienLai);
                        bundle.putDouble("tongSoTienNhan", value_tongSoTienNhan);
                        intent.putExtra("data", bundle);
                        startActivity(intent);
                    }
                }
            }
        });


    }
}