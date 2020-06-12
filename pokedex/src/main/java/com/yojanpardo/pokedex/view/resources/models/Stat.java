/**
 * 
 */
package com.yojanpardo.pokedex.view.resources.models;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author yojan
 *
 */
@Data
public class Stat {
	@JsonProperty("base_stat")
	private int base_stat;
	private int effort;
	private Map<String, String> stat;
}
