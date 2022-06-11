package com.api.accenture.dtos;

import javax.validation.constraints.NotBlank;

public class EntrevistaDto {

    @NotBlank
    private String nomeColaborador;
    @NotBlank
    private String nomeCandidato;

    private String idVaga;

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    public String getNomeCandidato() {
        return nomeCandidato;
    }

    public void setNomeCandidato(String nomeCandidato) {
        this.nomeCandidato = nomeCandidato;
    }

    public String getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(String idVaga) {
        this.idVaga = idVaga;
    }
}
