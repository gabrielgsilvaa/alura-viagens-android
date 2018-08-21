package br.com.alura.aluraviagens.util;

import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class dataUtil {

    public static final String PADRAO_DIA_MES = "dd/MM";

    @NonNull
    public static String periodoEmTexto(Integer dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();

        dataVolta.add(Calendar.DATE, dias);

        SimpleDateFormat formataData = new SimpleDateFormat(PADRAO_DIA_MES);
        String dataIdaFormatada = formataData.format(dataIda.getTime());
        String dataVoltaFormatada = formataData.format(dataVolta.getTime());

        return dataIdaFormatada + " - " + dataVoltaFormatada + " de " + dataVolta.get(Calendar.YEAR);
    }

}
