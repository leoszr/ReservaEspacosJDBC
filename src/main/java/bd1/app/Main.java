package bd1.app;

import bd1.dao.*;
import bd1.model.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private static final EspacoFisicoDAO espacoDAO = new EspacoFisicoDAO();
    private static final SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
    private static final AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
    private static final AuditoriaDAO auditoriaDAO = new AuditoriaDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Cadastrar espaço físico");
            System.out.println("3. Fazer solicitação de reserva");
            System.out.println("4. Avaliar solicitações pendentes");
            System.out.println("5. Ver histórico de solicitações por usuário");
            System.out.println("6. Mostrar solicitações aprovadas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> cadastrarUsuario();
                case 2 -> cadastrarEspaco();
                case 3 -> fazerSolicitacao();
                case 4 -> avaliarSolicitacoes();
                case 5 -> verHistorico();
                case 6 -> mostrarAprovadas();
                case 0 -> {
                    System.out.println("Encerrando...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarUsuario() {
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Tipo (SOLICITANTE ou GESTOR): ");
        String tipo = scanner.nextLine().toUpperCase();

        Usuario u = new Usuario();
        u.setNome(nome);
        u.setEmail(email);
        u.setTipo(tipo);
        usuarioDAO.inserirUsuario(u);
    }

    private static void cadastrarEspaco() {
        System.out.println("Nome do espaço: ");
        String nome = scanner.nextLine();
        System.out.println("Metragem: ");
        double metragem = scanner.nextDouble();
        scanner.nextLine(); // limpar
        System.out.println("Equipamentos: ");
        String equipamentos = scanner.nextLine();

        EspacoFisico e = new EspacoFisico();
        e.setNome(nome);
        e.setMetragem(metragem);
        e.setEquipamentos(equipamentos);
        espacoDAO.inserirEspaco(e);
    }

    private static void fazerSolicitacao() {
        System.out.println("ID do solicitante: ");
        long idUsuario = scanner.nextLong();
        System.out.println("ID do espaço: ");
        long idEspaco = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Data da reserva (AAAA-MM-DD): ");
        String data = scanner.nextLine();
        System.out.println("Hora da reserva (HH:MM): ");
        String hora = scanner.nextLine();

        solicitacaoDAO.criarSolicitacao(idUsuario, idEspaco, data, hora);
    }

    private static void avaliarSolicitacoes() {
        System.out.println("ID do gestor: ");
        long idGestor = scanner.nextLong();
        scanner.nextLine();

        List<Solicitacao> pendentes = solicitacaoDAO.listarPendentes();
        if (pendentes.isEmpty()) {
            System.out.println("Nenhuma solicitação pendente.");
            return;
        }

        for (Solicitacao s : pendentes) {
            System.out.println("ID: " + s.getId() + ", Espaço: " + s.getIdEspaco() +
                    ", Data: " + s.getDataReserva() + " " + s.getHoraReserva());
        }

        System.out.println("Digite o ID da solicitação que deseja avaliar:");
        long idSolicitacao = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Aprovar ou Rejeitar? (APROVADA / REJEITADA): ");
        String status = scanner.nextLine().toUpperCase();

        String justificativa = "";
        if (status.equals("REJEITADA")) {
            System.out.println("Justificativa: ");
            justificativa = scanner.nextLine();
        }

        avaliacaoDAO.avaliarSolicitacao(idSolicitacao, idGestor, status, justificativa);
    }

    private static void verHistorico() {
        System.out.println("ID do usuário: ");
        long idUsuario = scanner.nextLong();
        scanner.nextLine();

        List<Solicitacao> historico = solicitacaoDAO.listarPorUsuario(idUsuario);
        for (Solicitacao s : historico) {
            System.out.println("ID: " + s.getId() +
                    ", Espaço: " + s.getIdEspaco() +
                    ", Data: " + s.getDataReserva() +
                    ", Hora: " + s.getHoraReserva() +
                    ", Status: " + s.getStatus());
        }
    }

    private static void mostrarAprovadas() {
        List<Solicitacao> aprovadas = solicitacaoDAO.listarAprovadas();
        for (Solicitacao s : aprovadas) {
            System.out.println("Espaço ID: " + s.getIdEspaco() +
                    " - Data: " + s.getDataReserva() +
                    " - Hora: " + s.getHoraReserva());
        }
    }
}
