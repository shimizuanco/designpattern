package com.hakotrain.designpattern.singleton;

public class Main {
	// Singletonのインスタンスを取得するメソッドを呼び出す
	public static void main(String[] args) {
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		if(obj1 == obj2) {
			System.out.println("obj1とobj2は同じインスタンスです");
		} else {
			System.out.println("obj1とobj2は別のインスタンスです");
		}
	}
}
