import java.util.ArrayList;
import java.util.List;

class Library {
    private final List<Book> books; // List of books in the library

    public Library() {
        this.books = new ArrayList<>(); // Initialize the list of books in the library
    }

    public void addBook(Book book) {
        books.add(book); // Add the new book to the list
    }

    public void removeBook(Book book) {
        books.remove(book); // Remove the book from the list
    }

    // Display the list of books in the library
    public void displayBooks() {
        System.out.println("Library Books:");

        // Iterate through the list of books and print their details
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                    ", Genre: " + book.getGenre() + ", Checked Out: " + (book.isCheckedOut() ? "Yes" : "No"));
        }
        System.out.println();
    }

    // Find a book in the library by title, author, or genre
    public Book findBook(String keyword) {

        // Iterate through the list of books and search for the keyword
        for (Book book : books) {

            // Check if the book was found
            if (book.getTitle().equalsIgnoreCase(keyword) ||
                    book.getAuthor().equalsIgnoreCase(keyword) ||
                        book.getGenre().equalsIgnoreCase(keyword)) {

                return book;
            }
        }
        return null; // Return null if the book was not found
    }
}