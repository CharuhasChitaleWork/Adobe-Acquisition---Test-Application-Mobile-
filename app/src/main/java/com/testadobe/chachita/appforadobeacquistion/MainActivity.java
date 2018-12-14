package com.testadobe.chachita.appforadobeacquistion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.adobe.mobile.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Config.setContext(this.getApplicationContext());
        Config.setDebugLogging(true);
        Config.collectLifecycleData(this);
        Analytics.trackState("Home Screen", null);
        Toast.makeText(getApplicationContext(),"control here",Toast.LENGTH_SHORT).show();
        Config.registerAdobeDataCallback(new Config.AdobeDataCallback() {
            @Override
            public void call(Config.MobileDataEvent event, Map<String, Object> contextData) {
                // handle each event type accordingly
                if (event == Config.MobileDataEvent.MOBILE_EVENT_ACQUISITION_INSTALL) {
                    // do something with acquisition data found in contextData parameter
                    HashMap<String, Object> acquisitionData = new HashMap<String, Object>(contextData);
                    Collection kv1 = acquisitionData.values();
                    Log.d("analytics",kv1.toString());
                   // Toast.makeText(getApplicationContext(),acquisitionData.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



    @Override
    public void onResume() {
        super.onResume();
        Config.collectLifecycleData(this);
        // -or- Config.collectLifecycleData(this, contextData);
    }

    @Override
    public void onPause() {
        super.onPause();
        Config.pauseCollectingLifecycleData();
    }
}

