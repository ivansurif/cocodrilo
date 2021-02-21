package com.example.cocodrilov20210216;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NewPurchase extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    static  String EXTRA_STOREBRAND = "com.example.cocodrilov20210216.STOREBRAND";
    static  String EXTRA_STORELOCATION = "com.example.cocodrilov20210216.STORELOCATION";



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
        int spinnerId = parent.getId();
        Log.d("SELECTION","Spinner ID: "+spinnerId);
        Spinner brandsLocationsSpinner = (Spinner) findViewById(R.id.brands_locations);



        if(spinnerId == R.id.supermarket_spinner){
            Log.d("SELECTION","Spinner ID: "+spinnerId);
            Log.d("SELECTION","Usuario hizo selección: "+pos);
            String selection = parent.getSelectedItem().toString();
            EXTRA_STOREBRAND = selection;
            Log.d("SELECTION","selección: "+selection);
        if(pos == 0){
            populateLocationsSpinner(brandsLocationsSpinner,view, String.valueOf(R.array.supermarket_brands_0_locations));
        }
        if(pos == 1){
            populateLocationsSpinner(brandsLocationsSpinner,view,String.valueOf(R.array.supermarket_brands_1_locations));
        }
        if(pos == 2){
            populateLocationsSpinner(brandsLocationsSpinner,view,String.valueOf(R.array.supermarket_brands_2_locations));
        }
        };
        if(spinnerId == R.id.brands_locations){
            String brandsLocationsSpinnerSelection = brandsLocationsSpinner.getSelectedItem().toString();
            Log.d("SELECTION","selección spinner: "+brandsLocationsSpinnerSelection);
            EXTRA_STORELOCATION = brandsLocationsSpinnerSelection;
        }


    }

    void populateLocationsSpinner (Spinner spinnerName, View view, String index) {
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item,getResources().getStringArray(Integer.parseInt(index)));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerName.setAdapter(adapter);
        spinnerName.setOnItemSelectedListener(this);
        String brandsLocationsSpinnerSelection = spinnerName.getSelectedItem().toString();
        Log.d("SELECTION","selección spinner: "+brandsLocationsSpinnerSelection);
    }


    public void onLocationSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        Log.d("SELECTION","Usuario hizo selección: "+pos);
        String selection = parent.getSelectedItem().toString();
        Log.d("SELECTION","selección: "+selection);

    }
        //
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
        Log.d("SELECTION","Ningún elemento seleccionado");

    }


    public void photo(View view) {
        //button.setVisibility(View.VISIBLE);

    }

    public void enterProductData(View view) {
        Intent intent = new Intent(this, ScanTicket.class);
        intent.putExtra("EXTRA_STORE_BRAND", EXTRA_STOREBRAND);
        intent.putExtra("EXTRA_STORE_LOCATION", EXTRA_STORELOCATION);
        startActivity(intent);

    }



}






