package bd1.model;

import java.time.LocalDateTime;

public class Auditoria {
    private int id;
    private int idUsuario;
    private String acao;
    private LocalDateTime dataHora;

    public Auditoria() {}

    public Auditoria(int id, int idUsuario, String acao, LocalDateTime dataHora) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.acao = acao;
        this.dataHora = dataHora;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getAcao() { return acao; }
    public void setAcao(String acao) { this.acao = acao; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}
