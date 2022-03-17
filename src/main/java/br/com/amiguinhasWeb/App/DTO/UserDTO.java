package br.com.amiguinhasWeb.App.DTO;

public class UserDTO {
    
    private String userId;
    private String email;
    private String senha;

    // Constructors
    public UserDTO(String userId, String email, String senha) {
        this.userId = userId;
        this.email = email;
        this.senha = senha;
    }

    public UserDTO() {}

    // Getters & Setters
    public String getId() {
        return this.userId;
    }

    public void setId(String id) {
        this.userId = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
