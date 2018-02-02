// IWeather.aidl
package com.example.jinhui.androiddemo.day15.aidl;

// Declare any non-default types here with import statements

interface IWeather {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    String getWeatherInfo();
}
