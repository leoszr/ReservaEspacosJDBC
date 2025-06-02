package bd1.model;

public class EspacoFisico {
    private long id;
    private String nome;
    private double metragem;
    private String equipamentos;

    public EspacoFisico(long id, String nome, double metragem, String equipamentos) {
        this.id = id;
        this.nome = nome;
        this.metragem = metragem;
        this.equipamentos = equipamentos;
    }

    public EspacoFisico(String nome, double metragem, String equipamentos) {
        this(0L, nome, metragem, equipamentos);
    }

    public EspacoFisico() {}

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getMetragem() { return metragem; }
    public void setMetragem(double metragem) { this.metragem = metragem; }

    public String getEquipamentos() { return equipamentos; }
    public void setEquipamentos(String equipamentos) { this.equipamentos = equipamentos; }

    @Override
    public String toString() {
        return "EspacoFisico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", metragem=" + metragem +
                ", equipamentos='" + equipamentos + '\'' +
                '}';
    }
}
