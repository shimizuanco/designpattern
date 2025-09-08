package com.hakotrain.designpattern.factorymethod.concrete;

import com.hakotrain.designpattern.factorymethod.framework.Factory;
import com.hakotrain.designpattern.factorymethod.framework.Product;

public class MobilePhoneFactory extends Factory {

	@Override
	protected Product createProduct(String name) {
		Product product = new MobilePhone(name);
		return product;
	}

	@Override
	protected Product createProduct(Class<?> clazz, String name) throws Exception {
		Product product = (Product) clazz.getDeclaredConstructor(String.class).newInstance(name);
		return product;
	}

	@Override
	protected void registerProduct(String name) {
		System.out.println("Mobile Phone: " + name + "を登録しました");
	}

}
