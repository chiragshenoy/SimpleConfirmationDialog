package com.chiragshenoy.simpleconifrmationdialog.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.util.SimpleArrayMap;


/**
 * Created by Kai on 07/01/17.
 */

public class TypeFaceHelper {

    private static final SimpleArrayMap<String, Typeface> cache = new SimpleArrayMap<>();


    public static Typeface get(Context c, String name) {
        synchronized (cache) {
            if (!cache.containsKey(name)) {
                try {
                    Typeface t = Typeface.createFromAsset(
                            c.getAssets(), String.format("fonts/%s", name));
                    cache.put(name, t);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return cache.get(name);
        }
    }
}
