package com.hakotrain.designpattern.factorymethod;

import java.util.Arrays;
import java.util.List;

import com.hakotrain.designpattern.factorymethod.concrete.IDCard;
import com.hakotrain.designpattern.factorymethod.concrete.IDCardFactory;
import com.hakotrain.designpattern.factorymethod.concrete.MobilePhone;
import com.hakotrain.designpattern.factorymethod.concrete.MobilePhoneFactory;
import com.hakotrain.designpattern.factorymethod.framework.Factory;
import com.hakotrain.designpattern.factorymethod.framework.Product;

public class Main2 {
	public static void main(String[] args) {
		List<Product> products = prepareObjects();
		for(Product p : products) {
			p.use();
		}
	}
	
	private static List<Product> prepareObjects() {
		try  {
			Factory idCardFactory = new IDCardFactory();
			Factory mobilePhoneFactory = new MobilePhoneFactory();
			Product[] arr={
				idCardFactory.create(IDCard.class, "tanaka"),
				idCardFactory.create(IDCard.class, "田中"),
				mobilePhoneFactory.create(MobilePhone.class, "suzuki"),
				mobilePhoneFactory.create(MobilePhone.class, "鈴木")
			};
			return Arrays.asList(arr);
			
		} catch (Exception e){// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
