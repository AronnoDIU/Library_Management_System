import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Library {
    private final List<Book> books;
    private final Map<String, User> users;
    private final List<Reservation> reservations;
    private final List<Review> reviews;
    private final List<Rating> ratings;
    private final List<Recommendation> recommendations;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new HashMap<>();
        this.reservations = new ArrayList<>();
        this.reviews = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.recommendations = new ArrayList<>();
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

    // Getter for the list of books
    public List<Book> getBooks() {
        return books;
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public void removeUser(String userId) {
        users.remove(userId);
    }

    public User findUser(String userId) {
        return users.get(userId);
    }

    public void displayUsers() {
        System.out.println("Library Users:");
        for (User user : users.values()) {
            System.out.println("Name: " + user.getName() + ", User ID: " + user.getUserId());
        }
        System.out.println();
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void displayReservations() {
        System.out.println("Library Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println("User ID: " + reservation.getUserId() + ", Book Title: " + reservation.getBookTitle() +
                    ", Reservation Date: " + reservation.getReservationDate());
        }
        System.out.println();
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void removeReview(Review review) {
        reviews.remove(review);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void displayReviews() {
        System.out.println("Library Reviews:");
        for (Review review : reviews) {
            System.out.println("User ID: " + review.getUserId() + ", Book Title: " + review.getBookTitle() +
                    ", Review: " + review.getReviewText() + ", Rating: " + review.getRating());
        }
        System.out.println();
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    public void removeRating(Rating rating) {
        ratings.remove(rating);
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void displayRatings() {
        System.out.println("Library Ratings:");
        for (Rating rating : ratings) {
            System.out.println("User ID: " + rating.getUserId() + ", Book Title: " + rating.getBookTitle() +
                    ", Rating: " + rating.getRating());
        }
        System.out.println();
    }

    public void addRecommendation(Recommendation recommendation) {
        recommendations.add(recommendation);
    }

    public void removeRecommendation(Recommendation recommendation) {
        recommendations.remove(recommendation);
    }

    public List<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void displayRecommendations() {
        System.out.println("Library Recommendations:");
        for (Recommendation recommendation : recommendations) {
            System.out.println("User ID: " + recommendation.getUserId() + ", Book Title: " + recommendation.getBookTitle() +
                    ", Recommendation: " + recommendation.getRecommendationText());
        }
        System.out.println();
    }
}