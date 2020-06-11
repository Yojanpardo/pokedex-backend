/**
 * 
 */
package com.yojanpardo.pokedex.view.resources;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yojanpardo.pokedex.business.services.PokemonService;
import com.yojanpardo.pokedex.view.resources.models.PokemonDetailResponse;
import com.yojanpardo.pokedex.view.resources.models.PokemonsListResponse;

import io.swagger.annotations.Api;

/**
 * @author yojan
 *
 */
@RestController
@RequestMapping("/api/v1/pokemon")
@Api(tags = "Operations with pokemons")
@CrossOrigin("*")
public class PokemonResources {
	
	@Autowired
	private PokemonService pokemonService;
	
	@GetMapping()
	public ResponseEntity<PokemonsListResponse> getAllPokemon(@RequestParam Map<String,String> params){
		
		PokemonsListResponse pokemonsListResponse;
		StringBuilder query = new StringBuilder("");
		if (!params.isEmpty()) {
			query.append("?");
			for (Map.Entry<String, String> param : params.entrySet()) {
				query.append(param.getKey() + "=" + param.getValue());
			}
		}
		try {
			pokemonsListResponse = pokemonService.getAllPokemons(query.toString());
			return new ResponseEntity<PokemonsListResponse>(pokemonsListResponse, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<PokemonsListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{pokemonId}")
	public ResponseEntity<PokemonDetailResponse> getPokemon(@PathVariable("pokemonId") int pokemonId){
		PokemonDetailResponse pokemon;
		try {
			pokemon = pokemonService.getPokemon(pokemonId);
			return new ResponseEntity<PokemonDetailResponse>(pokemon, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<PokemonDetailResponse>(HttpStatus.NOT_FOUND);
		}
	}
}
