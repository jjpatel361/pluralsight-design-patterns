package com.designpatterns.bridge;

public class BridgeDemo {

    public static void main(String[] args) {

        /*
        * Bridge is a structural pattern
        *
        * say you want to create communication between two objects where both the objects
        * will change over time. Note: this is different than Adapter pattern where one of the
        * object has strong dependency / non variant one.
        * allows us to be flexible without breaking things
        *
        * e.g. Drivers JDBC
        * we interact with the underlying database with JDBC as our bridge.
        * our code can change and so the underlying database query handling
        * but the bridge allows smooth communication over all changes
        *
        * E.g. say we want to print Movie object there are three players on scene
        * Movie - Object A
        * Printer - Object B
        * Bridge - MoviePrinter / Formatter
        *
        * Easy way
        * MoviePrinter printer = new MoviePrinter();
        * String printedContent = printer.print(movie);
        *
        * change 1 : need to print/output movie to a web page so now we need WebPrinter
        * change 2 : We want to print music release as well. so now we have new object Music
        *
        * to accommodate these 2 changes you end up creating
        * MoviePrinter/WebPrinter that takes in movie object and music object.
        *
        * */
        Music m = new Music("Drake", "Sony Music", "2020/06/25");

        ItemFormatter printFormatter = new PrintFormatter();
        Printer musicPrinter = new MusicPrinter(m);
        String formattedString = musicPrinter.print(printFormatter);

        // lets try to print html instead
        ItemFormatter htmlFormatter = new HtmlFormatter();
        String htmlFormattedString = musicPrinter.print(htmlFormatter);

        System.out.println(formattedString);
        System.out.println(htmlFormattedString);

    }

}
