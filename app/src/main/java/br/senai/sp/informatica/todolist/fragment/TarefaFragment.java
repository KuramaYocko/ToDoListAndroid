package br.senai.sp.informatica.todolist.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import br.senai.sp.informatica.todolist.R;
import br.senai.sp.informatica.todolist.adapter.TarefaAdapter;
import br.senai.sp.informatica.todolist.modelo.Tarefa;
import br.senai.sp.informatica.todolist.rest.TarefaRest;


public class TarefaFragment extends Fragment {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    int tipoLista;
    SwipeRefreshLayout swipeRefreshLayout;

    TarefaAdapter.OnTarefaClickListener listenerExluir = new TarefaAdapter.OnTarefaClickListener() {
        @Override
        public void OnClick(View view, Tarefa tarefa) {
            new ExcluirTarefaTask().execute(tarefa);
        }
    };

    TarefaAdapter.OnTarefaClickListener listenerTarefa = new TarefaAdapter.OnTarefaClickListener() {
        @Override
        public void OnClick(View view, Tarefa tarefa) {

        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tipoLista = getArguments().getInt("tipoLista", 1);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tarefas, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new ListarTarefaTask().execute(tipoLista);
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        new ListarTarefaTask().execute(tipoLista);
    }


    public class ExcluirTarefaTask extends AsyncTask<Tarefa, Void, Object> {
        @Override
        protected Object doInBackground(Tarefa... params) {
            try {
                TarefaRest.deletarTarefa(params[0], getContext());
                return null;
            } catch (Exception e) {
                return e;
            }
        }

        @Override
        protected void onPostExecute(Object o) {
            if (o != null) {
                Exception erro = (Exception) o;
                Toast.makeText(getContext(), erro.getMessage(), Toast.LENGTH_SHORT).show();
            } else {
                new ListarTarefaTask().execute(tipoLista);
            }
        }
    }

    public class ListarTarefaTask extends AsyncTask<Integer, Void, List<Tarefa>> {
        Exception exception = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected List<Tarefa> doInBackground(Integer... params) {
            try {
                switch (params[0]) {
                    case 0:
                        return TarefaRest.listarAbertas(getContext());

                    case 1:
                        return TarefaRest.listarTodas(getContext());
                }
            } catch (Exception e) {
                this.exception = e;
                return null;
            }
            return null;

        }

        @Override
        protected void onPostExecute(List<Tarefa> tarefas) {

            if (tarefas != null) {
                recyclerView.setAdapter(new TarefaAdapter(listenerTarefa, listenerExluir, getContext(), tarefas));
                progressBar.setVisibility(View.GONE);
                swipeRefreshLayout.setRefreshing(false);

            } else {
                Toast.makeText(getContext(), "Erro: " + exception.getMessage(), Toast.LENGTH_LONG).show();
            }

        }


    }
}
