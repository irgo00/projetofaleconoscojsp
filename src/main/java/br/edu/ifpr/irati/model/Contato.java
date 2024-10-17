package br.edu.ifpr.irati.model;

public class Contato {

    private int id;
    private String nome;
    private String email;
    private Categoria assunto;
    private String texto;

    public Contato() {
        id = 0;
        nome = "";
        email = "";
        assunto = new Categoria();
        texto = "";
    }

    public Contato(int id, String nome, String email, Categoria assunto, String texto) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.assunto = assunto;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria getAssunto() {
        return assunto;
    }

    public void setAssunto(Categoria assunto) {
        this.assunto = assunto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", assunto='" + assunto + '\'' +
                ", texto='" + texto + '\'' +
                '}';
    }
}
