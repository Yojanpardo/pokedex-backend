/**
 * 
 */
package com.yojanpardo.pokedex.models;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * @author yojan
 *
 */
@Data
@MappedSuperclass
public abstract class Base {
	@Temporal(TemporalType.TIMESTAMP)
	public Date created;
	@Temporal(TemporalType.TIMESTAMP)
	public Date modified;
}
