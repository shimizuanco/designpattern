package com.hakotrain.designpattern.singleton.triplet;

public class Triplet {
	private static Triplet[] triplets = new Triplet[3];
	private static int index = 0;
	private String name;
	
	private Triplet(String name) {
		System.out.println("インスタンスを生成しました");
		this.name = name;
	}
	
	public static Triplet getInstance(String name) {
		if(index < 3) {
			triplets[index] = new Triplet(name);
			index++;
			return triplets[index - 1];
		} else {
			int randomIndex = (int)(Math.random() * 3);
			return triplets[randomIndex];
		}
	}
}
