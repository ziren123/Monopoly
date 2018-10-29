package com.example.ly.taucoin.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ly.taucoin.R;
import com.example.ly.taucoin.constant.key_address.io.taucoin.KeyGenerator;
import com.example.ly.taucoin.util.ZXingUtils;

public class DetailsActivity extends AppCompatActivity {

    private static String TAG = "FacebookLoginDemo";
    private TextView mPubkeyTV,mPrivkeyTV,mAddressTV;
    private Button mWalletBt;
    private ImageView mWalletAddressIv;

    private static KeyGenerator instance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        initView();

        initData();


    }



    private void initView() {
        mPubkeyTV=findViewById(R.id.public_key);
        mPrivkeyTV=findViewById(R.id.private_key);
        mAddressTV=findViewById(R.id.address);
        mWalletBt=findViewById(R.id.back_wallet);
        mWalletAddressIv=findViewById(R.id.wallet_address_iv);
    }


    private void initData() {


        Intent detailsIntent=getIntent();

        String pubkey=detailsIntent.getStringExtra("Pubkey");
        mPubkeyTV.setText(pubkey);
        String privkey=detailsIntent.getStringExtra("Privkey");
        mPrivkeyTV.setText(privkey);
        String address=detailsIntent.getStringExtra("Address");
        mAddressTV.setText(address);

        mWalletBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //二维码
        Bitmap addressIV=ZXingUtils.createQRImage(address,300,300);
        mWalletAddressIv.setImageBitmap(addressIV);
    }
    public static KeyGenerator getInstance(){
        if (instance == null) {
            instance = new KeyGenerator();
        }
        return instance;
    }
}
