package br.senai.sp.informatica.todolist.modelo;


public class SubTarefa {
    private Long id;
    private String descricao;
    private boolean feita;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isFeita() {
        return feita;
    }

    public void setFeita(boolean feita) {
        this.feita = feita;
    }

    public SubTarefa(String descricao) {
        this.descricao = descricao;
    }

    public SubTarefa() {
    }

    @Override
    public String toString() {
        return descricao;
    }
}
