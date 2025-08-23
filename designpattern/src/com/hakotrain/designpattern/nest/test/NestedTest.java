package com.hakotrain.designpattern.nest.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
class NestedTest {

	static String varNestedTest = "varNestedTest ";

	@BeforeAll
	static void beforeAll() {
		varNestedTest += "NestedTest-beforeAll() ";
//		System.out.println(varNestedTest);
	}

	@BeforeEach
	void beforeEach() {
		varNestedTest += "NestedTest-beforeEach() ";
	}

	@Test
	void testNestedTestNormal1() {
		varNestedTest += "testNestedTestNormal1() ";
		NormalTest nt = new NormalTest();
		nt.testNestedTestNormal1();
	}

	@Nested
	class NormalTest {
		
		static String varNormalTest = "varNormalTest ";
		
		@BeforeAll
		static void beforeAll() {
			varNestedTest += "NormalTest-beforeAlll() ";
			varNormalTest += "NormalTest-beforeAlll() ";
//			System.out.println(varNestedTest);
		}

		void testNestedTestNormal1() {
			varNestedTest += "NormalTest-testNestedTestNormal1() ";
			varNormalTest += "NormalTest-testNestedTestNormal1() ";
			System.out.println(varNormalTest);
		}

		@AfterAll
		static void afterAll() {
			varNestedTest += "NormalTest-afterAll() ";
			varNormalTest += "NormalTest-afterAll() ";
			System.out.println(varNormalTest);
		}
	}

	@AfterAll
	static void afterAll() {
		varNestedTest += "NestedTest-afterAll() ";
		System.out.println(varNestedTest);
	}

}
