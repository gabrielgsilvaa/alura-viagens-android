package br.com.alura.aluraviagens.util;

import android.support.annotation.NonNull;

public class diasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    @NonNull
    public static String formataDiasEmTexto(int quantidadeDias) {

        if(quantidadeDias > 1) {
            return quantidadeDias + PLURAL;
        }

        return quantidadeDias + SINGULAR;
    }


}
