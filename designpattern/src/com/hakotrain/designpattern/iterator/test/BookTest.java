package com.hakotrain.designpattern.iterator.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.hakotrain.designpattern.iterator.Book;

class BookTest {
	
	// 正常系　コンストラクタ　引数(name)に１文字以上の文字列を設定し、Bookオブジェクトが生成できること
	@ParameterizedTest
	@ValueSource(strings = {"w", "吾輩は猫である"})
	@DisplayName("正常系　コンストラクタ　引数(name)に１文字以上の文字列を設定し、Bookオブジェクトが生成できること")
	void testConstructorNameNormal(String candidate) {
		String expected = "com.hakotrain.designpattern.iterator.Book";
		
		Book book = new Book(candidate);
		String actual = book.getClass().getName();
		
		assertEquals(expected, actual);
	}
	
	
	// 正常系　name()　設定した名前を取り出せること
	@ParameterizedTest
	@ValueSource(strings = {"w", "吾輩は猫である"})
	@DisplayName("正常系　name()　Bookに設定した名前を取り出せること")
	void testNameNormal(String candidate) {
		String expected = candidate;
		
		Book book = new Book(expected);
		String actual = book.name();
		
		assertEquals(expected, actual);
		
	}


	// 異常系　コンストラクタ　引数(name)に仕様外の値（null,空文字列）を設定すると例外が発生する
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = {""})
	@DisplayName("異常系　コンストラクタ　引数(name)にnullまたは空文字列を設定すると例外が発生する")
	void testConstractorNameIllegal(String candidate) {
		// 例外が発生することを確認する
		Throwable e = assertThrows(IllegalArgumentException.class, () ->{new Book(candidate);});
		
		// 例外オブジェクトに格納したmessageを確認する
		String expected = "Bookの名前(name)に「" + candidate + "」は指定できません";
		String actual = e.getMessage();
		assertEquals(expected, actual);
	}

	
	// （参考）正常系　コンストラクタ　Bookオブジェクトが生成できること
	@Test
	@DisplayName("（参考）正常系　コンストラクタ　引数(name)に１文字の文字列を設定し、Bookオブジェクトが生成できること")
	void testConstructorNameHasEq1Char() {
		String expected = "com.hakotrain.designpattern.iterator.Book";
		
		String name = "w";
		Book book = new Book(name);
		String actual = book.getClass().getName();
		
		assertEquals(expected, actual);
	}
	
	// （参考）正常系　コンストラクタ　引数(name)に２文字以上の文字列を設定し、Bookオブジェクトが生成できること
	@Test
	@DisplayName("（参考）正常系　コンストラクタ　引数(name)に２文字以上の文字列を設定し、Bookオブジェクトが生成できること")
	void testConstructorNameHasGE2Chars() {
		String expected = "com.hakotrain.designpattern.iterator.Book";
		
		String name = "吾輩は猫である";
		Book book = new Book(name);
		String actual = book.getClass().getName();
		
		assertEquals(expected, actual);
	}

	// （参考）正常系　name()　設定した１文字の名前を取り出せること
	@Test
	@DisplayName("（参考）正常系　name()　設定した１文字の名前を取り出せること")
	void testNameHasEq1Chars() {
		String expected = "w";
		
		Book book = new Book(expected);
		String actual = book.name();
		
		assertEquals(expected, actual);
		
	}

	// （参考）正常系　name()　設定した２文字以上の名前を取り出せること
	@Test
	@DisplayName("（参考）正常系　name()　設定した２文字以上の名前を取り出せること")
	void testNameHasGE2Chars() {
		String expected = "吾輩は猫である";
		
		Book book = new Book(expected);
		String actual = book.name();
		
		assertEquals(expected, actual);
		
	}

	// （参考）異常系　コンストラクタ　引数(name)に空文字列を設定すると例外が発生する
	@Test
	@DisplayName("（参考）異常系　コンストラクタ　引数(name)に空文字列を設定すると例外が発生する")
	void testConstractorNameHasNoChar() {
		// 例外が発生することを確認する
		Throwable e = assertThrows(IllegalArgumentException.class, () ->{new Book("");});
		
		// 例外オブジェクトに格納したmessageを確認する
		String expected = "Bookの名前(name)に「」は指定できません";
		String actual = e.getMessage();
		assertEquals(expected, actual);
	}
	
	// （参考）異常系　コンストラクタ　引数(name)にnullを設定すると例外が発生する
	@Test
	@DisplayName("（参考）異常系　コンストラクタ　引数(name)にnullを設定すると例外が発生する")
	void testConstractorNameIsNull() {
		// 例外が発生することを確認する
		Throwable e = assertThrows(IllegalArgumentException.class, () ->{new Book(null);});
		
		// 例外オブジェクトに格納したmessageを確認する
		String expected = "Bookの名前(name)に「null」は指定できません";
		String actual = e.getMessage();
		assertEquals(expected, actual);
	}

}
