package com.hakotrain.designpattern.adaptor;

import static java.lang.System.*;

// Service V1
public class Service {
	// Service common
	private int vAny = 100;
	private int v1Only = 111;

	// Service V1
	public void funcVAny() {
		out.println("");
		System.out.println("Service_funcVAny()");
		System.out.println("  vAny = " + vAny);
	}

	public void funcV2Only() {
		System.out.println("Service_funcV1Only()");
		System.out.println("  v1Only = " + v1Only);
	}

	/**
	 * @return the vAny
	 */
	public int getVAny() {
		return vAny;
	}

	/**
	 * @param vAny the vAny to set
	 */
	public void setVAny(int vAny) {
		this.vAny = vAny;
	}

	/**
	 * @return the v1Only
	 */
	public int getV1Only() {
		return v1Only;
	}

	/**
	 * @param v1Only the v1Only to set
	 */
	public void setV1Only(int v1Only) {
		this.v1Only = v1Only;
	}

}
