package com.gohool.firstlook.cameraposeapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.RED;
import static com.gohool.firstlook.cameraposeapp.CameraPosesAdapter.flagSelected;
import static com.gohool.firstlook.cameraposeapp.CameraPosesAdapter.imageUrls;
import static com.gohool.firstlook.cameraposeapp.CameraPosesAdapter.img_fav;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.FavViewHolder>
{
    public ArrayList<String> imageViews;
    public Context mContext;
    public int index;


    public FavouriteAdapter(Context c,ArrayList<String> ar){
        mContext=c;
        imageViews=ar;
     /*   if(flag==1){
            imageViews.remove(position);
            notifyItemChanged(position);
        }*/
    }

    @NonNull
    @Override
    public FavViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_favourite_gridlayout,viewGroup,false);

        return new FavViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FavViewHolder favViewHolder, final int position) { //i is position

        Glide.with(mContext).asBitmap().load(imageViews.get(position)).into(favViewHolder.imageView);
        favViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"An image is clicked",Toast.LENGTH_LONG).show();
                Intent intent;
                intent = new Intent(v.getContext(),SecondActivity.class);
                intent.putExtra("ImageUrl",imageViews.get(position));
                mContext.startActivity(intent);

            }
        });


        favViewHolder.fav.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                    favViewHolder.fav.setColorFilter(BLACK);
                    imageViews.remove(img_fav.get(position));
                    favViewHolder.c.setVisibility(View.INVISIBLE);
                 //  notifyItemChanged(position);

                    }
        });
    }

    @Override
    public int getItemCount() {
        //  return imageViews.size();
        return imageViews.size();
    }

    public class FavViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imageView;
        ImageView fav;
        CardView c;

        public FavViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView= (CircleImageView) itemView.findViewById(R.id.image_of_fav);
            fav=(ImageView)itemView.findViewById(R.id.fav_of_list);
            c=(CardView)itemView.findViewById(R.id.card1);
            fav.setColorFilter(RED);

        }
    }

    }



