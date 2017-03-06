package br.senai.sp.informatica.todolist.adapter;


import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import br.senai.sp.informatica.todolist.R;
import br.senai.sp.informatica.todolist.modelo.Tarefa;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder> {

    private final List<Tarefa> tarefas;
    private final Context context;
    private OnTarefaClickListener listenerExluir;
    private OnTarefaClickListener listenerTarefa;


    public TarefaAdapter(OnTarefaClickListener listenerTarefa, OnTarefaClickListener listenerExluir, Context context, List<Tarefa> tarefas) {
        this.listenerTarefa = listenerTarefa;
        this.listenerExluir = listenerExluir;
        this.context = context;
        this.tarefas = tarefas;
    }

    @Override
    public TarefaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_lista, parent, false);
        return new TarefaViewHolder(view);
    }

    public interface OnTarefaClickListener {
        public void OnClick(View view, Tarefa tarefa);
    }

    @Override
    public void onBindViewHolder(TarefaViewHolder holder, int position) {
        final Tarefa tarefa = tarefas.get(position);
        holder.tvTitulo.setText(tarefa.getTitulo());

        if (tarefa.isFeita()) {
            holder.linearLayout.setBackgroundColor(Color.GREEN);
        } else {
            holder.linearLayout.setBackgroundColor(Color.WHITE);
        }

        holder.botaoExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerExluir.OnClick(v, tarefa);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerTarefa.OnClick(v, tarefa);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tarefas != null ? tarefas.size() : 0;
    }

    public class TarefaViewHolder extends RecyclerView.ViewHolder {
        public Button botaoExcluir;
        public TextView tvTitulo;
        public LinearLayout linearLayout;

        public TarefaViewHolder(View itemView) {
            super(itemView);
            botaoExcluir = (Button) itemView.findViewById(R.id.btExcluir);
            tvTitulo = (TextView) itemView.findViewById(R.id.textTitulo);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.layoutLista);
        }
    }
}
