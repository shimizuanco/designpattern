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
	
	// 異常系　コンストラクタ　引数(maxSize)に仕様外の値（null,空文字列）を設定すると例外が発生する
	@ParameterizedTest
	@ValueSource(ints = {-1, 0})
	void test020_ConstractorAbnomal(int candidate) {
		// 例外が発生することを確認する
		Throwable e = assertThrows(IllegalArgumentException.class, () ->{new BookShelf(candidate);});
		
		// 例外オブジェクトに格納したmessageを確認する
		String expected = "BookShelfの引数(maxSize)に「" + candidate + "」は指定できません";
		String actual = e.getMessage();
		assertEquals(expected, actual);
	}


	// 正常系　getLast()　BookShelfオブジェクトを生成した直後は、maxSizeに依らず、0が返されること
	@ParameterizedTest
	@ValueSource(ints = { 1, 5 })
	void test110_GetLastInitialNormal(int candidate) {
		BookShelf bookShelf = new BookShelf(candidate);

		// getLast() : BookShelf生成時は、lastは0になっていること
		assertEquals(0, bookShelf.getLast());
	}

	// 正常系　getLast()　BookShelfオブジェクトに格納されたBook数が得られること
	@ParameterizedTest
	@ValueSource(ints = { 1, 5 })
	void test111_getLastNormal(int candidate) {
		BookShelf bookShelf = new BookShelf(candidate);
		int maxSize = bookShelf.getMaxSize();

		// BookShelfオブジェクトにBookオブジェクトを追加する
		for (int i = 0; i < maxSize; i++) {
			bookShelf.appendBook(new Book(String.valueOf(i)));
		}
		
		// BookShelfオブジェクトに格納可能な数のBookオブジェクトが追加されていること
		assertEquals(candidate, bookShelf.getLast());
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
	void test310_appendBookNormal(int candidate) {
		BookShelf bookShelf = new BookShelf(candidate);
		int maxSize = bookShelf.getMaxSize();

		// appendBook() : BookShelfオブジェクトにBookオブジェクトを追加できること
		for (int i = 0; i < maxSize; i++) {
			bookShelf.appendBook(new Book(String.valueOf(i)));
		}

		// BookShelfに格納可能なすべてを追加できたことを確認する
		assertEquals(candidate, bookShelf.getLast());
	}

	// 異常系　appendBook()　BookShelfオブジェクトにBookを最大数を超えて格納すると例外が発生すること
	@ParameterizedTest
	@ValueSource(ints = { 1, 5 })
	void test320_appendBookAbnormal(int candidate) {
		BookShelf bookShelf = new BookShelf(candidate);
		int maxSize = bookShelf.getMaxSize();

		// BookShelfオブジェクトにBookオブジェクトを追加する
		for (int i = 0; i < maxSize; i++) {
			bookShelf.appendBook(new Book(String.valueOf(i)));
		}
		
		// appendBook() : さらにBookオブジェクトを追加すると例外が発生すること
		assertThrows(IllegalStateException.class, () -> {
			bookShelf.appendBook(new Book(String.valueOf(candidate)));
		});
	}
	
	// 正常系　getBookAt()　指定したindex値のBookオブジェクトを取り出せること
	@ParameterizedTest
	@ValueSource(ints = { 1, 5 })
	void test410_getBookAtnormal(int candidate) {
		BookShelf bookShelf = new BookShelf(candidate);
		int maxSize = bookShelf.getMaxSize();

		// BookShelfオブジェクトにBookオブジェクトを追加する
		for (int i = 0; i < maxSize; i++) {
			bookShelf.appendBook(new Book(String.valueOf(i)));
		}

		// BookShelfオブジェクトからBookオブジェクトを取り出す
		for (int i = 0; i < bookShelf.getLast(); i++) {
			assertEquals(i, Integer.parseInt(bookShelf.getBookAt(i).name()));
		}
	}

	// 異常系　getBookAt()　引数値が0または格納したBookオブジェクト数以上では、例外が発生すること
	@ParameterizedTest
	@ValueSource(ints = { 1, 5 })
	void test420_getBookAtAbnormal(int candidate) {
		BookShelf bookShelf = new BookShelf(candidate);

		// BookShelfオブジェクトにBookオブジェクトを追加する
		for (int i = 0; i < candidate; i++) {
			bookShelf.appendBook(new Book(String.valueOf(i)));
		}
		
		// 例外が発生すること
		assertThrows(IllegalStateException.class, () -> {
			
			bookShelf.appendBook(new Book(String.valueOf(candidate)));
		});
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
