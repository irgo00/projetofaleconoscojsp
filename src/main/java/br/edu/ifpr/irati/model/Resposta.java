package br.edu.ifpr.irati.model;

public class Resposta {
    private int id;
    private String texto;
    private int fkIdContato;

    public Resposta() {
    }

    public Resposta(int id, String texto, int fkIdContato) {
        this.id = id;
        this.texto = texto;
        this.fkIdContato = fkIdContato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getFkIdContato() {
        return fkIdContato;
    }

    public void setFkIdContato(int fkIdContato) {
        this.fkIdContato = fkIdContato;
    }

    @Override
    public String toString() {
        return "Resposta{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", fkIdContato=" + fkIdContato +
                '}';
    }
}
