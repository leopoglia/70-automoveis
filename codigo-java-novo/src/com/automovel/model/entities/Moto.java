package com.automovel.model.entities;

public class Moto extends Automovel {
	
	String tipoAutomovel;
	Double suspensaoAutomovel;
	String tamanhoAutomovel;

	public Moto(String modeloAutomovel, String placaAutomovel, int anoAutomovel, String tipoAutomovel, double suspensaoAutomovel, String tamanhoAutomovel, double precoAutomovel) {
		super(modeloAutomovel, placaAutomovel, anoAutomovel, precoAutomovel);
		this.tipoAutomovel = tipoAutomovel;
		this.suspensaoAutomovel = suspensaoAutomovel;
		this.tamanhoAutomovel = tamanhoAutomovel;
	}
	public Moto(String modeloAutomovel, String placaAutomovel, int anoFabricacaoAutomovel, String tipoAutomovel, double suspensaoAutomovel, String tamanhoAutomovel, double precoAutomovel, String donoAutomovel) {
		super(modeloAutomovel, placaAutomovel, anoFabricacaoAutomovel, precoAutomovel, donoAutomovel);
		this.tipoAutomovel = tipoAutomovel;
		this.suspensaoAutomovel = suspensaoAutomovel;
		this.tamanhoAutomovel = tamanhoAutomovel;
	}

	@Override
	public String toString() {
		return super.toString() + "TIPO: " + tipoAutomovel + ", SUSPENSÃO: " + suspensaoAutomovel + ", TAMANHO: " + tamanhoAutomovel + "\n";
	}

	/**
	 * Getters e Setters da classe Moto
	 */
	public String getTipo() {
		return tipoAutomovel;
	}
	public Double getSuspensao() {
		return suspensaoAutomovel;
	}
	public String getTamanho() {
		return tamanhoAutomovel;
	}
}