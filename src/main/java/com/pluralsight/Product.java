package com.pluralsight;

public class Product {
    private String productName;
    private double price;
    private String department;

    public Product(String productName, double price, String department) {
        this.productName = productName;
        this.price = price;
        this.department = department;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("productName='").append(productName).append('\'');
        sb.append(", price=").append(price);
        sb.append(", department='").append(department).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
