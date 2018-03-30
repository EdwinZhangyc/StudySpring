package com.spring.two.chapterEight.SpringWebFlow;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 程序清单8.2 Order带有披萨订单的所有细节信息
 */
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    private Customer customer;
    private List<Pizza> pizzas;
    private Payment payment;

    public Order() {
        pizzas = new ArrayList<Pizza>();
        customer = new Customer();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}