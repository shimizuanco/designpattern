package com.hakotrain.designpattern.nest.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
class NestedTest {

	static private String normalTest = "NestedTest";

//	@BeforeAll
//	void beforeAll() {
//		normalTest += " NestedTest-beforeAll()";
//		System.out.println(normalTest);
//	}

	@BeforeEach
	void beforeEach() {
		normalTest += " NestedTest-beforeEach()\n";
	}

	@Test
	void testNestedTestNormal1() {
		normalTest += " testNestedTestNormal1()\n";
	}

	@Nested
	class NormalTest {
//		@BeforeAll
//		void beforeAll() {
//			normalTest += " NormalTest-beforeAlll()";
//		}

		void testNestedTestNormal1() {
			normalTest += " testNormalTestNormal1()\n";
		}

		@AfterAll
		static void afterAll() {
			normalTest += " NormalTest-afterAll()\n";
			System.out.println(normalTest);
		}
	}

	@AfterAll
	static void afterAll() {
		normalTest += " NestTest-afterAll()\n";
		System.out.println(normalTest);
	}

}
