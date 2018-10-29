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

public class HarvestClubActivity extends AppCompatActivity {


    private Button mClubLogoutBt,mBackHomeBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harvest_club);

        initView();

        initData();


    }



    private void initView() {

        mClubLogoutBt=findViewById(R.id.clubLogout);
        mBackHomeBt=findViewById(R.id.club_back_wallet_home);
    }

    private void initData() {

        mClubLogoutBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                SharedPreferencesHelper.getInstance(HarvestClubActivity.this).putBoolean("isLogin",false);
                Log.i("FacebookLoginDemo","logOut");
                startActivity(new Intent(HarvestClubActivity.this,LoginActivity.class));
            }
        });

        mBackHomeBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
