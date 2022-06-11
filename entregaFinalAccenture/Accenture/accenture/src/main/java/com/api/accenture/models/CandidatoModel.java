package com.api.accenture.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_CANDIDATO")
public class CandidatoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDateTime registrationDate;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cargoPretendido;
    @Column(nullable = false, length = 24)
    private String genero;
    @Column(nullable = false, length = 15)
    private String estadoCivil;
    @Column(unique = false, length = 17)
    private String telefone;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true, length = 14)
    private String cpf;
    @Column(nullable = false, unique = false, length = 10)
    private String nascimento;
    @Column(nullable = false)
    private String localidade;
    @Column(nullable = false, unique = true, length = 17)
    private String celular;
    @Column(nullable = false)
    private String instrucao;
    @Column(nullable = false)
    private String curso;
    @Column()
    private String observacoes;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private String habilidades;
    @Column
    private String entrevistador;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargoPretendido() {
        return cargoPretendido;
    }

    public void setCargoPretendido(String cargoPretendido) {
        this.cargoPretendido = cargoPretendido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getInstrucao() {
        return instrucao;
    }

    public void setInstrucao(String instrucao) {
        this.instrucao = instrucao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public String getEntrevistador() {
        return entrevistador;
    }

    public void setEntrevistador(String entrevistador) {
        this.entrevistador = entrevistador;
    }
}
