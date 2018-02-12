package com.conapp.alangon.zeroul;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Alan Gon on 11/02/2018.
 */

public class BackgroundServices extends IntentService {


    public BackgroundServices() {
        super("");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.e("Test","TESTEO");
    }
}
