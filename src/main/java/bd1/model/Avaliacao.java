package bd1.model;

import java.time.LocalDateTime;

public class Avaliacao {
    private long id;
    private long idSolicitacao;
    private long idGestor;
    private LocalDateTime dataAvaliacao;
    private String statusAprovacao;
    private String justificativa;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public long getIdSolicitacao() { return idSolicitacao; }
    public void setIdSolicitacao(long idSolicitacao) { this.idSolicitacao = idSolicitacao; }

    public long getIdGestor() { return idGestor; }
    public void setIdGestor(long idGestor) { this.idGestor = idGestor; }

    public LocalDateTime getDataAvaliacao() { return dataAvaliacao; }
    public void setDataAvaliacao(LocalDateTime dataAvaliacao) { this.dataAvaliacao = dataAvaliacao; }

    public String getStatusAprovacao() { return statusAprovacao; }
    public void setStatusAprovacao(String statusAprovacao) { this.statusAprovacao = statusAprovacao; }

    public String getJustificativa() { return justificativa; }
    public void setJustificativa(String justificativa) { this.justificativa = justificativa; }
}
