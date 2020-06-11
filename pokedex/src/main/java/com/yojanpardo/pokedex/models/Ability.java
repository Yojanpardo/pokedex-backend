/**
 * 
 */
package com.yojanpardo.pokedex.models;

import lombok.Data;

/**
 * @author yojan
 *
 */
@Data
public class Ability {
	private String name;
	private String url;
	private boolean is_hidden;
	private short slot;
}
