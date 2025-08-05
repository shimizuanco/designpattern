package com.hakotrain.designpattern.iterator.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hakotrain.designpattern.iterator.Book;

class BookTest {

	// 正常系　コンストラクタで名前(name)として１文字以上の文字列を設定できる
	@Test
	void constructorNameHasMoreThan0CharsTest() {
		String expected = "吾輩は猫である";
		Book book = new Book(expected);
		String actual = book.name();
		assertEquals(expected, actual);
	}
	
	// 異常系　コンストラクタで名前(name)として空文字列は設定できない
	@Test
	void constractorNameHasNoCharTest() {
		// 例外が発生することを確認する
		Throwable e = assertThrows(IllegalArgumentException.class, () ->{new Book("");});
		
		// 例外オブジェクトに格納したmessageを確認する
		String expected = "Bookの名前(name)に空文字列は指定できません";
		String actual = e.getMessage();
		assertEquals(expected, actual);
	}
	
	// 異常系　コンストラクタで名前(name)としてnullは設定できない
	@Test
	void constractorNameIsNullTest() {
		// 例外が発生することを確認する
		Throwable e = assertThrows(IllegalArgumentException.class, () ->{new Book(null);});
		
		// 例外オブジェクトに格納したmessageを確認する
		String expected = "Bookの名前(name)にnullは指定できません";
		String actual = e.getMessage();
		assertEquals(expected, actual);
	}

	// 正常系　設定した名前を取り出せる
	@Test
	void nameTest() {
		
	}

}
