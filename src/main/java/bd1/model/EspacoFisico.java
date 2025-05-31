package bd1.model;

public class EspacoFisico {
    private int id;
    private String nome;
    private String tipo;
    private double metragem;

    public EspacoFisico() {}

    public EspacoFisico(int id, String nome, String tipo, double metragem) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.metragem = metragem;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getMetragem() { return metragem; }
    public void setMetragem(double metragem) { this.metragem = metragem; }
}
