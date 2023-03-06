package com.android.project.first.model;

import com.android.project.first.enums.SituacaoEnum;

import java.util.Objects;

public class Prontuario {

    private Integer id;
    private String nome;
    private Integer idade;
    private Integer temperatura;
    private Integer periodoTosse;
    private Integer periodoDorCabeca;
    private SituacaoEnum situacao;
    private Integer periodoViagem;

    public Prontuario() {
    }

    public Prontuario(String nome, Integer idade, Integer temperatura, Integer periodoTosse, Integer periodoDorCabeca, Integer periodoViagem , SituacaoEnum situacao) {
        this.nome = nome;
        this.idade = idade;
        this.temperatura = temperatura;
        this.periodoTosse = periodoTosse;
        this.periodoDorCabeca = periodoDorCabeca;
        this.periodoViagem = periodoViagem;
        this.situacao = situacao;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getPeriodoTosse() {
        return periodoTosse;
    }

    public void setPeriodoTosse(Integer periodoTosse) {
        this.periodoTosse = periodoTosse;
    }

    public Integer getPeriodoDorCabeca() {
        return periodoDorCabeca;
    }

    public void setPeriodoDorCabeca(Integer periodoDorCabeca) {
        this.periodoDorCabeca = periodoDorCabeca;
    }

    public SituacaoEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoEnum situacao) {
        this.situacao = situacao;
    }

    public Integer getPeriodoViagem() {
        return periodoViagem;
    }

    public void setPeriodoViagem(Integer periodoViagem) {
        this.periodoViagem = periodoViagem;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prontuario that = (Prontuario) o;
        return Objects.equals(nome, that.nome) && Objects.equals(idade, that.idade) && Objects.equals(temperatura, that.temperatura) && Objects.equals(periodoTosse, that.periodoTosse) && Objects.equals(periodoDorCabeca, that.periodoDorCabeca) && situacao == that.situacao && Objects.equals(periodoViagem, that.periodoViagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade, temperatura, periodoTosse, periodoDorCabeca, situacao, periodoViagem);
    }
}
