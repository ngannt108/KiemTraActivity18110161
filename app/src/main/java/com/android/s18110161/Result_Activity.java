package com.android.s18110161;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class Result_Activity extends AppCompatActivity {

    int Request_Code_Camara = 1;
    TextView textViewSoTienLai;
    TextView textViewTongSoTien;
    Button buttonCamara;

    void AnhXa() {
        buttonCamara = (Button) findViewById(R.id.btnCamara);
        textViewSoTienLai = (TextView) findViewById(R.id.txtSoTienLai);
        textViewTongSoTien = (TextView) findViewById(R.id.txtTongSoTien);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        AnhXa();

        Bundle bundle = getIntent().getBundleExtra("data");
        double value_soTienLai = bundle.getDouble("soTienLai");
        double value_tongSoTien = bundle.getDouble("tongSoTienNhan");

        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        String firstResult = en.format(value_soTienLai) + " " + "VND";
        String secondResult = en.format(value_tongSoTien);

        textViewSoTienLai.setText(firstResult);
        textViewTongSoTien.setText(secondResult + " " + "VND");

        buttonCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, Request_Code_Camara);
                finish();
            }
        });
    }

}