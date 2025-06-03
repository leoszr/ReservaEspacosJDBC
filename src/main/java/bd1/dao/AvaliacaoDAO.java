package bd1.dao;

import bd1.model.Avaliacao;
import bd1.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoDAO {

    public void inserirAvaliacao(Avaliacao a) {
        String sql = "INSERT INTO avaliacao (id_solicitacao, id_gestor, status_aprovacao, justificativa) VALUES (?, ?, ?, ?)";


        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, a.getIdSolicitacao());
            stmt.setLong(2, a.getIdGestor());
            stmt.setString(3, a.getStatusAprovacao());
            stmt.setString(4, a.getJustificativa());

            stmt.executeUpdate();
            System.out.println("Avaliação registrada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao registrar avaliação: " + e.getMessage());
        }
    }

    public List<Avaliacao> listarAvaliacoes() {
        List<Avaliacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM avaliacao";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Avaliacao a = new Avaliacao();
                a.setId(rs.getInt("id"));
                a.setIdSolicitacao(rs.getInt("id_solicitacao"));
                a.setIdGestor(rs.getInt("id_gestor"));
                a.setDataAvaliacao(rs.getTimestamp("data_avaliacao").toLocalDateTime());
                a.setStatusAprovacao(rs.getString("status_aprovacao"));
                a.setJustificativa(rs.getString("justificativa"));
                lista.add(a);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar avaliações: " + e.getMessage());
        }

        return lista;
    }

    public void avaliarSolicitacao(long idSolicitacao, long idGestor, String status, String justificativa) {
        String sqlAvaliacao = "INSERT INTO avaliacao (id_solicitacao, id_gestor, status_aprovacao, justificativa) VALUES (?, ?, ?, ?)";
        String sqlSolicitacao = "UPDATE solicitacao SET status = ?, justificativa = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar()) {
            conn.setAutoCommit(false);

            try (
                    PreparedStatement stmtAvaliacao = conn.prepareStatement(sqlAvaliacao);
                    PreparedStatement stmtSolicitacao = conn.prepareStatement(sqlSolicitacao)
            ) {
                stmtAvaliacao.setLong(1, idSolicitacao);
                stmtAvaliacao.setLong(2, idGestor);
                stmtAvaliacao.setString(3, status);
                stmtAvaliacao.setString(4, justificativa);
                stmtAvaliacao.executeUpdate();

                stmtSolicitacao.setString(1, status);
                stmtSolicitacao.setString(2, justificativa);
                stmtSolicitacao.setLong(3, idSolicitacao);
                stmtSolicitacao.executeUpdate();

                conn.commit();
                System.out.println("Solicitação avaliada com sucesso!");
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Erro ao avaliar solicitação: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }
}
