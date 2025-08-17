package com.hakotrain.designpattern.iterator;

import java.util.Iterator;

/**
 * 
 */
public class BookShelfIterator implements Iterator<Book> {
	private BookShelf bookShelf;
	private int index;
	
	public BookShelfIterator(BookShelf bookShelf) {
		if(bookShelf == null) {
			throw new IllegalArgumentException("引数で渡されたBookShelfオブジェクトがnullです");
		}
		
		this.bookShelf = bookShelf;
		index = 0;
	}
	
	@Override
	public Book next() {
		// 次のBookオブジェクトが存在すること
		if(!hasNext()) {
			throw new IllegalStateException("次のBookオブジェクトは存在しません");
		}
		
		return bookShelf.getBookAt(index++);
	}
	
	@Override
	public boolean hasNext() {
		boolean res = false;
		if(index >= 0 && index < bookShelf.getLast()) {
			res = true;
		}
		return res;
	}
	
}
