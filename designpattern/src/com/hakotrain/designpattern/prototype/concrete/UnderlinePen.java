package com.hakotrain.designpattern.prototype.concrete;

import com.hakotrain.designpattern.prototype.framework.Product;

public class UnderlinePen implements Product {
	private char ulchar;
	
	public UnderlinePen(char ulchar) {
		this.ulchar = ulchar;
	}
	
	// コピーコンストラクタ
	public UnderlinePen(UnderlinePen underlinePen) {
		this.ulchar = underlinePen.ulchar;
	}

	@Override
	public void use(String name) {
		System.out.println(name);
		
		int length = name.length();
		for(int i=0; i<length; i++) {
			System.out.print(ulchar);
		}
		System.out.println();
	}

	@Override
	public Product createClone() {
//		Product p = null;
//		
//		try {
//			p = (Product)clone();
//		} catch(CloneNotSupportedException e) {
//			e.printStackTrace();
//		}

		Product p = new UnderlinePen(this);
		return p;
	}

}
