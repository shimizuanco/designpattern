package com.hakotrain.designpattern.factorymethod;

import java.util.Arrays;
import java.util.List;

import com.hakotrain.designpattern.factorymethod.concrete.IDCard;
import com.hakotrain.designpattern.factorymethod.concrete.IDCardFactory;
import com.hakotrain.designpattern.factorymethod.concrete.MobilePhone;
import com.hakotrain.designpattern.factorymethod.concrete.MobilePhoneFactory;
import com.hakotrain.designpattern.factorymethod.framework.Factory;
import com.hakotrain.designpattern.factorymethod.framework.FactoryV2;
import com.hakotrain.designpattern.factorymethod.framework.Product;

public class Main {
	public static void main(String[] args) {
		// V1
		run();

		System.out.println();
		
		// V2
		runV2();
	}
	
	// V1
	private static void run() {
		System.out.println("V1 starts");
		for(Product p : prepareObjects()) {
			p.use();
		}
	}
	
	private static List<Product> prepareObjects() {
		Factory idCardFactory = new IDCardFactory();
		Factory mobilePhoneFactory = new MobilePhoneFactory();
		
		Product[] arr = {
				idCardFactory.create("tanaka"),
				idCardFactory.create("田中"),
				mobilePhoneFactory.create("suzuki"),
				mobilePhoneFactory.create("鈴木")
		};
		
		return Arrays.asList(arr);
	}

	// V2
	private static void runV2() {
		System.out.println("V2 starts");
		try {
			for(Product p : prepareObjects()) {
				p.use();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static List<Product> prepareObjectsV2() throws Exception {

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
