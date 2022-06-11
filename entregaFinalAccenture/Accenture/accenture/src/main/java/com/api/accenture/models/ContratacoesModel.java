package com.api.accenture.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_CONTRATACOES")
public class ContratacoesModel implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String dataContratacao;
    @Column
    private String idEntrevista;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
