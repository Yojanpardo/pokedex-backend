package com.yojanpardo.pokedex.business.services;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.yojanpardo.pokedex.business.repository.EvolutionChainRepository;
import com.yojanpardo.pokedex.context.UrlContext;
import com.yojanpardo.pokedex.view.resources.models.EvolutionChain;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
@Transactional(readOnly = true)
public class EvolutionChainService implements EvolutionChainRepository {
	public EvolutionChain getEvolutionChain(String evolutionChainId) throws IOException {

		Gson gson = new Gson();
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		String url = UrlContext.POKEMON_EVOLUTION_CHAIN_URL.replace("{id}",evolutionChainId);
		try {
			Request request = new Request.Builder().url(url).method("GET", null).build();
			Response response = client.newCall(request).execute();
			String json = response.body().string();
			json = json.replace("https://pokeapi.co/api/v2/pokemon-species", UrlContext.POKEMON_CONTEXT);
			EvolutionChain evolutionChain = gson.fromJson(json, EvolutionChain.class);
			return evolutionChain;
		} catch (Exception ex) {
			throw (ex);
		}

	}
}
