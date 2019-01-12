package com.gohool.firstlook.cameraposeapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.FavViewHolder>
{
    public ArrayList<String> imageViews;
    public Context mContext;
    public int index;

    public FavouriteAdapter(Context c,ArrayList<String> ar,int flag,int position){
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
    public void onBindViewHolder(@NonNull FavViewHolder favViewHolder, int i) { //i is position

        Glide.with(mContext).asBitmap().load(imageViews.get(i)).into(favViewHolder.imageView);

    }

    @Override
    public int getItemCount() {
      //  return imageViews.size();
        return imageViews.size();
    }

    public class FavViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imageView;
        ImageView fav;

        public FavViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView= (CircleImageView) itemView.findViewById(R.id.image_of_fav);
            fav=(ImageView)itemView.findViewById(R.id.fav_of_list);
        }
    }
}
