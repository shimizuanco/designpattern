package pattern.iterator;

public class Main {
	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf(5);
		
		bookShelf.appendBook(new Book("吾輩は猫である"));
		bookShelf.appendBook(new Book("吾輩も猫である"));
		bookShelf.appendBook(new Book("吾輩は犬である"));
		bookShelf.appendBook(new Book("吾輩も犬である"));
		
		for(Book book : bookShelf) {
			String name = book.name();
			System.out.println("Book title : " + name);
		}
	}
}
