package com.gohool.firstlook.cameraposeapp;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.GoogleApiClient;

public class Login extends AppCompatActivity implements View.OnClickListener,GoogleApiClient.OnConnectionFailedListener  {


    private SignInButton signInButton;
    private GoogleApiClient googleApiClient;
    public static String Name;
    public static String Email;
    public static String  profile_url;
    private TextView error_msg,skip;

    private static final int REQUEST_CODE=9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        error_msg=(TextView)findViewById(R.id.errorID);
        signInButton=(SignInButton)findViewById(R.id.signinID);
        skip=(TextView)findViewById(R.id.skipID);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent1);
            }
        });
        signInButton.setOnClickListener(this);

        GoogleSignInOptions googleSignInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
         googleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this, (GoogleApiClient.OnConnectionFailedListener) this).addApi(Auth.GOOGLE_SIGN_IN_API,googleSignInOptions).build();


    }
    @Override
    public void onClick(View v) {
        signIn();
    }
    private void signIn(){
        Intent intent=Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent,REQUEST_CODE);

        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==REQUEST_CODE){
            GoogleSignInResult results=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResults(results);
        }
    }

    private void handleResults(GoogleSignInResult results){
        if(results.isSuccess()){
            GoogleSignInAccount account=results.getSignInAccount();
            Name=account.getDisplayName();
            Email=account.getEmail();
            profile_url=account.getPhotoUrl().toString();
            error_msg.setVisibility(View.INVISIBLE);
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            }
            else{
                error_msg.setVisibility(View.VISIBLE);
              }

    }



    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

}
