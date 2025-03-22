import java.util.ArrayList;
import java.util.List;

class Book {
    private final String title; // Title of the book
    private final String author; // Author of the book
    private final String genre; // Genre of the book
    private boolean checkedOut; // Whether the book is checked out
    private final List<Reservation> reservations;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.checkedOut = false;
        this.reservations = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void checkIn() {
        checkedOut = false;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
