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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
	@ApiOperation(value = "get all pokemons", notes = "Able to use params for pagination")
	@ApiResponses(
		value = {
				@ApiResponse(code = 200, message = "pokemons getted"),
				@ApiResponse(code = 500, message = "Internal server error")
	})
	public ResponseEntity<PokemonsListResponse> getAllPokemon(@RequestParam(required = false) Map<String,String> params){
		
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
	@ApiOperation(value = "Get a pokemon", notes = "Get a single pokemon with pokemonId path variable")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "pokemon getted successfully"),
			@ApiResponse(code = 404, message = "Pokemon not found"),
			@ApiResponse(code = 500, message = "internal server error")
	})
	public ResponseEntity<PokemonDetailResponse> getPokemon(@PathVariable("pokemonId") int pokemonId){
		PokemonDetailResponse pokemon;
		try {
			pokemon = pokemonService.getPokemon(pokemonId);
			
			if (pokemon == null)
				return new ResponseEntity<PokemonDetailResponse>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<PokemonDetailResponse>(pokemon, HttpStatus.OK);
		
		} catch (Exception ex) {
			return new ResponseEntity<PokemonDetailResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
