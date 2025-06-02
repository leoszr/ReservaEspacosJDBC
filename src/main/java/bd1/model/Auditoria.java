package bd1.model;

import java.time.LocalDateTime;

public class Auditoria {
    private long id;
    private long idUsuario;
    private String acao;
    private LocalDateTime dataAcao;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(long idUsuario) { this.idUsuario = idUsuario; }

    public String getAcao() { return acao; }
    public void setAcao(String acao) { this.acao = acao; }

    public LocalDateTime getDataAcao() { return dataAcao; }
    public void setDataAcao(LocalDateTime dataAcao) { this.dataAcao = dataAcao; }
}
