package com.example.dell.adem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String PREF ="state";
    String TEST="aa";
    SharedPreferences mSharedPrefer;
    SharedPreferences.Editor editor;
    private CallbackManager mcallbackManager;
    private TextView mTextDetail;
    private LoginManager manager;
    private FacebookCallback<LoginResult> mCallback=new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            AccessToken accessToken=loginResult.getAccessToken();
            Profile profile= Profile.getCurrentProfile();
            Intent intent=new Intent(MainActivity.this,post_facebook.class);
            intent.putExtra("user_ID", toString().valueOf(accessToken.getUserId()));
            startActivity(intent);
            editor.putBoolean(PREF, true);
            String userID= accessToken.getUserId();
            editor.putString(TEST, userID);
            editor.commit();

            if(profile!=null){
                mTextDetail.setText("Wellcome " + profile.getName()+ " UserID "+userID);
            }

        }

        @Override
        public void onCancel() {


        }

        @Override
        public void onError(FacebookException error) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        /*try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.example.dell.adem",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
        */

        AppEventsLogger.activateApp(getApplicationContext());
        mcallbackManager=CallbackManager.Factory.create();
        LoginButton loginButton=(LoginButton)findViewById(R.id.login_button);
        mTextDetail=(TextView)findViewById(R.id.profile_name);
        loginButton.setReadPermissions("user_friends","email");
        loginButton.setReadPermissions("quot","email","publish_actions");
        List<String> permission= Arrays.asList("publish_actions");
        manager= LoginManager.getInstance();
        manager.logInWithPublishPermissions(this,permission);
        loginButton.registerCallback(mcallbackManager, mCallback);

        AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(
                    AccessToken oldAccessToken,
                    AccessToken currentAccessToken) {

                if (currentAccessToken == null){
                    editor.putBoolean(PREF,false);
                    editor.commit();
                }
            }
        };
        accessTokenTracker.startTracking();
        mSharedPrefer =getSharedPreferences(PREF, 0);
        editor=mSharedPrefer.edit();
        String test=mSharedPrefer.getString(TEST,"");
        boolean flag=mSharedPrefer.getBoolean(PREF,false);
        if(flag){
            Intent intent=new Intent(this,post_facebook.class);
            intent.putExtra("user_ID",test);
            startActivity(intent);

        }

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mcallbackManager.onActivityResult(requestCode,resultCode,data);
    }
    }

