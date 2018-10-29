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

public class BalanceActivity extends AppCompatActivity {

    private Button mBlaLogoutBt,mBackWalletHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);

        initView();

        initData();


    }

    private void initView() {
        mBlaLogoutBt=findViewById(R.id.balanceLogout);

        mBackWalletHome=findViewById(R.id.back_wallet_home);
    }

    private void initData() {
        mBlaLogoutBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                SharedPreferencesHelper.getInstance(BalanceActivity.this).putBoolean("isLogin",false);
                Log.i("FacebookLoginDemo","logOut");
                startActivity(new Intent(BalanceActivity.this,LoginActivity.class));
            }
        });
        mBackWalletHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
