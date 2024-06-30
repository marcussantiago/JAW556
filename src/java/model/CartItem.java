package model;

import java.text.DecimalFormat;
import java.io.*;
import controller.Tbooks;

/**
 *
 * @author marcu
 */
public class CartItem implements Serializable {

    private Tbooks book;
    private int quantity = 0;
    private double costOfItem = 0.00;

    /**
     *
     * @param book
     */
    public CartItem(Tbooks book) {
        this.book = book;
    }

    /**
     *
     * @param aQuantity
     */
    public void setQuantity(int aQuantity) {
        quantity += aQuantity;
        calculateOrderCost();
    }

    /**
     *
     * @param newQuantity
     */
    public void updateQuantity(int newQuantity) {
        quantity = newQuantity;
        calculateOrderCost();
    }

    private void calculateOrderCost() {
        costOfItem = (quantity * book.getPrice());
    }

    /**
     *
     * @return
     */
    public String getDollarOrderCost() {
        DecimalFormat cost = new DecimalFormat("0.00");
        return ("$" + cost.format(this.costOfItem));
    }

    public String toString() {
        return (book + "          " + "quantity: " + quantity);
    }

    /**
     *
     * @return
     */
    public Tbooks getBook() {
        return book;
    }

    /**
     *
     * @return
     */
    public double getOrderCost() {
        return costOfItem;
    }

    /**
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

}
