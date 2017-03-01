package br.senai.sp.informatica.todolist.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import br.senai.sp.informatica.todolist.fragment.PrefFragment;

/**
 * Created by sn1022208 on 23/01/2017.
 */

public class PreferenceActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new PrefFragment()).commit();
    }
}
