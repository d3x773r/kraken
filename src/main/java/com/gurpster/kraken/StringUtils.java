package com.gurpster.kraken;

import android.content.Intent;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Williaan Souza (dextter) on 25/10/2020
 * Contact williaanlopes@gmail.com
 */
public class StringUtils {

    /**
     * Remove all non numbers from String
     * @param value
     * @return
     */
    public static String onlyNumbers(@NotNull String value) {
        return value.replaceAll("[^\\d]", "");
    }

//    public static int onlyNumbers(@NotNull String value) {
//        return Integer.parseInt(onlyNumbers(value));
//    }

    /**
     * Capilazie only first word from String
     * @param text non capitalized text
     * @return capitalized String
     */
    @NotNull
    public static String capitalize(@NotNull String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    /**
     * @param text non capitalized text
     * @param recursive if true, capitalize all first letter from String
     * @return capitalized String
     */
    @NotNull
    public static String capitalize(@NotNull String text, boolean recursive) {
        if (recursive) {
            return capitalizeAllFirst(text);
        } else {
            return capitalize(text);
        }
    }

    /**
     * Capitalize all first letter from String
     * @param text non capitalized text
     * @return capitalized String
     */
    public static String capitalizeAllFirst(@NotNull String text) {
        String rt = "";
        String[] textArray = text.split(" ");
        for (String s : textArray) {
            rt = rt + " " + capitalize(s);
        }
        return rt;
    }

    public static String convertDateToFormat(String format, Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.US);
        return dateFormat.format(date);
    }

    public static Date convertStringToDate(String format, String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
        try {
            return simpleDateFormat.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
