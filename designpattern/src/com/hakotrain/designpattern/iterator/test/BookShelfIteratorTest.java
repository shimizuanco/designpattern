package com.hakotrain.designpattern.iterator.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.hakotrain.designpattern.iterator.Book;
import com.hakotrain.designpattern.iterator.BookShelf;
import com.hakotrain.designpattern.iterator.BookShelfIterator;

@TestMethodOrder(MethodOrderer.MethodName.class)
class BookShelfIteratorTest {
	// 正常系　コンストラクタ　BookShelfIteratorオブジェクトを取得できること
	@ParameterizedTest
	@ValueSource(ints = { 1, 5 })
	void test110_ConstructorNormal(int candidate) {
		BookShelf bookShelf = new BookShelf(candidate);

		// Iteratorオブジェクトを生成できること
		Iterator<Book> ite = new BookShelfIterator(bookShelf);
		assertNotNull(ite);

		// Iteartorオブジェクトのデータ型が正しいこと
		String expected = "com.hakotrain.designpattern.iterator.BookShelfIterator";
		assertEquals(expected, ite.getClass().getName());
	}
	
	// 異常系　コンストラクタ　引数で渡されたBookShelfオブジェクトがnullの場合、例外が発生すること
	void test020_ConstructorAbnormal() {
		// 例外が発生することを確認する
		Throwable e = assertThrows(IllegalArgumentException.class, () -> {
			new BookShelfIterator(null);
		});

		// 例外オブジェクトに格納したmessageを確認する
		String expected = "引数で渡されたBookShelfオブジェクトがnullです";
		String actual = e.getMessage();
		assertEquals(expected, actual);
	}

	// 正常系　getLast()　BookShelfオブジェクトに格納されたBook数が得られること
	@ParameterizedTest
	@ValueSource(ints = { 1, 5 })
	void test310_getLastNormal(int candidate) {
		BookShelf bookShelf = new BookShelf(candidate);
		int maxSize = bookShelf.getMaxSize();

		// BookShelfオブジェクトにBookオブジェクトを追加する
		for (int i = 0; i < maxSize; i++) {
			bookShelf.appendBook(new Book(String.valueOf(i)));
		}
		
		// BookShelfオブジェクトに格納可能な数のBookオブジェクトが追加されていること
		assertEquals(candidate, bookShelf.getLast());
	}
	
	// 正常系　hasNext(), next()　BookShelfオブジェクトからBookを取り出せること
	@ParameterizedTest
	@ValueSource(ints = { 1, 5 })
	void test410_nextNormal(int candidate) {
		BookShelf bookShelf = new BookShelf(candidate);
		int maxSize = bookShelf.getMaxSize();

		// BookShelfオブジェクトにBookオブジェクトを追加する
		for (int i = 0; i < maxSize; i++) {
			bookShelf.appendBook(new Book(String.valueOf(i)));
		}
	
		// hasNext() : Iteratorで次の要素を存否を確認できること
		// next() : IteratorでBookオブジェクトを取り出し、次の要素へ進められること
		Iterator<Book> ite = new BookShelfIterator(bookShelf);
		int index = 0;
		while (ite.hasNext()) {
			Book book = ite.next();
			assertEquals(index, Integer.parseInt(book.name()));
			index++;
		}

		// 拡張for文でBookオブジェクトを取り出せること
		index = 0;
		for (Book book : bookShelf) {
			assertEquals(index, Integer.parseInt(book.name()));
			index++;
		}
	}
	
	// 正常系　拡張for文でBookShelfオブジェクトからBookを取り出せること
	@ParameterizedTest
	@ValueSource(ints = { 1, 5 })
	void test411_nextNormal(int candidate) {
		BookShelf bookShelf = new BookShelf(candidate);
		int maxSize = bookShelf.getMaxSize();

		// BookShelfオブジェクトにBookオブジェクトを追加する
		for (int i = 0; i < maxSize; i++) {
			bookShelf.appendBook(new Book(String.valueOf(i)));
		}
	
		// 拡張for文でBookShelfオブジェクトからBookを取り出せること
		int index = 0;
		for (Book book : bookShelf) {
			assertEquals(index, Integer.parseInt(book.name()));
			index++;
		}

	}
}
