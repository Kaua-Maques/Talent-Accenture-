package com.api.accenture.dtos;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class ContratacoesDto {

    @NotBlank
    private String dataContratacao;

    @NotBlank
    private String idEntrevista;

    @NotBlank
    public String getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getIdEntrevista() {
        return idEntrevista;
    }

    public void setIdEntrevista(String idEntrevista) {
        this.idEntrevista = idEntrevista;
    }
}
