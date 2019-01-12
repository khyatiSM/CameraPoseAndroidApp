package com.gohool.firstlook.cameraposeapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FavRecyclerFinal extends AppCompatActivity {

    public ArrayList<String> imageUrls;

    public int flag;
    public RecyclerView recyclerView;
    public int position;

  /*  FavRecyclerFinal(ArrayList<String> images, int flag, int index) {
        imageUrls = images;
        this.flag = flag;
        this.position=index;
    }
    FavRecyclerFinal(){

    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourite_list_recyclerview);
        recyclerView=(RecyclerView)findViewById(R.id.fav_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        Bundle bundle = getIntent().getExtras();

        ArrayList<String> array = (ArrayList<String>) bundle.getStringArrayList("array_list");
        position=bundle.getInt("position");
        flag=bundle.getInt("flag");

        FavouriteAdapter adapter=new FavouriteAdapter(this,array,position,flag);
        recyclerView.setAdapter(adapter);

    }



}