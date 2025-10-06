package com.hakotrain.designpattern.prototype.framework;

import java.util.HashMap;
import java.util.Map;

public class Manager {
	private Map<String, Product> showcase = new HashMap<>();
	
	public void register(String protoName, Product product) {
		showcase.put(protoName, product);
	}
	
	public Product create(String protoName) {
		Product p = showcase.get(protoName);
		return p.createClone();
	}
}
