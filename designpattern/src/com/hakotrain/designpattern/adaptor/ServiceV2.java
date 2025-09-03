package com.hakotrain.designpattern.adaptor;

// V2
public class ServiceV2 extends Service implements IServiceV2 {
	// Service common
//	private int vAny = 200;

	// Service V2
	private int v2Only = 222;
	
	@Override
	public void funcV2Only() {
		System.out.println("ServiceV2_funcV2Only()");
		System.out.println("  v2Only = " + v2Only);
	}

	@Override
	public void funcVAny() {
		System.out.println("ServiceV2_funcVAny()");
		System.out.println("  VAny = " + getVAny());
	}

}
