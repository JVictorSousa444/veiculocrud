package com.example.model;

public class Veiculo {
    private int id;
    private String placa;
    private String renavam;
    private int idProp;
    private int idStatus;
    private String nomeProprietario;
    private String nomeStatus; // Adicionado para armazenar o nome do status

    // Construtor com todos os parâmetros
    public Veiculo(int id, String placa, String renavam, int idProp, int idStatus, String nomeProprietario) {
        this.id = id;
        this.placa = placa;
        this.renavam = renavam;
        this.idProp = idProp;
        this.idStatus = idStatus;
        this.nomeProprietario = nomeProprietario;
    }

    // Construtor padrão
    public Veiculo() {
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public int getIdProp() {
        return idProp;
    }

    public void setIdProp(int idProp) {
        this.idProp = idProp;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getNomeStatus() {
        return nomeStatus;
    }

    public void setNomeStatus(String nomeStatus) {
        this.nomeStatus = nomeStatus;
    }
}
