package bd1.model;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String tipo; // "solicitante" ou "gestor"

    // Construtor vazio
    public Usuario() {}

    // Construtor com todos os atributos
    public Usuario(int id, String nome, String email, String tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
    }

    // Get e Set
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
