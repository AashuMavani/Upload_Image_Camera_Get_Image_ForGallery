package com.app.upload_image_camera_get_image_forgallery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img1;
    CircleImageView profile_image;
    FloatingActionButton Add,Add2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1=findViewById(R.id.img1);
        Add=findViewById(R.id.Add);
        profile_image=findViewById(R.id.profile_image);
        Add2=findViewById(R.id.Add2);


        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(MainActivity.this)
                        .galleryOnly()
                        .crop()		//Crop image(Optional), Check Customization for more option
                       .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	///Final image resolution will be less than 1080 x 1080(Optional)
                        .start(10);

            }
        });
        Add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(MainActivity.this)
             			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	///Final image resolution will be less than 1080 x 1080(Optional)
                        .start(20);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==10){
            Uri uri=data.getData();
            img1.setImageURI(uri);
        }else {
            Uri uri=data.getData();

            profile_image.setImageURI(uri);
        }

    }
}