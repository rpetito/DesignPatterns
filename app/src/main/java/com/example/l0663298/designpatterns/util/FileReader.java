package com.example.l0663298.designpatterns.util;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by l0663298 on 19/02/2018.
 */

public class FileReader {



    public static Object readRawFile(Context context, Integer rawFileResource, Class classType) {
        InputStream iStream = context.getResources().openRawResource(rawFileResource);
        ByteArrayOutputStream byteStream = null;
        try {
            byte[] buffer = new byte[iStream.available()];
            iStream.read(buffer);
            byteStream = new ByteArrayOutputStream();
            byteStream.write(buffer);
            byteStream.close();
            iStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return new Gson().fromJson(byteStream.toString(), classType);
    }




}
