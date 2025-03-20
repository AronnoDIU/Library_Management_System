class Rating {
    private final String userId;
    private final String bookTitle;
    private final int rating;

    public Rating(String userId, String bookTitle, int rating) {
        this.userId = userId;
        this.bookTitle = bookTitle;
        this.rating = rating;
    }

    public String getUserId() {
        return userId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getRating() {
        return rating;
    }
}
