/**
 * 
 */
package com.yojanpardo.pokedex.business.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.yojanpardo.pokedex.business.repository.PokemonRepository;
import com.yojanpardo.pokedex.context.UrlContext;
import com.yojanpardo.pokedex.view.resources.models.PokemonDetailResponse;
import com.yojanpardo.pokedex.view.resources.models.PokemonSpecies;
import com.yojanpardo.pokedex.view.resources.models.PokemonsListResponse;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author yojan
 *
 */
@Service
public class PokemonService implements PokemonRepository {

	public PokemonsListResponse getAllPokemons(String query) throws IOException {

		Gson gson = new Gson();
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		
		try {
			Request request = new Request.Builder().url("https://pokeapi.co/api/v2/pokemon".concat(query))
					.method("GET", null).build();
			Response response = client.newCall(request).execute();
			String pokemonsListJson = response.body().string();
			PokemonsListResponse pokemonsListResponse = gson.fromJson(pokemonsListJson, PokemonsListResponse.class);

			for (int i = 0; i <= pokemonsListResponse.getResults().size() - 1; i++) {
				String[] urlParts = pokemonsListResponse.getResults().get(i).getUrl().split("/");
				int pokemonId = Integer.parseInt(urlParts[urlParts.length - 1]);

				pokemonsListResponse.getResults().get(i).setId(pokemonId);
			}

			if (pokemonsListResponse.getNext() != null)
				pokemonsListResponse.setNext(pokemonsListResponse.getNext().replace("https://pokeapi.co/api/v2/pokemon",
						UrlContext.POKEMON_CONTEXT));
			if (pokemonsListResponse.getPrevious() != null)
				pokemonsListResponse.setPrevious(pokemonsListResponse.getPrevious()
						.replace("https://pokeapi.co/api/v2/pokemon", UrlContext.POKEMON_CONTEXT));
			return pokemonsListResponse;
		} catch (Exception ex) {
			throw (ex);
		}
	}

	public PokemonDetailResponse getPokemon(int pokemonId) throws IOException {

		Gson gson = new Gson();
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		try {
			Request request = new Request.Builder().url("https://pokeapi.co/api/v2/pokemon/" + pokemonId)
					.method("GET", null).build();
			Response response = client.newCall(request).execute();
			String pokemonJson = response.body().string();
			PokemonDetailResponse pokemonResponse = gson.fromJson(pokemonJson, PokemonDetailResponse.class);
			return pokemonResponse;
		} catch (Exception ex) {
			throw (ex);
		}
	}
	
	public PokemonSpecies getPokemonSpecies(int pokemonId) throws IOException {
		Gson gson = new Gson();
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		try {
			Request request = new Request.Builder().url(UrlContext.POKEMON_SPECIES_URL + pokemonId).method("GET", null).build();
			Response response = client.newCall(request).execute();
			String pokemonSpeciesJson = response.body().string();
			PokemonSpecies pokemonSpecies = gson.fromJson(pokemonSpeciesJson, PokemonSpecies.class);
			return pokemonSpecies;
		} catch (Exception ex) {
			throw(ex);
		}
	}
}
