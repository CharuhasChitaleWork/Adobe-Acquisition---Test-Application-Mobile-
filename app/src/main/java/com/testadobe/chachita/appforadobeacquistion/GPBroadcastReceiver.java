package com.testadobe.chachita.appforadobeacquistion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;



public class GPBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context c, Intent i) {
        com.adobe.mobile.Analytics.processReferrer(c, i);
        String intentdata = i.getDataString();
        Log.d("analytics",intentdata);

    }
}
