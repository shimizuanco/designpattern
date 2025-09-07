package com.hakotrain.designpattern.factorymethod;

import java.util.Arrays;
import java.util.List;

import com.hakotrain.designpattern.factorymethod.concrete.IDCardFactory;
import com.hakotrain.designpattern.factorymethod.concrete.MobilePhoneFactory;
import com.hakotrain.designpattern.factorymethod.framework.Factory;
import com.hakotrain.designpattern.factorymethod.framework.Product;

public class Main {
	public static void main(String[] args) {
		Factory idCardFactory = new IDCardFactory();
		Factory mobilePhoneFactory = new MobilePhoneFactory();
		
		Product[] arr = {
				idCardFactory.create("tanaka"),
				idCardFactory.create("田中"),
				mobilePhoneFactory.create("suzuki"),
				mobilePhoneFactory.create("鈴木")
		};
		
		List<Product> products = Arrays.asList(arr);
		for(Product p : products) {
			p.use();
		}

	}
}
