package com.designpatterns.prototype;

public class Book extends Item {
    private int numberOfPages;

    public int getNumberOfPages() {
        return this.numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" + "\n" +
                "Title=" + getTitle() + "\n" +
                "numberOfPages=" + numberOfPages +  "\n" +
                "Price=" + getPrice() + "\n" +
                '}';
    }
}
