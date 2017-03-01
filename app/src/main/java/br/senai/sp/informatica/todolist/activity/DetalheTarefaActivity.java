package br.senai.sp.informatica.todolist.activity;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.senai.sp.informatica.todolist.R;

/**
 * Created by sn1022208 on 26/01/2017.
 */

public class DetalheTarefaActivity extends AppCompatActivity implements DialogInterface.OnClickListener {
    TextView textTitulo;
    RecyclerView recyclerView;
    View promptView;
    AlertDialog dialogSubtarefa;
    EditText editInput;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_lista);

        textTitulo = (TextView) findViewById(R.id.textTitulo);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

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
                dialogSubtarefa.show();
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
}
