package com.ahwan0m.Instadownloader;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class Content extends AppCompatActivity {
    private AdView mAdView, mAdView1, mAdView2;
    private InterstitialAd mInterstitialAd;
    private AdRequest interAdRequest;
    public static int id =1;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
        MobileAds.initialize(this, getString(R.string.admob_app_id));
        loadAds();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("Main", "Permission is granted");
                //return true;
            } else {

                Log.v("Main", "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                //return false;
            }
        }
        else
        {
            int permission = PermissionChecker.checkSelfPermission(getApplicationContext(),Manifest.permission.WRITE_EXTERNAL_STORAGE );

            if (permission == PermissionChecker.PERMISSION_GRANTED) {
                // good to go
                Log.v("Main", "Permission is granted");
            } else {
                // permission not granted, you decide what to do
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("Main", "Permission is granted");
                //return true;
            } else {

                Log.v("Main", "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                //return false;
            }
        }
        else
        {
            int permission = PermissionChecker.checkSelfPermission(getApplicationContext(),Manifest.permission.READ_EXTERNAL_STORAGE );

            if (permission == PermissionChecker.PERMISSION_GRANTED) {
                // good to go
                Log.v("Main", "Permission is granted");
            } else {
                // permission not granted, you decide what to do
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            }
        }
    }

    private void loadAds() {
    mAdView = (AdView) findViewById(R.id.adView);
        mAdView = (AdView) findViewById(R.id.adsView1);
        mAdView = (AdView) findViewById(R.id.adsView2);


    AdRequest adRequest = new AdRequest.Builder()
            .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
            .build();

        mAdView.loadAd(adRequest);
}

    public void facebook(View view) {
        Intent i = new Intent(Content.this,DownloadActivity.class);
        startActivity(i);
        id =1;
    }

    public void insta(View view) {
        Intent i = new Intent(Content.this,DownloadActivity.class);
        startActivity(i);
        id=2;
    }

    public void instapic(View view) {
        Intent i = new Intent(Content.this,DownloadActivity.class);
        startActivity(i);
        id=3;
    }

    public void whatsapp(View view) {
        Intent i = new Intent(Content.this,WhatsApp.class);
        startActivity(i);
        id=4;
    }

}