package com.api.accenture.dtos;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

public class VagasDto {

    @NotBlank
    private String nomeVaga;
    @NotBlank
    private String statusVaga;
    @NotBlank
    private String descricao;
    private String dataAtualizacao;

    public String getNomeVaga() {
        return nomeVaga;
    }

    public void setNomeVaga(String nomeVaga) {
        this.nomeVaga = nomeVaga;
    }

    public String getStatusVaga() {
        return statusVaga;
    }

    public void setStatusVaga(String statusVaga) {
        this.statusVaga = statusVaga;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
