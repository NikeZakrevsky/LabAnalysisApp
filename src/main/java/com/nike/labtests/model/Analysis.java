package com.nike.labtests.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Analysis implements Serializable {
	private String title;
	private String description;
	private Map<Date, Float> values;

	public Analysis(String title, String description) {
		this.title = title;
		this.description = description;
		this.values = new HashMap<>();
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Map<Date, Float> getValue() {
		return values;
	}
}
