/**
 * 
 */
package com.yojanpardo.pokedex.business.repository;

import java.io.IOException;

import com.yojanpardo.pokedex.view.resources.models.EvolutionChain;

/**
 * @author yojan
 *
 */
public interface EvolutionChainRepository {
	public EvolutionChain getEvolutionChain(String evolutionChainId) throws IOException;
}
