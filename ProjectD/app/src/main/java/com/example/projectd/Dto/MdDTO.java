package com.example.projectd.Dto;

import java.io.Serializable;

public class MdDTO implements Serializable {
    String md_name;
    String md_category;
    int md_price;
    String md_rental_term;
    int md_deposit;
    String md_detail_content;
    String md_photo_url;
    String member_id;
    String member_addr;
    int md_fav_count;
    String md_registration_date;
    String md_serial_number;
    int md_rent_status;
    int md_hits;

    public MdDTO(String md_name, String md_category, int md_price, String md_rental_term,
                 int md_deposit, String md_detail_content, String md_photo_url, String member_id,
                 String member_addr, int md_fav_count, String md_registration_date,
                 String md_serial_number, int md_rent_status, int md_hits) {
        this.md_name = md_name;
        this.md_category = md_category;
        this.md_price = md_price;
        this.md_rental_term = md_rental_term;
        this.md_deposit = md_deposit;
        this.md_detail_content = md_detail_content;
        this.md_photo_url = md_photo_url;
        this.member_id = member_id;
        this.member_addr = member_addr;
        this.md_fav_count = md_fav_count;
        this.md_registration_date = md_registration_date;
        this.md_serial_number = md_serial_number;
        this.md_rent_status = md_rent_status;
        this.md_hits = md_hits;
    }

    public String getMd_name() {
        return md_name;
    }

    public void setMd_name(String md_name) {
        this.md_name = md_name;
    }

    public String getMd_category() {
        return md_category;
    }

    public void setMd_category(String md_category) {
        this.md_category = md_category;
    }

    public int getMd_price() {
        return md_price;
    }

    public void setMd_price(int md_price) {
        this.md_price = md_price;
    }

    public String getMd_rental_term() {
        return md_rental_term;
    }

    public void setMd_rental_term(String md_rental_term) {
        this.md_rental_term = md_rental_term;
    }

    public int getMd_deposit() {
        return md_deposit;
    }

    public void setMd_deposit(int md_deposit) {
        this.md_deposit = md_deposit;
    }

    public String getMd_detail_content() {
        return md_detail_content;
    }

    public void setMd_detail_content(String md_detail_content) {
        this.md_detail_content = md_detail_content;
    }

    public String getMd_photo_url() {
        return md_photo_url;
    }

    public void setMd_photo_url(String md_photo_url) {
        this.md_photo_url = md_photo_url;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_addr() {
        return member_addr;
    }

    public void setMember_addr(String member_addr) {
        this.member_addr = member_addr;
    }

    public int getMd_fav_count() {
        return md_fav_count;
    }

    public void setMd_fav_count(int md_fav_count) {
        this.md_fav_count = md_fav_count;
    }

    public String getMd_registration_date() {
        return md_registration_date;
    }

    public void setMd_registration_date(String md_registration_date) {
        this.md_registration_date = md_registration_date;
    }

    public String getMd_serial_number() {
        return md_serial_number;
    }

    public void setMd_serial_number(String md_serial_number) {
        this.md_serial_number = md_serial_number;
    }

    public int getMd_rent_status() {
        return md_rent_status;
    }

    public void setMd_rent_status(int md_rent_status) {
        this.md_rent_status = md_rent_status;
    }

    public int getMd_hits() {
        return md_hits;
    }

    public void setMd_hits(int md_hits) {
        this.md_hits = md_hits;
    }
}
