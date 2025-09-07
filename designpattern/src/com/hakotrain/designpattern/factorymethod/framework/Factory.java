package com.hakotrain.designpattern.factorymethod.framework;

public abstract class Factory {
	public Product create(String name) {
		Product product = createProduct(name);
		registerProduct(name);
		return product;
	}
	
	protected abstract Product createProduct(String name);
	protected abstract void registerProduct(String name);
}
