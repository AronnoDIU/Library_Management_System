class Review {
    private final String userId;
    private final String bookTitle;
    private final String reviewText;
    private final int rating;

    public Review(String userId, String bookTitle, String reviewText, int rating) {
        this.userId = userId;
        this.bookTitle = bookTitle;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public String getUserId() {
        return userId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getReviewText() {
        return reviewText;
    }

    public int getRating() {
        return rating;
    }
}
