package bd1.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Solicitacao {
    private long id;
    private long idUsuario;
    private long idEspaco;
    private LocalDate dataReserva;
    private LocalTime horaReserva;
    private String status;
    private String justificativa;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(long idUsuario) { this.idUsuario = idUsuario; }

    public long getIdEspaco() { return idEspaco; }
    public void setIdEspaco(long idEspaco) { this.idEspaco = idEspaco; }

    public LocalDate getDataReserva() { return dataReserva; }
    public void setDataReserva(LocalDate dataReserva) { this.dataReserva = dataReserva; }

    public LocalTime getHoraReserva() { return horaReserva; }
    public void setHoraReserva(LocalTime horaReserva) { this.horaReserva = horaReserva; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getJustificativa() { return justificativa; }
    public void setJustificativa(String justificativa) { this.justificativa = justificativa; }
}
