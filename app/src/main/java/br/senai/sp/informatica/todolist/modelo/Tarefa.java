package br.senai.sp.informatica.todolist.modelo;


import java.util.List;

public class Tarefa {

    private Long id;
    private String titulo;
    private List<SubTarefa> subtarefas;
    private boolean feita;

    public boolean isFeita() {
        return feita;
    }

    public void setFeita(boolean feita) {
        this.feita = feita;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<SubTarefa> getSubtarefas() {
        return subtarefas;
    }

    public void setSubtarefas(List<SubTarefa> subtarefas) {
        this.subtarefas = subtarefas;
    }

    public Tarefa(List<SubTarefa> subtarefas, String titulo) {
        this.subtarefas = subtarefas;
        this.titulo = titulo;
    }

    public Tarefa() {

    }
}
