package com.hakotrain.designpattern.iterator;

public class BookShelf implements Iterable<Book> {
	
	private Book[] books;
	private int maxSize;
	private int last;
	
	public BookShelf(int maxSize) {
		// BookShelfで管理できる本の数は、1以上であること
		if(maxSize < 1) {
			throw new IllegalArgumentException("BookShelfの引数(maxSize)に「" + maxSize + "」は指定できません");
		}
		
		books = new Book[maxSize];
		this.maxSize = maxSize;
		last = 0;
	}
	
	@Override
	public BookShelfIterator iterator() {
		return new BookShelfIterator(this);
	}
	
	public Book getBookAt(int index) {
		// 現在管理されている本のindex値は、0以上last以下であること
		if(index < 0 || index >= last) {
			throw new IllegalArgumentException("取り出す本を識別するindex値は、0以上" + last + "以下を指定してください" );
		}
		
		return books[index];
	}
	
	public void appendBook(Book book) {
		// 追加するBookオブジェクトは、nullでないこと
		if(book == null) {
			throw new IllegalArgumentException("Bookオブジェクトは、null以外を指定してください" );
		}
		
		// 管理する本の数が配列のサイズを超えないこと
		if(last >= books.length) {
			throw new IllegalStateException("本の数が上限を超えました" );
		}

		books[last] = book;
		last++;
	}
	
	public int getMaxSize() {
		return maxSize;
	}
	
	public int getLast() {
		return last;
	}

}
