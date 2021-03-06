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
public class AbilityDetail {
	private Map<String, String> ability;
	@JsonProperty("is_hidden")
	private boolean is_hidden;
	private short slot;
}
