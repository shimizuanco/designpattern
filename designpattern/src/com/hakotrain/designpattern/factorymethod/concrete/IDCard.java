package com.hakotrain.designpattern.factorymethod.concrete;

import com.hakotrain.designpattern.factorymethod.framework.Product;

public class IDCard extends Product {
	IDCard(String owner) {
		super(owner);
	}
	
	@Override
	
	public void use() {
		System.out.println(this + "を使います");
	}
	
	@Override
	public String toString() {
		return "[IDCard: " + getOwner() + "]";
	}

}
