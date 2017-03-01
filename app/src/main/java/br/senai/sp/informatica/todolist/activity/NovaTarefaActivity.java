package br.senai.sp.informatica.todolist.activity;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import br.senai.sp.informatica.todolist.R;

/**
 * Created by sn1022208 on 23/01/2017.
 */

public class NovaTarefaActivity extends AppCompatActivity implements DialogInterface.OnClickListener {
    ListView listSubtarefas;
    EditText editTitulo;
    View promptView;
    AlertDialog dialogSubtarefa;
    EditText editInput;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_lista);

        listSubtarefas = (ListView) findViewById(R.id.listSubtarefas);

        editTitulo = (EditText) findViewById(R.id.editTitulo);

        promptView = getLayoutInflater().inflate(R.layout.prompts, null);

        editInput = (EditText) promptView.findViewById(R.id.editTextDialogUserInput);

        textView = (TextView) promptView.findViewById(R.id.textView1);
        textView.setText(R.string.informe_descricao);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(promptView);
        builder.setPositiveButton(R.string.ok, this);
        builder.setNegativeButton(R.string.cancel, this);

        dialogSubtarefa = builder.create();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case DialogInterface.BUTTON_POSITIVE:
                if (!editInput.getText().toString().trim().isEmpty()) {

                } else {
                    Toast.makeText(this, R.string.informe_descricao, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contexto_novatarefa, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_excluir:

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_novatarefa, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_salvar:
                if (!editTitulo.getText().toString().trim().isEmpty()) {

                } else {
                    Toast.makeText(this, R.string.informe_titulo, Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
