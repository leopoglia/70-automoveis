package com.automovel.model.entities;

public abstract class Automovel {

	String modeloAutomovel, donoAutomovel, placaAutomovel;
	Integer anoFabricacaoAutomovel;
	Double precoAutomovel;

	/**
	 * Métodos da classe Automovel
	 */
	public String getPlaca() {
		return placaAutomovel;
	}

	/**
	 * Construtores da classe Automovel
	 */

	public Automovel(String modelo, String placaAutomovel, int anoFabricacaoAutomovel, double precoAutomovel) {
		super();
		this.modeloAutomovel = modelo;
		this.placaAutomovel = placaAutomovel;
		this.anoFabricacaoAutomovel = anoFabricacaoAutomovel;
		this.precoAutomovel = precoAutomovel;
	}

	public Automovel(String modeloAutomovel, String placaAutomovel, int anoFabricacaoAutomovel, double precoAutomovel, String donoAutomovel) {
		super();
		this.modeloAutomovel = modeloAutomovel;
		this.placaAutomovel = placaAutomovel;
		this.anoFabricacaoAutomovel = anoFabricacaoAutomovel;
		this.precoAutomovel = precoAutomovel;
		this.donoAutomovel = donoAutomovel;
	}

	/**
	 * toString da classe Automovel
	 */
	public String toString() {
		return "MODELO: " + modeloAutomovel + ", PLACA: " + placaAutomovel + ", ANO: " + anoFabricacaoAutomovel + ", PREÇO: " + precoAutomovel + ", DONO: " + donoAutomovel + ", ";
	}
	/**
	 * Getters e Setters da classe Automovel
	 */
	public String getModelo() {
		return modeloAutomovel;
	}
	public Integer getAno() {
		return anoFabricacaoAutomovel;
	}
	public Double getPreco() {
		return precoAutomovel;
	}
}