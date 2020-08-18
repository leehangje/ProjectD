package com.example.projectd;

public class Review {
    String reviewer;
    String review_text;

    public Review(String reviewer, String review_text) {
        this.reviewer = reviewer;
        this.review_text = review_text;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }
}

