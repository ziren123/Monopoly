package com.example.ly.taucoin.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ly.taucoin.R;
import com.example.ly.taucoin.constant.key_address.io.taucoin.Key;
import com.example.ly.taucoin.constant.key_address.io.taucoin.KeyGenerator;
import com.example.ly.taucoin.info.SharedPreferencesHelper;
import com.example.ly.taucoin.util.ZXingUtils;
import com.facebook.login.LoginManager;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.ByteArrayOutputStream;

public class KeysAddressesActivity extends AppCompatActivity {

    private TextView mWalletAddressTV;
    private static String TAG = "FacebookLoginDemo";
    private static KeyGenerator instance;
    private Button mWalletHomeBt,mWalletLogoutBt;
    private TextView mDetailsTV;
    private ImageView mAddressIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keys_addresses);

        initView();

        initData();

    }

    private void initView() {

        mWalletHomeBt=findViewById(R.id.address_back_wallet_home);
        mDetailsTV=findViewById(R.id.to_details);
        mWalletAddressTV= findViewById(R.id.wallet_address);
        mWalletLogoutBt=findViewById(R.id.walletLogout);
        mAddressIV=findViewById(R.id.address_img);
    }

    private void initData() {

        //生成公私钥及地址
        final Key key = new Key();
        key.Reset();
        if (getInstance().GenerateKey(key)) {

            mWalletAddressTV.setText(key.getAddress());

            Log.i(TAG,"Privkey :"+key.getPrivkey()+"   Pubkey:"+key.getPubkey()+"    Address :"+key.getAddress());
        } else {
            Log.i(TAG,"Generate key error...");

        }


        //保存公私钥及地址
        SharedPreferencesHelper.getInstance(KeysAddressesActivity.this).putString("Pubkey",key.getPubkey());
        SharedPreferencesHelper.getInstance(KeysAddressesActivity.this).putString("Privkey",key.getPrivkey());
        SharedPreferencesHelper.getInstance(KeysAddressesActivity.this).putString("Address",key.getAddress());

        mWalletHomeBt. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mDetailsTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( KeysAddressesActivity.this,DetailsActivity.class);
                intent.putExtra("Pubkey",key.getPubkey());
                intent.putExtra("Privkey",key.getPrivkey());
                intent.putExtra("Address",key.getAddress());
                startActivity(intent);
            }
        });

        mWalletLogoutBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                SharedPreferencesHelper.getInstance(KeysAddressesActivity.this).putBoolean("isLogin",false);
                Log.i("FacebookLoginDemo","logOut");
                startActivity(new Intent(KeysAddressesActivity.this,LoginActivity.class));
            }
        });



        //生成二维码
        Bitmap qrImage=ZXingUtils.createQRImage(key.getAddress(),400,400);
        mAddressIV.setImageBitmap(qrImage);
    }


    public static KeyGenerator getInstance(){
        if (instance == null) {
            instance = new KeyGenerator();
        }
        return instance;
    }


}
