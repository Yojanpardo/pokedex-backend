/**
 * 
 */
package com.yojanpardo.pokedex.view.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yojanpardo.pokedex.business.repository.PokemonRepository;
import com.yojanpardo.pokedex.view.resources.models.PokemonSpecies;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author yojan
 *
 */
@RestController
@RequestMapping("api/v1/pokemon-species")
@CrossOrigin("*")
@Api(tags = "Operations with pokemon species")
public class PokemonSpeciesResources {
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@GetMapping("{pokemonId}")
	@ApiOperation(value = "Get a pokemon species", notes = "Ables to get a pokemon species with the information that you need for evolution chain")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Pokemon species getted successfully")
	})
	public ResponseEntity<PokemonSpecies> getPokemonSpecies(@PathVariable("pokemonId") int pokemonId){
		PokemonSpecies pokemonSpecies;
		try {
			pokemonSpecies = pokemonRepository.getPokemonSpecies(pokemonId);
			if (pokemonSpecies == null) {
				return new ResponseEntity<PokemonSpecies>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<PokemonSpecies>(pokemonSpecies, HttpStatus.OK);
			}
		} catch (Exception ex){
			return new ResponseEntity<PokemonSpecies>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
