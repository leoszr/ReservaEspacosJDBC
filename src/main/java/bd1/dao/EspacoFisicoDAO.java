package bd1.dao;

import bd1.model.EspacoFisico;
import bd1.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspacoFisicoDAO {

    public void inserirEspaco(EspacoFisico espaco) {
        String sql = "INSERT INTO espaco_fisico (nome, metragem, equipamentos) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, espaco.getNome());
            stmt.setDouble(2, espaco.getMetragem());
            stmt.setString(3, espaco.getEquipamentos());

            stmt.executeUpdate();
            System.out.println("Espaço cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar espaço: " + e.getMessage());
        }
    }

    public List<EspacoFisico> listarEspacos() {
        List<EspacoFisico> espacos = new ArrayList<>();
        String sql = "SELECT * FROM espaco_fisico";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                EspacoFisico esp = new EspacoFisico();
                esp.setId(rs.getLong("id"));
                esp.setNome(rs.getString("nome"));
                esp.setMetragem(rs.getDouble("metragem"));
                esp.setEquipamentos(rs.getString("equipamentos"));
                espacos.add(esp);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar espaços: " + e.getMessage());
        }

        return espacos;
    }
}
