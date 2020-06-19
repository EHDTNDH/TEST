package com.example.myapplication.data;

public class TestWeatherContract {
}
    public static Uri buildWeatherLocation(String locationSetting) {
        return CONTENT_URI.buildUpon().appendPath(locationSetting).build();
    }
