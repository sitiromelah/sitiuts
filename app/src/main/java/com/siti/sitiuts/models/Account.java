package com.siti.sitiuts.models;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String name;
    private String balance;
    private List<Order> orders;

    public Account(String name) {
        this.name = name;
        this.balance = getBalance();
        this.orders = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBalance() {
        return balance;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public void addOrder(Order order) {

        this.orders.add(order);
    }
    public void removeOrder(int index) {
        Order order = orders.get(index);
        this.orders.remove(order);
    }

    public void updateOrder(int index, Order order) {
        this.orders.set(index, order);
    }
}

