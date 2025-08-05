/**
 * 
 */
package pattern.iterator;

import java.util.Iterator;

/**
 * 
 */
public class BookShelfIterator implements Iterator<Book> {
	private BookShelf bookShelf;
	private int index;
	
	public BookShelfIterator(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
		index = 0;
	}
	
	@Override
	public Book next() {
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
