import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("Library Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Check Out Book");
            System.out.println("5. Check In Book");
            System.out.println("6. Search Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = userInput.nextInt();
            userInput.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = userInput.nextLine();
                    System.out.print("Enter author: ");
                    String author = userInput.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = userInput.nextLine();

                    // Create a new Book object
                    Book newBook = new Book(title, author, genre);
                    library.addBook(newBook); // Add the new book to the library

                    System.out.println("Book added successfully.\n");
                    break;

                case 2:
                    library.displayBooks(); // Display the list of books

                    System.out.print("Enter the title of the book to remove: ");
                    String removeTitle = userInput.nextLine();

                    // Remove the book from the library
                    Book bookToRemove = library.findBook(removeTitle);

                    // Check if the book was found
                    if (bookToRemove != null) {

                        // Remove the book from the library
                        library.removeBook(bookToRemove);

                        System.out.println("Book removed successfully.\n");
                    } else {
                        System.out.println("Book not found.\n");
                    }
                    break;

                case 3:
                    library.displayBooks(); // Display the list of books
                    break;

                case 4:
                    library.displayBooks();

                    System.out.print("Enter the title of the book to check out: ");
                    String checkOutTitle = userInput.nextLine();

                    // Check out the book from the library
                    Book bookToCheckOut = library.findBook(checkOutTitle);

                    // Check if the book was found
                    if (bookToCheckOut != null) {

                        // Check out the book from the library
                        if (!bookToCheckOut.isCheckedOut()) {

                            // Check out the book
                            bookToCheckOut.checkOut();

                            System.out.println("Book checked out successfully.\n");
                        } else {
                            System.out.println("Book is already checked out.\n");
                        }
                    } else {
                        System.out.println("Book not found.\n");
                    }
                    break;

                case 5:
                    library.displayBooks();

                    System.out.print("Enter the title of the book to check in: ");
                    String checkInTitle = userInput.nextLine();

                    Book bookToCheckIn = library.findBook(checkInTitle);

                    // Check if the book was found
                    if (bookToCheckIn != null) {

                        // Check in the book
                        if (bookToCheckIn.isCheckedOut()) {

                            // Check in the book from the library
                            bookToCheckIn.checkIn();

                            System.out.println("Book checked in successfully.\n");
                        } else {
                            System.out.println("Book is not checked out.\n");
                        }
                    } else {
                        System.out.println("Book not found.\n");
                    }
                    break;

                case 6:
                    System.out.print("Enter search keyword (title/author/genre): ");
                    String searchKeyword = userInput.nextLine();

                    // Search for the book
                    Book foundBook = library.findBook(searchKeyword);

                    // Check if the book was found
                    if (foundBook != null) {
                        System.out.println("Book found:");
                        System.out.println("Title: " + foundBook.getTitle() + ", Author: " + foundBook.getAuthor() +
                                ", Genre: " + foundBook.getGenre() + ", Checked Out: " + (foundBook.isCheckedOut() ? "Yes" : "No") + "\n");
                    } else {
                        System.out.println("Book not found.\n");
                    }
                    break;

                case 7:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.\n");
                    break;
            }
        }
    }
}
