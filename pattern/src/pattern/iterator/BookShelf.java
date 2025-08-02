package pattern.iterator;

import java.util.Iterator;

public class BookShelf implements Iterable<Book> {
	
	private Book[] books;
	private int last;
	
	public BookShelf(int maxSize) {
		books = new Book[maxSize];
		last = 0;
	}
	
	@Override
	public Iterator<Book> iterator() {
		return new BookShelfIterator(this);
	}
	
	public Book getBookAt(int index) {
		if(index < 0 || index >= last) {
			throw new IllegalArgumentException("indexの値は、0以上" + last + "以下を指定してください。" );
		}
		
		return books[index];
	}
	
	public void appendBook(Book book) {
		books[last] = book;
		last++;
	}
	
	public int getLast() {
		return last;
	}

}
