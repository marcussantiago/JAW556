package model;

import java.text.DecimalFormat;
import java.io.*;

/**
 *
 * @author marcu
 */
public class Book1 implements Serializable {

    String isbn = "";
    String title = "";
    String author = "";
    double price = 0.00;

    /**
     *
     * @return
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    public String toString() {
        return ("Title: " + title + "  ISBN: " + isbn + " Author: " + author + " Price: " + price);
    }

    /**
     *
     * @return
     */
    public String getDollarPrice() {
        DecimalFormat price = new DecimalFormat("0.00");
        return ("$" + price.format(this.price));
    }

    /**
     *
     * @param isbn
     * @param title
     * @param author
     * @param price
     */
    public Book1(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.price = price;
    }
}
