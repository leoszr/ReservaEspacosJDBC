package bd1.app;

import bd1.model.Usuario;
import bd1.dao.UsuarioDAO;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Listar Usuários");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    Usuario novoUsuario = new Usuario();

                    System.out.print("Nome: ");
                    novoUsuario.setNome(scanner.nextLine());

                    System.out.print("Email: ");
                    novoUsuario.setEmail(scanner.nextLine());

                    System.out.print("Tipo (SOLICITANTE ou GESTOR): ");
                    novoUsuario.setTipo(scanner.nextLine().toUpperCase());

                    usuarioDAO.inserirUsuario(novoUsuario);
                    break;

                case 2:
                    System.out.println("\n--- Lista de Usuários ---");
                    List<Usuario> usuarios = usuarioDAO.listarUsuarios(); // Pega a lista de usuários

                    if (usuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        for (Usuario u : usuarios) {
                            System.out.println(u); // Chama o toString()
                            System.out.println("-------------------------");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
