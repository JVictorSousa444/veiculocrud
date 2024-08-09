package com.example.model;

public class Veiculo {
    private int id;
    private String placa;
    private String renavam;
    private int idProp;
    
    
    public Veiculo() {
	}

	public Veiculo(int id, String placa, String renavam, int idProp) {
		this.id = id;
		this.placa = placa;
		this.renavam = renavam;
		this.idProp = idProp;
	}

	// Getters e Setters
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
}
