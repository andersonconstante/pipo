package com.pipo.utils;

public enum PlanosEnum {	

    EUROPA(1,"Plano de Saude NorteEuropa"),
    PAMPULHA(2,"Plano de Saude Pampulha Intermedica"),
    DENTAL_SORRISO(3,"Plano odontologico Dental Sorriso"),
    MENTESA_CORPOSAO(4,"Plano de saude mental Mente Sa, Corpo Sao");

    private String descricao;
    private int id;

    PlanosEnum(int id, String descricao) {
        this.descricao = descricao;
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getDescricao() {
        return descricao;
    }

}
