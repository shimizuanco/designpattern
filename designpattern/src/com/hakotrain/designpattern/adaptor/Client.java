package com.hakotrain.designpattern.adaptor;

public class Client {
	public static void main(String[] args) {
		System.out.println("CREATE Client");
		
		Service sv = new Service();
		sv.funcV2Only();
		sv.funcVAny();
		
		IServiceV2 sv2 = new ServiceV2();
		sv2.funcV2Only();
		sv2.funcVAny();
	}

}
