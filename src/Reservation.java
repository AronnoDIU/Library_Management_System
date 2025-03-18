class Reservation {
    private final String userId;
    private final String bookTitle;
    private final String reservationDate;

    public Reservation(String userId, String bookTitle, String reservationDate) {
        this.userId = userId;
        this.bookTitle = bookTitle;
        this.reservationDate = reservationDate;
    }

    public String getUserId() {
        return userId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getReservationDate() {
        return reservationDate;
    }
}
