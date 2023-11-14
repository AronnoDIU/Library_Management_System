import java.util.ArrayList;
import java.util.List;

class Library {
    private final List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void displayBooks() {
        System.out.println("Library Books:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                    ", Genre: " + book.getGenre() + ", Checked Out: " + (book.isCheckedOut() ? "Yes" : "No"));
        }
        System.out.println();
    }

    public Book findBook(String keyword) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(keyword) ||
                    book.getAuthor().equalsIgnoreCase(keyword) ||
                    book.getGenre().equalsIgnoreCase(keyword)) {
                return book;
            }
        }
        return null;
    }
}