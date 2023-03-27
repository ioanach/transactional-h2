package com.example.h2test.model;

import org.springframework.data.annotation.Id;

public class Payment {

    private int id;
    private String brandName;
    private String reference;
    private Integer amount;

    private String status;

    public Payment(String brandName, String reference, Integer amount, String status) {
        this.brandName = brandName;
        this.reference = reference;
        this.amount = amount;
        this.status = status;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }
}
