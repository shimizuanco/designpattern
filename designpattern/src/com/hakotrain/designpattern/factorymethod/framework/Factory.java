package com.hakotrain.designpattern.factorymethod.framework;

public abstract class Factory {
	// V1
	public Product create(String name) {
		Product product = createProduct(name);
		registerProduct(name);
		return product;
	}
	
	// V2
	public Product create(Class<?> clazz, String name) throws Exception {
		Product product = createProduct(clazz, name);
		registerProduct(name);
		return product;
	}

	protected abstract Product createProduct(String name);
	protected abstract void registerProduct(String name);
	
	// V2
	protected abstract Product createProduct(Class<?> clazz, String name) throws Exception;

}
