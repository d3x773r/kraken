package com.gurpster.kraken;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Williaan Souza (dextter) on 14/09/2020
 * Contact williaanlopes@gmail.com
 */
public class NetworkStates {

    public boolean hasInternetConnection() {
        try {
            URL url = new URL("https://www.google.com");
            HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
            urlc.setConnectTimeout(1000 * 30); // mTimeout is in seconds
            urlc.connect();
            return (urlc.getResponseCode() == 200);
        } catch (IOException e1) {
            return false;
        }
    }

}
