/**
 * 
 */
package com.hakotrain.designpattern.iterator.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.hakotrain.designpattern.iterator.Book;
import com.hakotrain.designpattern.iterator.BookShelf;

/**
 * 
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
class BookShelfTest {

	// 正常系　コンストラクタ　引数(maxSize)に1以上を設定し、BookShelfオブジェクトが生成できること
	@ParameterizedTest
	@ValueSource(ints = { 1, 5 })
	void test010_ConstructorNormal(int candidate) {
		// BookShelfオブジェクトが生成されること
		BookShelf bookShelf = new BookShelf(candidate);
		assertNotNull(bookShelf);

		// BookShelfオブジェクトのデータ型が正しいこと
		String expected = "com.hakotrain.designpattern.iterator.BookShelf";
		assertEquals(expected, bookShelf.getClass().getName());
	}


	// 正常系　getLast()　BookShelfオブジェクトを生成した直後は、maxSizeに依らず、0が返されること
	@ParameterizedTest
	@ValueSource(ints = { 1, 5 })
	void test110_GetLastInitialNormal(int candidate) {
		BookShelf bookShelf = new BookShelf(candidate);

		// getLast() : BookShelf生成時は、lastは0になっていること
		assertEquals(0, bookShelf.getLast());
	}

	// 正常系　getMaxSize()　BookShelfオブジェクトのmaxSizeを正しく取得できること
	@ParameterizedTest
	@ValueSource(ints = { 1, 5 })
	void test210_getMaxSizeNormal(int expected) {
		BookShelf bookShelf = new BookShelf(expected);

		// getMaxSize() : Bookオブジェクトを格納できる数は expected と一致すること
		assertEquals(expected, bookShelf.getMaxSize());
	}

	// 正常系　appendBook()　BookShelfオブジェクトにBookを最大数まで格納できること
	@ParameterizedTest
	@ValueSource(ints = { 1, 5 })
	void test210_appendBookNormal(int candidate) {
		BookShelf bookShelf = new BookShelf(candidate);
		int maxSize = bookShelf.getMaxSize();

		// appendBook() : BookShelfオブジェクトにBookオブジェクトを追加できること
		for (int i = 0; i < maxSize; i++) {
			bookShelf.appendBook(new Book(String.valueOf(i)));
		}

		// BookShelfに格納可能なすべてを追加できたことを確認する
		assertEquals(candidate, bookShelf.getLast());
	}


	// CsvSource

	// （参考）正常系　コンストラクタ　引数(maxSize)に1以上を設定し、BookShelfオブジェクトが生成できること
	@ParameterizedTest
	@CsvSource({ "1", "5" })
	void testConstructorNormalTest2(int candidate) {
		String expected = "com.hakotrain.designpattern.iterator.BookShelf";

		BookShelf bookShelf = new BookShelf(candidate);
		String actual = bookShelf.getClass().getName();

		assertEquals(expected, actual);
	}

}
