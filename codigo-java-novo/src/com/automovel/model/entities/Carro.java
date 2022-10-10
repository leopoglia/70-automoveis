package com.automovel.model.entities;

public class Carro extends Automovel {
	Integer portasAutomovel;
	Integer cavalosAutomovel;
	String estiloAutomovel;

	/**
	 * Construtores da classe Carro
	 */
	public Carro(String modeloAutomovel, String placaAutomovel, int anoFabricacaoAutomovel, int portasAutomovel, int cavalosAutomovel, String estiloAutomovel, double precoAutomovel, String donoAutomovel) {
		super(modeloAutomovel, placaAutomovel, anoFabricacaoAutomovel, precoAutomovel, donoAutomovel);
		this.portasAutomovel = portasAutomovel;
		this.cavalosAutomovel = cavalosAutomovel;
		this.estiloAutomovel = estiloAutomovel;
		this.donoAutomovel = donoAutomovel;
	}

	public Carro(String modeloAutomovel, String placaAutomovel, int anoFabricacaoAutomovel, int portasAutomovel, int cavalosAutomovel, String estiloAutomovel, double precoAutomovel) {
		super(modeloAutomovel, placaAutomovel, anoFabricacaoAutomovel, precoAutomovel);
		this.portasAutomovel = portasAutomovel;
		this.cavalosAutomovel = cavalosAutomovel;
		this.estiloAutomovel = estiloAutomovel;
	}

	/**
	 * toString da classe Carro
	 */
	@Override
	public String toString() {
		return super.toString() + "PORTAS: " + portasAutomovel + ", CAVALOS: " + cavalosAutomovel + ", ESTILO: " + estiloAutomovel + "\n";
	}

	/**
	 * Getters e Setters da classe Carro
	 */
	public Integer getPortas() {
		return portasAutomovel;
	}
	public Integer getCavalos() {
		return cavalosAutomovel;
	}
	public String getEstilo() {
		return estiloAutomovel;
	}
}