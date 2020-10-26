package com.gurpster.kraken

import android.content.res.Resources
import android.text.TextUtils
import java.util.*

/**
 * Created by Williaan Souza (dextter) on 14/09/2020
 * Contact williaanlopes@gmail.com
 */
object Salute {
    /**
     * @param username it will be concat with salute message
     * @return salutation message
     */
    fun friendlyMessage(username: String): String {

//        if (!TextUtils.isEmpty(username)) {
//            username = ", $username"
//        }

        var saluteText = Resources.getSystem().getString(R.string.salute) + username
        val c = Calendar.getInstance()
        when (c[Calendar.HOUR_OF_DAY]) {
            in 5..11 -> {
                saluteText = Resources.getSystem()
                    .getString(R.string.salute_morning) + username  //"Bom dia, " + username;
            }
            in 12..17 -> {
                saluteText = "Boa tarde, $username"
            }
            in 18..23 -> {
                saluteText = Resources.getSystem()
                    .getString(R.string.salute_night) + username //"Boa noite, " + username;
            }
            in 2..4 -> {
                saluteText = "$username ainda acordado,"
            }
        }
        //        else {
//            saluteText = "Olá, " + username;
//            saluteText = Resources.getSystem().getString(R.string.salute) + " " + username;
//        }
        return saluteText
    }

    /**
     * @return simple salutation message
     */
    fun message(): String {
        return friendlyMessage("")
    } //    public static String saluteMessage() {
    //
    //        String saluteText;
    //
    //        Calendar c = Calendar.getInstance();
    //        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
    //
    //        if (timeOfDay >= 0 && timeOfDay < 12) {
    //            saluteText = "Bom dia";
    //        } else if (timeOfDay >= 12 && timeOfDay < 16) {
    //            saluteText = "Boa tarde";
    //        } else if ((timeOfDay >= 16 && timeOfDay < 21) || (timeOfDay >= 21 && timeOfDay < 24)) {
    //            saluteText = "Boa noite";
    //        } else {
    //            saluteText = "Olá";
    //        }
    //
    //        return saluteText;
    //    }
}