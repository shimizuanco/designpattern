package com.hakotrain.designpattern.nest.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
class NestedTest {

	private String normalTest = "Class01";
	
	@BeforeAll
	void beforeAll() {
		System.out.println("NestedTest # setupAll()");
		normalTest += " beforeAll()";
	}
	
	@BeforeEach
	void beforeEach() {
		normalTest += " beforeEach()";

	}
	
	@Test
	void testClass1Normal() {
		normalTest += " testClass1Normal()";		
	}
	
	@Nested
	class NormalTest {
		void testClass2Normal() {
			System.out.println("NormalTest # testNormal()");
			normalTest += " testClass2Normal()";
		}

	}

}
