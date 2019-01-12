package com.gohool.firstlook.cameraposeapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class ViewProfile extends AppCompatActivity  implements View.OnClickListener,GoogleApiClient.OnConnectionFailedListener  {

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


    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
