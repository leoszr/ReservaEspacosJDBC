package bd1.dao;

import bd1.model.Solicitacao;
import bd1.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

public class SolicitacaoDAO {

    public void inserirSolicitacao(Solicitacao s) {
        String sql = "INSERT INTO solicitacao (id_usuario, id_espaco, data_reserva, hora_reserva, status, justificativa) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, s.getIdUsuario());
            stmt.setLong(2, s.getIdEspaco());
            stmt.setDate(3, Date.valueOf(s.getDataReserva()));
            stmt.setTime(4, Time.valueOf(s.getHoraReserva()));
            stmt.setString(5, s.getStatus());
            stmt.setString(6, s.getJustificativa());

            stmt.executeUpdate();
            System.out.println("Solicitação inserida com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir solicitação: " + e.getMessage());
        }
    }


    public void criarSolicitacao(long idUsuario, long idEspaco, String data, String hora) {
        Solicitacao s = new Solicitacao();
        s.setIdUsuario(idUsuario);
        s.setIdEspaco(idEspaco);
        s.setDataReserva(LocalDate.parse(data));
        s.setHoraReserva(LocalTime.parse(hora));
        s.setStatus("PENDENTE"); // ESSA LINHA É FUNDAMENTAL
        inserirSolicitacao(s);
    }


    public List<Solicitacao> listarSolicitacoes() {
        List<Solicitacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM solicitacao";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Solicitacao s = new Solicitacao();
                s.setId(rs.getLong("id"));
                s.setIdUsuario(rs.getLong("id_usuario"));
                s.setIdEspaco(rs.getLong("id_espaco"));
                s.setDataReserva(rs.getDate("data_reserva").toLocalDate());
                s.setHoraReserva(rs.getTime("hora_reserva").toLocalTime());
                s.setStatus(rs.getString("status"));
                s.setJustificativa(rs.getString("justificativa"));
                lista.add(s);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar solicitações: " + e.getMessage());
        }

        return lista;
    }

    public List<Solicitacao> listarPendentes() {
        List<Solicitacao> pendentes = new ArrayList<>();
        String sql = "SELECT * FROM solicitacao WHERE status = 'PENDENTE'";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Solicitacao s = new Solicitacao();
                s.setId(rs.getLong("id"));
                s.setIdUsuario(rs.getLong("id_usuario"));
                s.setIdEspaco(rs.getLong("id_espaco"));
                s.setDataReserva(rs.getDate("data_reserva").toLocalDate());
                s.setHoraReserva(rs.getTime("hora_reserva").toLocalTime());
                s.setStatus(rs.getString("status"));
                s.setJustificativa(rs.getString("justificativa"));
                pendentes.add(s);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar solicitações pendentes: " + e.getMessage());
        }

        return pendentes;
    }

    public List<Solicitacao> listarAprovadas() {
        List<Solicitacao> aprovadas = new ArrayList<>();
        String sql = "SELECT * FROM solicitacao WHERE status = 'APROVADA'";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Solicitacao s = new Solicitacao();
                s.setId(rs.getLong("id"));
                s.setIdUsuario(rs.getLong("id_usuario"));
                s.setIdEspaco(rs.getLong("id_espaco"));
                s.setDataReserva(rs.getDate("data_reserva").toLocalDate());
                s.setHoraReserva(rs.getTime("hora_reserva").toLocalTime());
                s.setStatus(rs.getString("status"));
                s.setJustificativa(rs.getString("justificativa"));
                aprovadas.add(s);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar solicitações aprovadas: " + e.getMessage());
        }

        return aprovadas;
    }

    public List<Solicitacao> listarPorUsuario(long idUsuario) {
        List<Solicitacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM solicitacao WHERE id_usuario = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, idUsuario);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Solicitacao s = new Solicitacao();
                    s.setId(rs.getLong("id"));
                    s.setIdUsuario(rs.getLong("id_usuario"));
                    s.setIdEspaco(rs.getLong("id_espaco"));
                    s.setDataReserva(rs.getDate("data_reserva").toLocalDate());
                    s.setHoraReserva(rs.getTime("hora_reserva").toLocalTime());
                    s.setStatus(rs.getString("status"));
                    s.setJustificativa(rs.getString("justificativa"));
                    lista.add(s);
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar solicitações do usuário: " + e.getMessage());
        }

        return lista;
    }
}
