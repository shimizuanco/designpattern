package com.hakotrain.designpattern.prototype.framework;

public interface Product extends Cloneable {
	void use(String name);
	Product createClone();
}
