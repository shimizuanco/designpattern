package com.hakotrain.designpattern.factorymethod.concrete;

import com.hakotrain.designpattern.factorymethod.framework.Product;

public class MobilePhone extends Product {

	public MobilePhone(String owner) {
		super(owner);
	}

	@Override
	public void use() {
		System.out.println("[MobilePhone: " + getOwner() + "]を使います");
	}

}
