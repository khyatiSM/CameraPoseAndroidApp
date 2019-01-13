package com.gohool.firstlook.cameraposeapp;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import static com.gohool.firstlook.cameraposeapp.MainActivity.categoryResults;

public class FrontCameraFragment extends Fragment {
    private static final String TAG = "MainActivity";
    private ArrayList<String> imageUrls=new ArrayList<>();
    RecyclerView main_recycler_view;
    public boolean frontCamera=true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=null;

        if(categoryResults.equals("All")){
            view= inflater.inflate(R.layout.fragment_frontcamera,container,false);
            initImageBitmaps(view);
        }
        else{
            view= inflater.inflate(R.layout.activity_catergory_recycler,container,false);
            initImageBitmaps2(view);
        }

        return view;
    }
    private void initImageBitmaps(View view){

        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        imageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        //  mNames.add("Havasu Falls");

        imageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        //  mNames.add("Trondheim");

        imageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        //  mNames.add("Portugal");

        imageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        //  mNames.add("Rocky Mountain National Park");


        imageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        //   mNames.add("Mahahual");

        imageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        // mNames.add("Frozen Lake");


        imageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        //  mNames.add("White Sands Desert");

        imageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        // mNames.add("Austrailia");

        imageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        // mNames.add("Washington");

        initRecyclerView(view);
    }
    private void initRecyclerView(View view){




        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView1 = (RecyclerView)view.findViewById(R.id.Frontrecyclerview1ID);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false));
        CameraPosesAdapter adapter1 = new CameraPosesAdapter(getContext(), imageUrls,frontCamera);
        recyclerView1.setAdapter(adapter1);


        RecyclerView recyclerView2 = (RecyclerView)view.findViewById(R.id.Frontrecyclerview2ID);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false));
        CameraPosesAdapter adapter2 = new CameraPosesAdapter(getContext(), imageUrls,frontCamera);
        recyclerView2.setAdapter(adapter2);

        RecyclerView recyclerView3 = (RecyclerView)view.findViewById(R.id.Frontrecyclerview3ID);
        recyclerView3.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false));
        CameraPosesAdapter adapter3 = new CameraPosesAdapter(getContext(), imageUrls,frontCamera);
        recyclerView3.setAdapter(adapter3);

        RecyclerView recyclerView4 = (RecyclerView)view.findViewById(R.id.Frontrecyclerview4ID);
        recyclerView4.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false));
        CameraPosesAdapter adapter4 = new CameraPosesAdapter(getContext(), imageUrls,frontCamera);
        recyclerView4.setAdapter(adapter4);
    }

    private void initImageBitmaps2(View view){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        imageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        //  mNames.add("Havasu Falls");

        imageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        //  mNames.add("Trondheim");

        imageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        //  mNames.add("Portugal");

        imageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        //  mNames.add("Rocky Mountain National Park");


        imageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        //   mNames.add("Mahahual");

        imageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        // mNames.add("Frozen Lake");


        imageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        //  mNames.add("White Sands Desert");

        imageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        // mNames.add("Austrailia");

        imageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        // mNames.add("Washington");

        initRecyclerView2(view);
    }
    private void initRecyclerView2(View view) {


        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView1 = (RecyclerView) view.findViewById(R.id.category_recyclerID);
        recyclerView1.setLayoutManager(new GridLayoutManager(getContext(), 3));
        CameraPosesAdapter adapter1 = new CameraPosesAdapter(getContext(), imageUrls,frontCamera);
        recyclerView1.setAdapter(adapter1);


    }

}
