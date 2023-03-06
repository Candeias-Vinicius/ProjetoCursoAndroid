package com.android.project.first.enums;

public enum SituacaoEnum {
    EM_TRATAMENTO("Em Tratamento"), QUARENTENA("Em Quarentena"), LIBERADO("Liberado");
    private String Situacao;

    SituacaoEnum(String situacao) {
        Situacao = situacao;
    }
    public String getSituacao() {
        return Situacao;
    }
    public void setSituacao(String situacao) {
        Situacao = situacao;
    }
}
