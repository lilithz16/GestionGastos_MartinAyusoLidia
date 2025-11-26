package es.ies.claudiomoyano.dam2.pmdm.gestiongastos_martinayusolidia;

import android.app.DatePickerDialog;
import android.content.Context;

import java.util.Calendar;

public class DialogoFecha {
    public static void mostrar(Context ctx, DatePickerDialog.OnDateSetListener listener){
        Calendar c = Calendar.getInstance();
        new DatePickerDialog(ctx, listener,
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)).show();
    }
}
