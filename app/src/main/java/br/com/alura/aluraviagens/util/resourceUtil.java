package br.com.alura.aluraviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class resourceUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable devolveDrawable(Context context, String drawableTexto) {
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(drawableTexto, DRAWABLE, context.getPackageName());
        return resources.getDrawable(idDrawable);
    }

}
