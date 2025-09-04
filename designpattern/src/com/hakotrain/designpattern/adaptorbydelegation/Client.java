package com.hakotrain.designpattern.adaptorbydelegation;

public class Client {
	public static void main(String[] args) {
		System.out.println("CREATE Client");
		
		Service sv = new Service();
		sv.funcV1Only();
		sv.funcVAny();
		
		System.out.println();
		
		ServiceV2 sv2 = new ServiceV2();
		sv2.funcV2Only();
		sv2.funcVAny();
	}

}
