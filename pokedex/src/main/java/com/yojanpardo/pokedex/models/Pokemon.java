/**
 * 
 */
package com.yojanpardo.pokedex.models;

import java.util.List;

import lombok.Data;

/**
 * @author yojan
 *
 */
@Data
public class Pokemon{
	private String type;
	private double weight;
	private List<Ability> abilities;
}
