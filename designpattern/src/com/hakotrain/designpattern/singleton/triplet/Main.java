package com.hakotrain.designpattern.singleton.triplet;

public class Main {
	// Tripletのインスタンスを取得するメソッドを呼び出す
	public static void main(String[] args) {
		Triplet obj1 = Triplet.getInstance("A");
		Triplet obj2 = Triplet.getInstance("B");
		Triplet obj3 = Triplet.getInstance("C");
		Triplet obj4 = Triplet.getInstance("D");
		
		if(obj1 == obj2) {
			System.out.println("obj1とobj2は同じインスタンスです");
		} else {
			System.out.println("obj1とobj2は別のインスタンスです");
		}
		
		if(obj1 == obj3) {
			System.out.println("obj1とobj3は同じインスタンスです");
		} else {
			System.out.println("obj1とobj3は別のインスタンスです");
		}
		
		if(obj1 == obj4) {
			System.out.println("obj1とobj4は同じインスタンスです");
		} else {
			System.out.println("obj1とobj4は別のインスタンスです");
		}
		
		if(obj2 == obj3) {
			System.out.println("obj2とobj3は同じインスタンスです");
		} else {
			System.out.println("obj2とobj3は別のインスタンスです");
		}
		
		if(obj2 == obj4) {
			System.out.println("obj2とobj4は同じインスタンスです");
		} else {
			System.out.println("obj2とobj4は別のインスタンスです");
		}
		
		if(obj3 == obj4) {
			System.out.println("obj3とobj4は同じインスタンスです");
		} else {
			System.out.println("obj3とobj4は別のインスタンスです");
		}
	}
}
