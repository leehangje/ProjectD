package com.example.projectd.Dto;

import java.io.Serializable;

public class ReviewDto implements Serializable {
    String member_id, review_scope, review_content;

    public ReviewDto(){}

    public ReviewDto(String member_id, String review_scope, String review_content) {
        this.member_id = member_id;
        this.review_scope = review_scope;
        this.review_content = review_content;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getReview_scope() {
        return review_scope;
    }

    public void setReview_scope(String review_scope) {
        this.review_scope = review_scope;
    }

    public String getReview_content() {
        return review_content;
    }

    public void setReview_content(String review_content) {
        this.review_content = review_content;
    }
}
