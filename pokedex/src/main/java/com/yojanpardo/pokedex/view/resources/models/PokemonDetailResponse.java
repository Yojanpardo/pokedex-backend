/**
 * 
 */
package com.yojanpardo.pokedex.view.resources.models;

import lombok.Data;

/**
 * @author yojan
 *
 */
@Data
public class PokemonDetailResponse {
	private int id;
	private String name;
	private AbilityDetail[] abilities;
	private int weight;
	private Type[] types;
	private Stat[] stats;
}
