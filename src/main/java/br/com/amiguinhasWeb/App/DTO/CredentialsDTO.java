package br.com.amiguinhasWeb.App.DTO;

public class CredentialsDTO {
    
    private long userId;
    private String email;
    private String token;

    // Constructors
    public CredentialsDTO(long userId, String email, String token) {
        this.userId = userId;
        this.email = email;
        this.token = token;
    }

    public CredentialsDTO() {}

    // Getters & Setters
    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
