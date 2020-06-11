package com.yojanpardo.pokedex.view.resources.models;

import java.util.Map;

import lombok.Data;

@Data
public class Type {
	private int slot;
	private Map<String, String> type;
}
