package model;

import java.util.Objects;

public class Customer implements Cloneable{

    private String customerId;
    private String firstName;
    private String surName;
    private String address;

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public Customer(int customerId, String firstName, String surName, String address) {
        this.customerId = "Cs"+customerId;
        this.firstName = firstName;
        this.surName = surName;
        this.address = address;
    }

    @Override
    public Customer clone() throws CloneNotSupportedException {
        return (Customer)super.clone();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(firstName, customer.firstName) &&
                Objects.equals(surName, customer.surName) &&
                Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, surName, address);
    }

    @Override
    public String toString() {
        return String.format("%s:%s,%s,|%s|",customerId,surName,firstName,address);
    }


}
