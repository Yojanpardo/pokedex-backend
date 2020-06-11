/**
 * 
 */
package com.yojanpardo.pokedex.view.resources.models;

import java.util.List;

import lombok.Data;

/**
 * @author yojan
 *
 */
@Data
public class PokemonsListResponse {
	private String count;
	private String next;
	private String previous;
	private List<PokemonResponse> results;
}
