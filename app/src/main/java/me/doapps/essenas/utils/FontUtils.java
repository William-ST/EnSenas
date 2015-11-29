package me.doapps.essenas.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by William_ST on 29/11/15.
 */
public class FontUtils {

    public static Typeface getFiraSansMedium(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/FiraSansMedium.otf");
    }

}
