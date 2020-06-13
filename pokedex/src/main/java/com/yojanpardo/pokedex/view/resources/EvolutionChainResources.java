package com.yojanpardo.pokedex.view.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yojanpardo.pokedex.business.repository.EvolutionChainRepository;
import com.yojanpardo.pokedex.view.resources.models.EvolutionChain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/evolution-chain")
@Api(tags = "Operations with pokemon's evolution chain")
@CrossOrigin("*")
public class EvolutionChainResources {
	
	@Autowired
	private EvolutionChainRepository evolutionChainRepository;
	
	@GetMapping("/{id}")
	@ApiOperation(value = "get pokemon's evolution chain ", notes = "Use pokeapi evolution-chain endpoint")
	@ApiResponses(
		value = {
				@ApiResponse(code = 200, message = "evolution chain getted"),
				@ApiResponse(code = 404, message = "evolution chain not found"),
				@ApiResponse(code = 500, message = "Internal server error")
	})
	public ResponseEntity<EvolutionChain> getEvolutionChain(@PathVariable("id") String id) {
		try {
			EvolutionChain evolutionChain = evolutionChainRepository.getEvolutionChain(id);
			if (evolutionChain == null) {
				return new ResponseEntity<EvolutionChain>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<EvolutionChain>(evolutionChain, HttpStatus.OK);
			}
		} catch (Exception ex) {
			return new ResponseEntity<EvolutionChain>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
