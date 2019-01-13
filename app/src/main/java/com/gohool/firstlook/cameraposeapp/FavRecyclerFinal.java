package com.gohool.firstlook.cameraposeapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static com.gohool.firstlook.cameraposeapp.CameraPosesAdapter.img_fav;

public class FavRecyclerFinal extends AppCompatActivity {

    private ArrayList<String> imageUrls;


    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourite_list_recyclerview);
        recyclerView = (RecyclerView) findViewById(R.id.fav_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        FavouriteAdapter adapter = new FavouriteAdapter(this, img_fav);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.favourites) {

        }
        return false;
    }
}