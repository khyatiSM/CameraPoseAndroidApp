package com.gohool.firstlook.cameraposeapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.gohool.firstlook.cameraposeapp.Login.Email;
import static com.gohool.firstlook.cameraposeapp.Login.Name;
import static com.gohool.firstlook.cameraposeapp.Login.profile_url;

public class ViewProfile extends AppCompatActivity   {

    private TextView name,email;
    private SignInButton signInButton;
    private Button signout;
    private ImageView photo;

    private GoogleApiClient googleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        name=(TextView)findViewById(R.id.name);
        email=(TextView)findViewById(R.id.email);
        signout=(Button)findViewById(R.id.sign_out);
        photo=(ImageView)findViewById(R.id.profile_photo);

        name.setText(Name);
        email.setText(Email);
        Glide.with(this).load(profile_url).into(photo);


    }



}
