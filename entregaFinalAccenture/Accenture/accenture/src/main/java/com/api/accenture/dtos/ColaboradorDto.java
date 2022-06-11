package com.api.accenture.dtos;

import javax.validation.constraints.NotBlank;

public class ColaboradorDto {

    @NotBlank
    private String nomeColaborador;
    @NotBlank
    private String usuario;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
