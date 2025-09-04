package com.hakotrain.designpattern.adaptorbydelegation;

public class ServiceV2 {
	// Service common
	private int vAny = 200;

	// Service V2
	private int v2Only = 222;
	
	// Service V1 instance
	private Service serviceV1;
	
	public ServiceV2() {
		serviceV1 = new Service();
	}
	
	public void funcV2Only() {
		System.out.println("ServiceV2_funcV2Only()");
		System.out.println("  v2Only = " + v2Only);
	}

	// delegation
	public void funcVAny() {
		System.out.println("ServiceV2_funcVAny()");
		System.out.println("  VAny = " + serviceV1.getVAny());
	}
}