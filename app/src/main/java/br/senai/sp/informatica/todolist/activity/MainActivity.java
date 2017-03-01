package br.senai.sp.informatica.todolist.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.senai.sp.informatica.todolist.R;
import br.senai.sp.informatica.todolist.util.PrefsUtil;

/**
 * Created by sn1022208 on 09/02/2017.
 */

public class MainActivity extends AppCompatActivity {
    EditText editEmail, editSenha;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // editEmail
        editEmail = (EditText) findViewById(R.id.edit_email);

        // editSenha
        editSenha = (EditText) findViewById(R.id.edit_password);
    }

    public void btLogarClick(View view) {
        if (editEmail.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, R.string.informe_email, Toast.LENGTH_SHORT).show();
        } else if (editSenha.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, R.string.informe_senha, Toast.LENGTH_SHORT).show();
        } else {

        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.item_prefs) {
            startActivity(new Intent(this, PreferenceActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void btCriarContaClick(View view) {

    }
}
