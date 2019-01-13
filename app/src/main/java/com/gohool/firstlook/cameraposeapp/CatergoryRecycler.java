package com.gohool.firstlook.cameraposeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import static com.gohool.firstlook.cameraposeapp.CameraPosesAdapter.imageUrls;
import static com.gohool.firstlook.cameraposeapp.CameraPosesAdapter.img_fav;
import static com.gohool.firstlook.cameraposeapp.MainActivity.categoryResults;

public class CatergoryRecycler extends AppCompatActivity {
    private RecyclerView category_recyclerView;
  //  private ArrayList<String> soloImages;
    private ArrayList<String> categoryImageUrls;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catergory_recycler);

        category_recyclerView = (RecyclerView) findViewById(R.id.category_recyclerID);
       category_recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        categoryImageUrls=new ArrayList<>();


       Intent intent=getIntent();
        categoryResults= intent.getStringExtra("category_selected");
       Log.d("Category to be sent",categoryResults);




       if(categoryResults.equals("Solo")){
           categoryImageUrls=imageUrls;
           FavouriteAdapter adapter = new FavouriteAdapter(this, imageUrls);
           category_recyclerView.setAdapter(adapter);//insert solo images

       }
       else if(categoryResults.equals("Couple")){
           categoryImageUrls=imageUrls;
           FavouriteAdapter adapter = new FavouriteAdapter(this, imageUrls);
           category_recyclerView.setAdapter(adapter);//insert couple pose images
       }
       else if(categoryResults.equals("Family")){

           categoryImageUrls=imageUrls;
           FavouriteAdapter adapter = new FavouriteAdapter(this, imageUrls);
           category_recyclerView.setAdapter(adapter);//insert family pose images
       }
       else if(categoryResults.equals("Friends")){
           categoryImageUrls=imageUrls;
           FavouriteAdapter adapter = new FavouriteAdapter(this, imageUrls);
           category_recyclerView.setAdapter(adapter);//inser friends pose images

       }
       else{
           BackCameraFragment backCameraFragment=new BackCameraFragment(); // insert all pose types images
       }




    }
}
