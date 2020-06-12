/**
 * 
 */
package com.yojanpardo.pokedex.view.resources.models;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author yojan
 *
 */
@Data
public class PokemonSpecies {
	private int id;
	private String name;
	@JsonProperty("flavor_text_entries")
	private FlavorTextEntry[] flavor_text_entries;
	private Map<String, String> evolution_chain;
}
