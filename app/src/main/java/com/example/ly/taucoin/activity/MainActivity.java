package com.example.ly.taucoin.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ly.taucoin.R;
import com.example.ly.taucoin.info.SharedPreferencesHelper;
import com.facebook.login.LoginManager;

public class MainActivity extends BaseActivity {

    private Button balanceButton,harvestClubButton,keyAddressesButton,bountyButton,sendReceiveButton,logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();
    }

    private void initView() {
        balanceButton=findViewById(R.id.balance);
        harvestClubButton=findViewById(R.id.harvest_club);
        keyAddressesButton=findViewById(R.id.key_addresses);
        bountyButton=findViewById(R.id.bounty);
        sendReceiveButton=findViewById(R.id.send_and_receive);
        logoutButton=findViewById(R.id.logout);
    }

    private void initData() {

        balanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BalanceActivity.class));
            }
        });

        harvestClubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,HarvestClubActivity.class));
            }
        });
        keyAddressesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,KeysAddressesActivity.class));
            }
        });
        bountyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BountyActivity.class));
            }
        });
        sendReceiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SendAndReceiveActivity.class));
            }
        });
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                LoginManager.getInstance().logOut();
                SharedPreferencesHelper.getInstance(MainActivity.this).putBoolean("isLogin",false);
                Log.i("FacebookLoginDemo","logOut");
                startActivity(new Intent(MainActivity.this,LoginActivity.class));

            }
        });


    }


}
