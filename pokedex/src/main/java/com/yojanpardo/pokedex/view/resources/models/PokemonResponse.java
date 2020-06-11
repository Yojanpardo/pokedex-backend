package com.yojanpardo.pokedex.view.resources.models;

import lombok.Data;

@Data
public class PokemonResponse {
	private int id;
	private String name;
	private String url;
	private int weight;
	private Type[] types;
	private AbilityDetail[] abilities;
}
