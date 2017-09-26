package edu.ksu.canvas.model;

import java.io.Serializable;

public class GradingSchemeEntry implements Serializable {

	private static final long serialVersionUID = -7443498400743498450L;

	private String name;
	
	private Float value;

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
