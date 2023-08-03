package com.example.about_us.Model;

public class ListView {

    private int id;
    private String title;
    private String price;
    private String date;
    private String genre;
    private int image;

    public ListView(){

    }

    public ListView(int id, String title, String price, String date, String genre, int image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.date = date;
        this.genre = genre;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
