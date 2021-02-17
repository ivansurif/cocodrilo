package com.example.cocodrilov20210216;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NewPurchase extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_purchase);
        Spinner spinner = (Spinner) findViewById(R.id.supermarket_spinner);

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.supermarket_brands, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        Log.d("SELECTION","Usuario hizo selección: "+pos);
        String selection = parent.getSelectedItem().toString();
        Log.d("SELECTION","selección: "+selection);
        Spinner brandsLocationsSpinner = (Spinner) findViewById(R.id.brands_locations);


        //if McDonalds, populates plate spinner with respective
        if(pos == 0){
            ArrayAdapter<String> adapter= new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.supermarket_brands_0_locations));
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            brandsLocationsSpinner.setAdapter(adapter);
        }
        //if kfc, populates plate spinner  with respective
        if(pos == 1){
            ArrayAdapter<String> adapter= new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.supermarket_brands_1_locations));
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            brandsLocationsSpinner.setAdapter(adapter);
        }

        if(pos == 2){
            ArrayAdapter<String> adapter= new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.supermarket_brands_2_locations));
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            brandsLocationsSpinner.setAdapter(adapter);
        }


    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
        Log.d("SELECTION","Ningún elemento seleccionado");

    }

    
}






