package com.hakotrain.designpattern.iterator.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hakotrain.designpattern.iterator.Book;

class BookTest {

	// 正常系　コンストラクタで名前として１文字以上の文字列を設定できる
	@Test
	void constractorNormalTest() {
		String expected = "吾輩は猫である";
		Book book = new Book(expected);
		String actual = book.name();
		
		assertEquals(expected, actual);
	}
	
	// 正常系　コンストラクタで名前として空文字列を設定できる
	@Test
	void constractorNullStringTest() {
		Book book = new Book("");
		String actual = book.name();
		String expected = "";
		
		assertEquals(expected, actual);
	}
	
	// 正常系　コンストラクタで名前としてnullは設定できない
	@Test
	void constractorNullTest() {
		Book book = new Book(null);
		String actual = book.name();
		
		assertNull(actual, "Bookコンストラクタの引数がnullです");
	}

	
	@Test
	void constractorNullTest1() {
		
	}

}
