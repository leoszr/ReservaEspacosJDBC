package bd1.model;

import java.time.LocalDateTime;

public class SolicitacaoReserva {
    private int id;
    private int idUsuario;
    private int idEspaco;
    private LocalDateTime dataHoraSolicitacao;
    private LocalDateTime dataHoraReserva;
    private String status;

    public SolicitacaoReserva() {}

    public SolicitacaoReserva(int id, int idUsuario, int idEspaco, LocalDateTime dataHoraSolicitacao,
                              LocalDateTime dataHoraReserva, String status) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idEspaco = idEspaco;
        this.dataHoraSolicitacao = dataHoraSolicitacao;
        this.dataHoraReserva = dataHoraReserva;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getIdEspaco() { return idEspaco; }
    public void setIdEspaco(int idEspaco) { this.idEspaco = idEspaco; }

    public LocalDateTime getDataHoraSolicitacao() { return dataHoraSolicitacao; }
    public void setDataHoraSolicitacao(LocalDateTime dataHoraSolicitacao) {
        this.dataHoraSolicitacao = dataHoraSolicitacao;
    }

    public LocalDateTime getDataHoraReserva() { return dataHoraReserva; }
    public void setDataHoraReserva(LocalDateTime dataHoraReserva) {
        this.dataHoraReserva = dataHoraReserva;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
