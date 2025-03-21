import java.io.*;
import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library library = new Library();
        readLibraryFromFile(library); // Read library information from file

        Scanner userInput = new Scanner(System.in);

        while (true) {
            displayMenu(); // Display the menu and get the user's choice from the input stream

            int choice = getUserChoice(userInput); // Get the user's choice

            switch (choice) {
                case 1: // For Add book
                    addBook(userInput, library);
                    break;
                case 2: // For Remove book
                    removeBook(userInput, library);
                    break;
                case 3: // For Display book
                    library.displayBooks();
                    break;
                case 4: // For check out
                    checkOutBook(userInput, library);
                    break;
                case 5: // For check in
                    checkInBook(userInput, library);
                    break;
                case 6: // For search
                    searchBook(userInput, library);
                    break;
                case 7: // For add user
                    addUser(userInput, library);
                    break;
                case 8: // For remove user
                    removeUser(userInput, library);
                    break;
                case 9: // For display user
                    library.displayUsers();
                    break;
                case 10:  // For add reservation
                    addReservation(userInput, library);
                    break;
                case 11: // For remove reservation
                    removeReservation(userInput, library);
                    break;
                case 12: // For display reservation
                    library.displayReservations();
                    break;
                case 13: // For add review
                    addReview(userInput, library);
                    break;
                case 14: // For remove review
                    removeReview(userInput, library);
                    break;
                case 15: // For display review
                    library.displayReviews();
                    break;
                case 16: // For add rating
                    addRating(userInput, library);
                    break;
                case 17: // For remove rating
                    removeRating(userInput, library);
                    break;
                case 18: // For display rating
                    library.displayRatings();
                    break;
                case 19: // For add recommendation
                    addRecommendation(userInput, library);
                    break;
                case 20: // For remove recommendation
                    removeRecommendation(userInput, library);
                    break;
                case 21: // For display recommendation
                    library.displayRecommendations();
                    break;
                case 22: // For exit
                    saveLibraryToFile(library);
                    System.out.println("Exiting Library Management System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 14.\n");
                    break;
            }
        }
    }

    // Read library information from the file and add it to the library
    private static void displayMenu() {
        System.out.println("Library Management System Menu:");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Display Books");
        System.out.println("4. Check Out Book");
        System.out.println("5. Check In Book");
        System.out.println("6. Search Book");
        System.out.println("7. Add User");
        System.out.println("8. Remove User");
        System.out.println("9. Display Users");
        System.out.println("10. Add Reservation");
        System.out.println("11. Remove Reservation");
        System.out.println("12. Display Reservations");
        System.out.println("13. Add Review");
        System.out.println("14. Remove Review");
        System.out.println("15. Display Reviews");
        System.out.println("16. Add Rating");
        System.out.println("17. Remove Rating");
        System.out.println("18. Display Ratings");
        System.out.println("19. Add Recommendation");
        System.out.println("20. Remove Recommendation");
        System.out.println("21. Display Recommendations");
        System.out.println("22. Exit");
        System.out.print("Enter your choice: ");
    }

    // Get the user's choice from the input stream and return it
    private static int getUserChoice(Scanner userInput) {
        return userInput.nextInt();
    }

    // Add a new book to the library and display a success message
    private static void addBook(Scanner userInput, Library library) {
        userInput.nextLine(); // Consume the newline character after reading the choice
        System.out.print("Enter book title: ");
        String title = userInput.nextLine();
        System.out.print("Enter author: ");
        String author = userInput.nextLine();
        System.out.print("Enter genre: ");
        String genre = userInput.nextLine();

        // Add the new book to the library
        Book newBook = new Book(title, author, genre);
        library.addBook(newBook); // Add the new book to the list

        System.out.println("Book added successfully.\n");
    }

    // Remove a book from the library and display a success message
    private static void removeBook(Scanner userInput, Library library) {
        library.displayBooks(); // Display the list of books

        System.out.print("Enter the title of the book to remove: ");
        String removeTitle = userInput.nextLine();

        // Remove the book from the library
        Book bookToRemove = library.findBook(removeTitle);

        // Display a success message if the book was found
        if (bookToRemove != null) {
            library.removeBook(bookToRemove); // Remove the book from the list
            System.out.println("Book removed successfully.\n");
        } else {
            System.out.println("Book not found.\n");
        }
    }

    // Check out a book from the library and display a success message
    private static void checkOutBook(Scanner userInput, Library library) {
        userInput.nextLine(); // Consume the newline character after reading the choice
        library.displayBooks(); // Display the list of books

        System.out.print("Enter the title of the book to check out: ");
        String checkOutTitle = userInput.nextLine();

        // Check out the book from the library
        Book bookToCheckOut = library.findBook(checkOutTitle);

        // Display a success message if the book was found
        if (bookToCheckOut != null) {

            // Check if the book is already checked out
            if (!bookToCheckOut.isCheckedOut()) {
                bookToCheckOut.checkOut(); // Check out the book
                System.out.println("Book checked out successfully.\n");
            } else {
                System.out.println("Book is already checked out.\n");
            }
        } else {
            System.out.println("Book not found.\n");
        }
    }

    // Check in a book from the library and display a success message
    private static void checkInBook(Scanner userInput, Library library) {
        userInput.nextLine(); // Consume the newline character after reading the choice
        library.displayBooks(); // Display the list of books

        System.out.print("Enter the title of the book to check in: ");
        String checkInTitle = userInput.nextLine();

        // Check in the book from the library
        Book bookToCheckIn = library.findBook(checkInTitle);

        // Display a success message if the book was found
        if (bookToCheckIn != null) {

            // Check if the book is already checked out
            if (bookToCheckIn.isCheckedOut()) {
                bookToCheckIn.checkIn(); // Check in the book
                System.out.println("Book checked in successfully.\n");
            } else {
                System.out.println("Book is not checked out.\n");
            }
        } else {
            System.out.println("Book not found.\n");
        }
    }

    // Search for a book in the library and display the result
    private static void searchBook(Scanner userInput, Library library) {
        userInput.nextLine(); // Consume the newline character after reading the choice
        System.out.print("Enter search keyword (title/author/genre): ");
        String searchKeyword = userInput.nextLine();

        Book foundBook = library.findBook(searchKeyword); // Search for the book

        // Check if the book was found
        if (foundBook != null) {
            System.out.println("Book found:");
            System.out.println("Title: " + foundBook.getTitle() + ", Author: " +
                    foundBook.getAuthor() + ", Genre: " + foundBook.getGenre() +
                    ", Checked Out: " + (foundBook.isCheckedOut() ? "Yes" : "No") + "\n");
        } else {
            System.out.println("Book not found.\n");
        }
    }

    private static void addUser(Scanner userInput, Library library) {
        userInput.nextLine();
        System.out.print("Enter user name: ");
        String name = userInput.nextLine();
        System.out.print("Enter user ID: ");
        String userId = userInput.nextLine();

        User newUser = new User(name, userId);
        library.addUser(newUser);

        System.out.println("User added successfully.\n");
    }

    private static void removeUser(Scanner userInput, Library library) {
        userInput.nextLine();
        library.displayUsers();

        System.out.print("Enter the user ID to remove: ");
        String userId = userInput.nextLine();

        User userToRemove = library.findUser(userId);

        if (userToRemove != null) {
            library.removeUser(userId);
            System.out.println("User removed successfully.\n");
        } else {
            System.out.println("User not found.\n");
        }
    }

    private static void readLibraryFromFile(Library library) {

        // Read library information from the file
        try (BufferedReader reader = new BufferedReader(new FileReader("library.txt"))) {
            String line; // Read each line of the file

            // Split the line by commas and create a Book object for each line
            while ((line = reader.readLine()) != null) {
                Book book = getBook(line); // Create a Book object

                library.addBook(book); // Add the book to the library
            }
            System.out.println("Library information loaded from 'library.txt'.");
        } catch (IOException e) { // If an error occurs while reading the file
            System.out.println("Error reading library information from file. " +
                                                "Starting with an empty library.");
        }
    }

    // Create a Book object from the line read from the file
    private static Book getBook(String line) {
        String[] bookInfo = line.split(","); // Split the line by commas
        String title = bookInfo[0]; // Get the title, author, and genre
        String author = bookInfo[1];
        String genre = bookInfo[2];

        // Check if the book is checked out
        boolean checkedOut = Boolean.parseBoolean(bookInfo[3]);

        // Create a Book object
        Book book = new Book(title, author, genre);
        if (checkedOut) { // If the book is checked out
            book.checkOut(); // Check it out
        }
        return book; // Return the Book object
    }

    // Save library information to the file
    private static void saveLibraryToFile(Library library) {

        // Save library information to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("library.txt"))) {

            // Write each book in the library to the file
            for (Book book : library.getBooks()) {
                writer.write(book.getTitle() + "," + book.getAuthor()
                        + "," + book.getGenre() + "," + book.isCheckedOut());

                writer.newLine(); // Write a newline character after each book
            }
            System.out.println("Library information saved to 'library.txt'.");
        } catch (IOException e) { // If an error occurs while writing to the file
            System.out.println("Error saving library information to file.");
        }
    }

    private static void addReservation(Scanner userInput, Library library) {
        userInput.nextLine();
        System.out.print("Enter user ID: ");
        String userId = userInput.nextLine();
        System.out.print("Enter book title: ");
        String bookTitle = userInput.nextLine();
        System.out.print("Enter reservation date (YYYY-MM-DD): ");
        String reservationDate = userInput.nextLine();

        Reservation newReservation = new Reservation(userId, bookTitle, reservationDate);
        library.addReservation(newReservation);

        System.out.println("Reservation added successfully.\n");
    }

    private static void removeReservation(Scanner userInput, Library library) {
        library.displayReservations();

        System.out.print("Enter the user ID of the reservation to remove: ");
        String userId = userInput.nextLine();
        System.out.print("Enter the book title of the reservation to remove: ");
        String bookTitle = userInput.nextLine();

        Reservation reservationToRemove = null;
        for (Reservation reservation : library.getReservations()) {
            if (reservation.getUserId().equals(userId) && reservation.getBookTitle().equals(bookTitle)) {
                reservationToRemove = reservation;
                break;
            }
        }

        if (reservationToRemove != null) {
            library.removeReservation(reservationToRemove);
            System.out.println("Reservation removed successfully.\n");
        } else {
            System.out.println("Reservation not found.\n");
        }
    }

    private static void addReview(Scanner userInput, Library library) {
        userInput.nextLine();
        System.out.print("Enter user ID: ");
        String userId = userInput.nextLine();
        System.out.print("Enter book title: ");
        String bookTitle = userInput.nextLine();
        System.out.print("Enter review text: ");
        String reviewText = userInput.nextLine();
        System.out.print("Enter rating (1-5): ");
        int rating = userInput.nextInt();

        Review newReview = new Review(userId, bookTitle, reviewText, rating);
        library.addReview(newReview);

        System.out.println("Review added successfully.\n");
    }

    private static void removeReview(Scanner userInput, Library library) {
        library.displayReviews();

        System.out.print("Enter the user ID of the review to remove: ");
        String userId = userInput.nextLine();
        System.out.print("Enter the book title of the review to remove: ");
        String bookTitle = userInput.nextLine();

        Review reviewToRemove = null;
        for (Review review : library.getReviews()) {
            if (review.getUserId().equals(userId) && review.getBookTitle().equals(bookTitle)) {
                reviewToRemove = review;
                break;
            }
        }

        if (reviewToRemove != null) {
            library.removeReview(reviewToRemove);
            System.out.println("Review removed successfully.\n");
        } else {
            System.out.println("Review not found.\n");
        }
    }

    private static void addRating(Scanner userInput, Library library) {
        userInput.nextLine();
        System.out.print("Enter user ID: ");
        String userId = userInput.nextLine();
        System.out.print("Enter book title: ");
        String bookTitle = userInput.nextLine();
        System.out.print("Enter rating (1-5): ");
        int rating = userInput.nextInt();

        Rating newRating = new Rating(userId, bookTitle, rating);
        library.addRating(newRating);

        System.out.println("Rating added successfully.\n");
    }

    private static void removeRating(Scanner userInput, Library library) {
        library.displayRatings();

        System.out.print("Enter the user ID of the rating to remove: ");
        String userId = userInput.nextLine();
        System.out.print("Enter the book title of the rating to remove: ");
        String bookTitle = userInput.nextLine();

        Rating ratingToRemove = null;
        for (Rating rating : library.getRatings()) {
            if (rating.getUserId().equals(userId) && rating.getBookTitle().equals(bookTitle)) {
                ratingToRemove = rating;
                break;
            }
        }

        if (ratingToRemove != null) {
            library.removeRating(ratingToRemove);
            System.out.println("Rating removed successfully.\n");
        } else {
            System.out.println("Rating not found.\n");
        }
    }

    private static void addRecommendation(Scanner userInput, Library library) {
        userInput.nextLine();
        System.out.print("Enter user ID: ");
        String userId = userInput.nextLine();
        System.out.print("Enter book title: ");
        String bookTitle = userInput.nextLine();
        System.out.print("Enter recommendation text: ");
        String recommendationText = userInput.nextLine();

        Recommendation newRecommendation = new Recommendation(userId, bookTitle, recommendationText);
        library.addRecommendation(newRecommendation);

        System.out.println("Recommendation added successfully.\n");
    }

    private static void removeRecommendation(Scanner userInput, Library library) {
        library.displayRecommendations();

        System.out.print("Enter the user ID of the recommendation to remove: ");
        String userId = userInput.nextLine();
        System.out.print("Enter the book title of the recommendation to remove: ");
        String bookTitle = userInput.nextLine();

        Recommendation recommendationToRemove = null;
        for (Recommendation recommendation : library.getRecommendations()) {
            if (recommendation.getUserId().equals(userId) && recommendation.getBookTitle().equals(bookTitle)) {
                recommendationToRemove = recommendation;
                break;
            }
        }

        if (recommendationToRemove != null) {
            library.removeRecommendation(recommendationToRemove);
            System.out.println("Recommendation removed successfully.\n");
        } else {
            System.out.println("Recommendation not found.\n");
        }
    }
}
