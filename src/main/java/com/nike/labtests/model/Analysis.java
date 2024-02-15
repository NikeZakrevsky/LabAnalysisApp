package com.nike.labtests.model;

import java.io.Serializable;

public class Analysis implements Serializable {
	private String title;
	private String description;
	private float value;

	public Analysis(String title, String description, float value) {
		this.title = title;
		this.description = description;
		this.value = value;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public float getValue() {
		return value;
	}
}
