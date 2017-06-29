package com.example.logonpf.demomapaspoc.model;

public class Estacao {

    private String nome;
    private String endereco;
    private Double latitude;
    private Double longitude;
    private String capacidade_passageiro_hora_pico;
    private String area_construida_m_2;
    private String inauguracao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getCapacidade_passageiro_hora_pico() {
        return capacidade_passageiro_hora_pico;
    }

    public void setCapacidade_passageiro_hora_pico(String capacidade_passageiro_hora_pico) {
        this.capacidade_passageiro_hora_pico = capacidade_passageiro_hora_pico;
    }

    public String getArea_construida_m_2() {
        return area_construida_m_2;
    }

    public void setArea_construida_m_2(String area_construida_m_2) {
        this.area_construida_m_2 = area_construida_m_2;
    }

    public String getInauguracao() {
        return inauguracao;
    }

    public void setInauguracao(String inauguracao) {
        this.inauguracao = inauguracao;
    }
}
