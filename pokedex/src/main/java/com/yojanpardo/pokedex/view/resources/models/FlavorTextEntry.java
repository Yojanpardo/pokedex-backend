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
public class FlavorTextEntry {
	@JsonProperty("flavor_text")
	private String flavor_text;
	private Map<String,String> language;
	private Map<String, String> version;
}
