package com.example.cocodrilov20210216;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ScanTicket extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String storeBrand = getIntent().getStringExtra("EXTRA_STORE_BRAND");
        String storeLocation = getIntent().getStringExtra("EXTRA_STORE_LOCATION");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_ticket2);
        Log.d("Store Brand recibida",storeBrand);
        Log.d("Store Location recibida",storeLocation);

    }
}