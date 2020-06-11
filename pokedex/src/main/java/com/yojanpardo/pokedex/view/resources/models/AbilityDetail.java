/**
 * 
 */
package com.yojanpardo.pokedex.view.resources.models;

import java.util.Map;

import lombok.Data;

/**
 * @author yojan
 *
 */
@Data
public class AbilityDetail {
	private Map<String, String> ability;
	private boolean is_hidden;
	private short slot;
}
