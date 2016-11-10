package com.example.mapdemo;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParsePush;
import com.parse.interceptors.ParseLogInterceptor;

/**
 * Created by aditi on 11/9/2016.
 */

public class MapDemoApplication extends Application {
    final String CHANNEL_NAME = "android-2016";

    @Override
    public void onCreate() {
        super.onCreate();
        // set applicationId and server based on the values in the Heroku settings.
        // any network interceptors must be added with the Configuration Builder given this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("codepath-android") // should correspond to APP_ID env variable
                .addNetworkInterceptor(new ParseLogInterceptor())
                .server("https://codepath-maps-push-lab.herokuapp.com/parse/").build());

        ParsePush.subscribeInBackground(CHANNEL_NAME);
    }
}
