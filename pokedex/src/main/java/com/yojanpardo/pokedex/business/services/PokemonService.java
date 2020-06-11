/**
 * 
 */
package com.yojanpardo.pokedex.business.services;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.yojanpardo.pokedex.context.UrlContext;
import com.yojanpardo.pokedex.view.resources.models.PokemonsListResponse;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author yojan
 *
 */
@Service
@Transactional(readOnly = true)
public class PokemonService {
	
	private UrlContext urlContext = new UrlContext();
	
	private Gson gson = new Gson();
	private OkHttpClient client = new OkHttpClient().newBuilder().build();
	
	public PokemonsListResponse getAllPokemons(String query) throws IOException {
		try {
			Request request = new Request.Builder().url("https://pokeapi.co/api/v2/pokemon".concat(query)).method("GET", null).build();
			Response response = client.newCall(request).execute();
			String pokemonsListJson = response.body().string();
			PokemonsListResponse pokemonsListResponse = gson.fromJson(pokemonsListJson, PokemonsListResponse.class);
			pokemonsListResponse.setNext(pokemonsListResponse.getNext().replace("https://pokeapi.co/api/v2/pokemon", urlContext.getPokemonContext()));
			pokemonsListResponse.setPrevious(pokemonsListResponse.getPrevious().replace("https://pokeapi.co/api/v2/pokemon", urlContext.getPokemonContext()));
			return pokemonsListResponse;
		} catch (Exception ex) {
			throw(ex);
		}	
	}
}
