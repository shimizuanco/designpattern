package com.hakotrain.designpattern.factorymethod.framework;

public abstract class Factory {
	// V1
	public Product create(String name) {
		Product product = createProduct(name);
		registerProduct(name);
		return product;
	}

	// V1
	protected abstract Product createProduct(String name);

	// Common
	protected abstract void registerProduct(String name);

}
