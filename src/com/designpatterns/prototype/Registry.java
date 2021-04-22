package com.designpatterns.prototype;

import java.util.HashMap;

public class Registry {
    private HashMap<String, Item> items = new HashMap<>();

    public Registry () {
        // load items is just populates the object
        loadItems();
    }

    public Item createItem(String type) {
        Item i = null;
        try {
            i = (Item) items.get(type).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return i;
    }

    private void loadItems() {
        // think of cases where you are building heavy in memory objects.
        Movie m = new Movie();
        m.setRuntime("2 hours");
        m.setTitle("The Great Gatsby");
        m.setPrice(24.99);

        items.put("movie", m);

        // new book
        Book b = new Book();
        b.setPrice(23.99);
        b.setTitle("Rational Optimist");
        b.setNumberOfPages(350);

        items.put("book", b);
    }

}
