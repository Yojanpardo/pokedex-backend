/**
 * 
 */
package com.yojanpardo.pokedex.business.repository;

import java.io.IOException;

import com.yojanpardo.pokedex.view.resources.models.PokemonDetailResponse;
import com.yojanpardo.pokedex.view.resources.models.PokemonSpecies;
import com.yojanpardo.pokedex.view.resources.models.PokemonsListResponse;

/**
 * @author yojan
 *
 */
public interface PokemonRepository {
	public PokemonsListResponse getAllPokemons(String query) throws IOException;
	public PokemonDetailResponse getPokemon(int pokemonId) throws IOException;
	public PokemonSpecies getPokemonSpecies(int pokemonId) throws IOException;
}
