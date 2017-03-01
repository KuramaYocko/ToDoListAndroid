package br.senai.sp.informatica.todolist.fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import br.senai.sp.informatica.todolist.R;

/**
 * Created by sn1022208 on 23/01/2017.
 */

public class PrefFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
