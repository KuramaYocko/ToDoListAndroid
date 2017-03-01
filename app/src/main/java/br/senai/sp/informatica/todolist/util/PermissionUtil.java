package br.senai.sp.informatica.todolist.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sn1022208 on 26/01/2017.
 */

public class PermissionUtil {
    public static boolean checkPermission(Activity activity, int requestCode, String... permissions) {
        List<String> negadas = new ArrayList<>();
        for (String permissao : permissions) {
            if (ContextCompat.checkSelfPermission(activity, permissao) != PackageManager.PERMISSION_GRANTED) {
                negadas.add(permissao);
            }
        }
        if (negadas.isEmpty()) {
            return true;
        } else {
            String[] permissoesNegadas = new String[negadas.size()];
            negadas.toArray(permissoesNegadas);
            ActivityCompat.requestPermissions(activity, permissoesNegadas, requestCode);
            return false;
        }
    }
}
