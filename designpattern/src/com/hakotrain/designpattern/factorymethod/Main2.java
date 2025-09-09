package com.hakotrain.designpattern.factorymethod;

import java.util.Arrays;
import java.util.List;

import com.hakotrain.designpattern.factorymethod.concrete.IDCard;
import com.hakotrain.designpattern.factorymethod.concrete.MobilePhone;
import com.hakotrain.designpattern.factorymethod.framework.FactoryV2;
import com.hakotrain.designpattern.factorymethod.framework.Product;

public class Main2 {
	public static void main(String[] args) {
		try {
			List<Product> products = prepareObjects();
			for(Product p : products) {
				p.use();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static List<Product> prepareObjects() throws Exception {

		FactoryV2 factory = new FactoryV2();
		Product[] arr={
			factory.create(IDCard.class, "tanaka"),
			factory.create(IDCard.class, "田中"),
			factory.create(MobilePhone.class, "suzuki"),
			factory.create(MobilePhone.class, "鈴木")
		};
		return Arrays.asList(arr);
	}
}
