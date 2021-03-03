package com.example.cocodrilov20210216;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ScanTicket extends AppCompatActivity {

    static Uri photoURI = null;



    // Defining method to take open camera and take a picture
    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();

            } catch (IOException ex) {
                // Error occurred while creating the File

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                photoURI = FileProvider.getUriForFile(this,
                        "com.example.cocodrilov20210216.ScanTicket",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
            else {
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK && data != null) {
            //Bitmap imageBitmap = (Bitmap) extras.get("data");
            Bitmap imageBitmap = null;
            try {
                imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photoURI);


            } catch (IOException e) {
                e.printStackTrace();
            }
            setContentView(R.layout.activity_scan_ticket2);
            ImageView imageView = (ImageView)findViewById(R.id.imageView);
            imageView.setImageBitmap(imageBitmap);
            Button okButton = findViewById(R.id.button3);
            Button retakeButton = findViewById(R.id.button4);
            okButton.setVisibility(View.VISIBLE);
            retakeButton.setVisibility(View.VISIBLE);
            retakeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("BUTTONS","pressed noOK Button");
                    dispatchTakePictureIntent();
                }
            });
            okButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Code here executes on main thread after user presses button
                }
            });


        } else {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_scan_ticket2);
        Button okButton = findViewById(R.id.button3);
        Button retakeButton = findViewById(R.id.button4);
        okButton.setVisibility(View.GONE);
        retakeButton.setVisibility(View.GONE);





        String storeBrand = getIntent().getStringExtra("EXTRA_STORE_BRAND");
        String storeLocation = getIntent().getStringExtra("EXTRA_STORE_LOCATION");
        super.onCreate(savedInstanceState);
        dispatchTakePictureIntent();
    }

    String currentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }
}