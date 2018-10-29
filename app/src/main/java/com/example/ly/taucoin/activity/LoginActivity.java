package com.example.ly.taucoin.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ly.taucoin.R;
import com.example.ly.taucoin.info.SharedPreferencesHelper;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Arrays;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private static String TAG = "FacebookLoginDemo";


    private Button mFbLoginBtn;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {


                Toast.makeText(LoginActivity.this, "facebook_account_oauth_Success", Toast.LENGTH_SHORT);

                Log.e(TAG, "登陆成功 "+"token: "+ loginResult.getAccessToken().getToken()+"   ApplicationId:" +
                        ""+loginResult.getAccessToken().getApplicationId()
                +"   UserId:"+loginResult.getAccessToken().getUserId());

                finish();
                startActivity(new Intent( LoginActivity.this,MainActivity.class));

                SharedPreferencesHelper.getInstance(LoginActivity.this).putBoolean("isLogin",true);

            }

            @Override
            public void onCancel() {
                Log.e(TAG, "登录取消");
                Toast.makeText(LoginActivity.this, "facebook_account_oauth_Cancel", Toast.LENGTH_SHORT);
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(LoginActivity.this, "facebook_account_oauth_Error", Toast.LENGTH_SHORT);
                Log.e(TAG, "登录错误 e: " + error);
            }
        });
    }

    private void initViews() {
        mFbLoginBtn = (Button) findViewById(R.id.login);
        mFbLoginBtn.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);


    }

    @Override
    protected void onResume() {
        super.onResume();
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        AppEventsLogger.deactivateApp(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.login) {

            AccessToken accessToken = AccessToken.getCurrentAccessToken();

            Log.i("accessToken",""+accessToken);

            if (accessToken == null || accessToken.isExpired()) {

                LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "user_friends"));


            }
        }


    }
}




