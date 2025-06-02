package bd1.dao;

import bd1.model.Solicitacao;
import bd1.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
}
