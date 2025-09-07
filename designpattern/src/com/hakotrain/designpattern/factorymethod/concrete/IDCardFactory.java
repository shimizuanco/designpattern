package com.hakotrain.designpattern.factorymethod.concrete;

import com.hakotrain.designpattern.factorymethod.framework.Factory;
import com.hakotrain.designpattern.factorymethod.framework.Product;

public class IDCardFactory extends Factory {

	@Override
	protected Product createProduct(String name) {
		Product product = new IDCard(name);
		return product;
	}

	@Override
	protected void registerProduct(String name) {
		System.out.println("IDCard: " + name + "を登録しました");

	}

}
