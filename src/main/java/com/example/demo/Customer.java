package com.example.demo;

public class Customer {
    private String customerName;
    private String phoneNumber;
    private String petType;
    private Pet2 pet;

    public Customer() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }
        public Pet2 getPet() {
        return pet;
    }

    public void setPet(Pet2 pet) {
        this.pet = pet;
    }
}
