package com.gohool.firstlook.cameraposeapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import static com.gohool.firstlook.cameraposeapp.R.layout.activity_favourite_gridlayout;

public class MainActivity extends AppCompatActivity {

public static String image_url;
    private  ArrayList<String> imageUrls;
    private Toolbar toolbar;
    private Spinner mySpinner;

    public static int flg;
    public static int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mySpinner=(Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                R.layout.custom_spinner,
                getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);



        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        mySpinner.getSelectedItem().toString(),
                        Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FrontCameraFragment()).commit();
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        selectedFragment = new FrontCameraFragment();
                        break;
                    case R.id.android:
                        //  selectedFragment=new BackCameraFragment();
                        selectedFragment = new BackCameraFragment();

                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;


            }
        });

    }
    public void add(ArrayList<String> ar, int flg, int position){
        imageUrls=ar;
        this.flg=flg;
        this.position=position;


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.favourites){
          /*  Intent intent=new Intent(this,FavRecyclerFinal.class);
            startActivity(intent);*/
          //  setContentView(R.layout.activity_fav_recycler_final);
          //  FavRecyclerFinal fv=new FavRecyclerFinal(imageUrls,flg,position);

            Intent intent=new Intent(this,FavRecyclerFinal.class);

            intent.putExtra("array_list", imageUrls);
            intent.putExtra("position",position);
            intent.putExtra("flag",flg);
            startActivity(intent);


        }


       return false;
    }
}

