package com.yojanpardo.pokedex.view.resources.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EvolutionChain {
	private int id;
	@JsonProperty("baby_trigger_item")
	private String baby_trigger_item;
	private ChainResponse chain;
}
