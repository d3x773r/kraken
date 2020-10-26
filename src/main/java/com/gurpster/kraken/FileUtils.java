package com.gurpster.kraken;

import android.content.Context;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import okio.BufferedSource;
import okio.Okio;

/**
 * Created by Williaan Souza (dextter) on 25/10/2020
 * Contact williaanlopes@gmail.com
 */
public class FileUtils {

    /**
     * Read file from String path and return the content file as String
     * @param context
     * @param filePath
     * @return rt file as String
     */
    public static String readFrom(@NotNull Context context, String filePath) {
        String rt = "";

        try {
            InputStream input = context.getAssets().open(filePath);
            BufferedSource source = Okio.buffer(Okio.source(input));
            rt = source.readByteString().string(StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rt;
    }

    public static String getFileExt(@NotNull String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
