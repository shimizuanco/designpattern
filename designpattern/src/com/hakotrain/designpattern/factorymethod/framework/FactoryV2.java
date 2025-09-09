package com.hakotrain.designpattern.factorymethod.framework;

public class FactoryV2 {
	// V2
	public Product create(Class<?> clazz, String name) throws Exception {
		Product product = (Product) clazz.getDeclaredConstructor(String.class).newInstance(name);
		registerProduct(name);
		return product;
	}

	// Common
	protected void registerProduct(String name) {
		System.out.println(this.getClass().getName() + ": " + name +"を登録しました");
	}
}
