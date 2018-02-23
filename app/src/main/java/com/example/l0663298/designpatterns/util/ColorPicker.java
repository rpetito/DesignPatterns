package com.example.l0663298.designpatterns.util;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by l0663298 on 20/02/2018.
 */

public class ColorPicker {


    public static int random() {
        Random r = new Random();
        return Color.argb(255, r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }


}
