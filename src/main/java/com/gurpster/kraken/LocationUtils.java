package com.gurpster.kraken;

import android.content.Context;
import android.content.pm.PackageManager;

import java.text.DecimalFormat;

public class LocationUtils {

    public static double CalculationByLocation(double lat1, double lon1, double lat2, double lon2, String returnType) {
        int Radius = 6371;// radius of earth in Km

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult = Radius * c;
        double km = valueResult / 1;

        DecimalFormat newFormat = new DecimalFormat("####");
        int kmInDec = Integer.parseInt(newFormat.format(km));
        double meter = valueResult % 1000;
        int meterInDec = Integer.parseInt(newFormat.format(meter));

        if (returnType.equals("METER")) {
            return meterInDec;
        } else {
            return Radius * c;
        }
    }
}
