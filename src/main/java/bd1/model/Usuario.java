package bd1.model;

public class Usuario {
    private long id;
    private String nome;
    private String email;
    private String tipo; // "SOLICITANTE" ou "GESTOR"

    // Construtor completo
    public Usuario(long id, String nome, String email, String tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
    }

    // Construtor para novo usuário
    public Usuario(String nome, String email, String tipo) {
        this(0L, nome, email, tipo);
    }

    // Construtor vazio
    public Usuario() {
    }

    // Getters e Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    //toString
    @Override
    public String toString() {
        return "Usuario [ID=" + id + ", Nome=" + nome + ", Email=" + email + ", Tipo=" + tipo + "]";
    }
}