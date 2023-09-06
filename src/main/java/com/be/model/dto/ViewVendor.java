package com.be.model.dto;

import com.be.model.*;

import java.util.List;


public class ViewVendor {
    private int id;
    private double revenue;
    private int countHouse;
    private Account account;
    private List<Status> statuses;

    public ViewVendor() {
    }

    public ViewVendor(int id, double revenue, int countHouse, Account account, List<Status> statuses) {
        this.id = id;
        this.revenue = revenue;
        this.countHouse = countHouse;
        this.account = account;
        this.statuses = statuses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    public int getCountHouse() {
        return countHouse;
    }

    public void setCountHouse(int countHouse) {
        this.countHouse = countHouse;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }
}