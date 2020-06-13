/**
 * 
 */
package com.yojanpardo.pokedex.models;

import java.util.Date;

import lombok.Data;

/**
 * @author yojan
 *
 */
@Data
public abstract class Base {
	public Date created;
	public Date modified;
}
