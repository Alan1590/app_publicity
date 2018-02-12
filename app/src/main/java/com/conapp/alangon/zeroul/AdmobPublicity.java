package com.conapp.alangon.zeroul;

import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by Alan Gon on 11/02/2018.
 */

public class AdmobPublicity {
    AdView adView;
    private InterstitialAd mInterstitialAd;
    public AdmobPublicity(Context ctx) {

        MobileAds.initialize(ctx,"ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd = new InterstitialAd(ctx);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                mInterstitialAd.show();
            }
        });

    }
}
