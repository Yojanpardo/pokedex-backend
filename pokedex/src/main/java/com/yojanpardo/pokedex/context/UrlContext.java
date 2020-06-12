/**
 * 
 */
package com.yojanpardo.pokedex.context;

/**
 * @author yojan
 *
 */
public class UrlContext {
	private static final String POKEAPI_CONTEXT = "https://pokeapi.co/api/v2/"; 
	public static final String POKEMON_CONTEXT = "http://3.128.62.213/8080/api/v1/pokemon";
	// public static final String POKEMON_CONTEXT = "http://localhost:8080/api/v1/pokemon";
	public static final String POKEMON_SPECIES_URL = POKEAPI_CONTEXT.concat("pokemon-species/");
	public static final String POKEMON_EVOLUTION_CHAIN_URL = POKEAPI_CONTEXT.concat("evolution-chain/{id}");
}
