package br.edu.ifpr.irati.model;

public class Categoria {

    int id;
    String titulo;
    String descricao;
    String emails;
    int prazoMinimo;
    int prazoMaximo;
    String nomeResponsavel;

    public Categoria() {
        this.id = 0;
        this.titulo = "";
        this.descricao = "";
        this.emails = "";
        this.prazoMinimo = 24;
        this.prazoMaximo = 72;
        this.nomeResponsavel = "";
    }

    public Categoria(int id, String titulo, String descricao, String emails, int prazoMinimo, int prazoMaximo, String nomeResponsavel) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.emails = emails;
        this.prazoMinimo = prazoMinimo;
        this.prazoMaximo = prazoMaximo;
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public int getPrazoMinimo() {
        return prazoMinimo;
    }

    public void setPrazoMinimo(int prazoMinimo) {
        this.prazoMinimo = prazoMinimo;
    }

    public int getPrazoMaximo() {
        return prazoMaximo;
    }

    public void setPrazoMaximo(int prazoMaximo) {
        this.prazoMaximo = prazoMaximo;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
