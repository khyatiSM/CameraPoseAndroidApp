package com.gohool.firstlook.cameraposeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.RED;

public class SecondActivity extends AppCompatActivity {
    ImageView enlargeImg;
    ImageView fav;
    ImageView cam;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        enlargeImg=(ImageView)findViewById(R.id.enlarge_image);
        fav=(ImageView)findViewById(R.id.favourite);
        cam=(ImageView)findViewById(R.id.camera);
        fav.setImageResource(R.drawable.ic_favorite_black_24dp);
        cam.setImageResource(R.drawable.ic_photo_camera_black_24dp);
        Intent intent=getIntent();
        url=intent.getExtras().getString("ImageUrl");
        Glide.with(this).asBitmap().load(url).into(enlargeImg);
        fav.setOnClickListener(new View.OnClickListener() {
            int flag=0;
            @Override
            public void onClick(View v) {
                if(flag==0){
                    fav.setColorFilter(RED);
                    flag=1;
                }
                else{
                    fav.setColorFilter(BLACK);
                    flag=0;
                }

            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return true;
    }
}
