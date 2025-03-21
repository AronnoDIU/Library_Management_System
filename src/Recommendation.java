class Recommendation {
    private final String userId;
    private final String bookTitle;
    private final String recommendationText;

    public Recommendation(String userId, String bookTitle, String recommendationText) {
        this.userId = userId;
        this.bookTitle = bookTitle;
        this.recommendationText = recommendationText;
    }

    public String getUserId() {
        return userId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getRecommendationText() {
        return recommendationText;
    }
}
