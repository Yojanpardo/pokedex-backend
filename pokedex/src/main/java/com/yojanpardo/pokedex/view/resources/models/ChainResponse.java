package com.yojanpardo.pokedex.view.resources.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ChainResponse {
	@JsonProperty("evolves_to")
	private ChainResponse[] evolves_to;
	@JsonProperty("is_baby")
	private boolean is_baby;
	private SpeciesResponse species;
}
