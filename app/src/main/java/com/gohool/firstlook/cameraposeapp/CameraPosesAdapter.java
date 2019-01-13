package com.gohool.firstlook.cameraposeapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.graphics.Color.*;


public class CameraPosesAdapter extends RecyclerView.Adapter<CameraPosesAdapter.ViewHolder> {
    private static final String Tag ="RecyclerViewAdapter";
    public static ArrayList<String> imageUrls;
    private Context mContext;
    public static ArrayList<String> img_fav;
    public  static int index;// image which will be stored in favourite list
    public static int flagSelected=0;
    private ImageView fav_back_to_layout;


    public  CameraPosesAdapter (Context mContext, ArrayList<String> imageUrls) {
        this.imageUrls = imageUrls;
        this.mContext = mContext;
    }



    @NonNull
    @Override
    public  CameraPosesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(Tag,"OnCreateMethod is called");
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_back_camera_layout,viewGroup,false);
       img_fav=new ArrayList<>();

      return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CameraPosesAdapter.ViewHolder viewHolder, final int position) {
        Glide.with(mContext).asBitmap().load(imageUrls.get(position)).into(viewHolder.image);


        viewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"An image is clicked",Toast.LENGTH_LONG).show();
                 Intent intent;
                 intent = new Intent(v.getContext(),SecondActivity.class);
                 intent.putExtra("ImageUrl",imageUrls.get(position));
                 intent.putExtra("flag",flagSelected);
                 mContext.startActivity(intent);

            }
        });

        viewHolder.favorite.setOnClickListener(new View.OnClickListener() {
            int flag=0;
            @Override
            public void onClick(View v) {
                if(flag==0 ){
                    viewHolder.favorite.setColorFilter(RED);
                    img_fav.add(imageUrls.get(position));
                    index=position;
                    flagSelected=flag;
                    flag=1;

                }
                else{
                    viewHolder.favorite.setColorFilter(BLACK);
                    img_fav.remove(imageUrls.get(position));
                    index=position;
                    flagSelected=flag;
                    flag=0;

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }

    /*  @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_backcamera,container,false);
        }*/
    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        CircleImageView image;
        ImageView camera;

        ImageView favorite;
        ImageView freq;
        TextView freqCount;
        ArrayList<String> urls;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image= itemView.findViewById(R.id.image);
            favorite=itemView.findViewById(R.id.fav);





        }
    }

}

