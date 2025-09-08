package com.hakotrain.designpattern.factorymethod.framework;

public abstract class Product {
	private String owner;
	
	public Product(String owner) {
		super();
		this.owner = owner;
	}
	
	public abstract void use();
	
	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
}
