package com.hakotrain.designpattern.factorymethod.concrete;

import com.hakotrain.designpattern.factorymethod.framework.Product;

public class MobilePhone extends Product {

	public MobilePhone(String owner) {
		super(owner);
	}

	@Override
	public void use() {
		System.out.println("[Mobile Phone: " + getOwner() + "]を使います");
	}
	
	@Override
	public String toString() {
		return "[Mobile Phone: " + getOwner() + "]";
	}

}
