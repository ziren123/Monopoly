package com.example.ly.taucoin.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ly.taucoin.R;
import com.example.ly.taucoin.info.SharedPreferencesHelper;
import com.facebook.login.LoginManager;

public class BountyActivity extends AppCompatActivity {

    private Button mVisitButton,mReferringButton,mTalkingButton,mBuildingButton,mWalletHomeButton,mBountyLogoutBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bounty);

        initView();

        initData();
    }



    private void initView() {
        mVisitButton=findViewById(R.id.visit);
        mReferringButton=findViewById(R.id.referring);
        mTalkingButton=findViewById(R.id.talking);
        mBuildingButton=findViewById(R.id.building);
        mWalletHomeButton=findViewById(R.id.bounty_back_wallet_home);
        mBountyLogoutBt=findViewById(R.id.bountyLogout);
    }

    private void initData() {

        mVisitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BountyActivity.this,VisitActivity.class));
            }
        });

        mReferringButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BountyActivity.this,ReferringActivity.class));
            }
        });

        mTalkingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BountyActivity.this,TalkingActivity.class));
            }
        });

        mBuildingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BountyActivity.this,BuildingActivity.class));
            }
        });

        mWalletHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
               // startActivity(new Intent(BountyActivity.this,MainActivity.class));
            }
        });

        mBountyLogoutBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                SharedPreferencesHelper.getInstance(BountyActivity.this).putBoolean("isLogin",false);
                Log.i("FacebookLoginDemo","logOut");
                startActivity(new Intent(BountyActivity.this,LoginActivity.class));
            }
        });

    }
}
