package com.max.model;


import java.io.InputStream;

public class Book {

    private Long id;
    private String name;
    private int pages;
    private int yearOfPublication;
    private long authorId;
    private long publisherId;
    private double price;
    private String description;
    private InputStream image;
    private String imageBase64;
    private Long createdBy;

    public Book() {
    }

    public Book(Long id, String name, int pages, double price, int yearOfPublication, String description) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.yearOfPublication = yearOfPublication;
        this.price = price;
        this.description = description;
    }

    public Book(Long id, String name, int pages, int yearOfPublication, long authorId, long publisherId, double price, String description) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.yearOfPublication = yearOfPublication;
        this.authorId = authorId;
        this.publisherId = publisherId;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
}
