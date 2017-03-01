package br.senai.sp.informatica.todolist.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.senai.sp.informatica.todolist.R;

/**
 * Created by sn1022208 on 09/02/2017.
 */

public class NovaContaActivity extends AppCompatActivity {
    EditText editNome, editEmail, editSenha;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nova_conta);

        // editNome
        editNome = (EditText) findViewById(R.id.edit_nome);

        // editEmail
        editEmail = (EditText) findViewById(R.id.edit_email);

        // editSenha
        editSenha = (EditText) findViewById(R.id.edit_password);
    }


    public void btSalvarClick(View view) {
        if (editNome.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, R.string.informe_nome, Toast.LENGTH_SHORT).show();
        } else if (editEmail.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, R.string.informe_email, Toast.LENGTH_SHORT).show();
        } else if (editSenha.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, R.string.informe_senha, Toast.LENGTH_SHORT).show();
        } else {

        }
    }

}
