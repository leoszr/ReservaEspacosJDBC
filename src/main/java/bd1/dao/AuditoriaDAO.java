package bd1.dao;

import bd1.model.Auditoria;
import bd1.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuditoriaDAO {

    public void registrarAcao(Auditoria a) {
        String sql = "INSERT INTO auditoria (id_usuario, acao) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, a.getIdUsuario());

            stmt.setString(2, a.getAcao());

            stmt.executeUpdate();
            System.out.println("Ação registrada na auditoria com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao registrar auditoria: " + e.getMessage());
        }
    }

    public List<Auditoria> listarAuditorias() {
        List<Auditoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM auditoria";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Auditoria a = new Auditoria();
                a.setId(rs.getInt("id"));
                a.setIdUsuario(rs.getInt("id_usuario"));
                a.setAcao(rs.getString("acao"));
                a.setDataAcao(rs.getTimestamp("data_acao").toLocalDateTime());
                lista.add(a);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar auditorias: " + e.getMessage());
        }

        return lista;
    }
}
