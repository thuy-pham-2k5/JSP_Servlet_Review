package com.example.jsp_servlet_review.no_2;

public class ProductType {
    private int id_product;
    private String name;
    private double price;
    private int quantity;
    private int id_type;
    private int name_type;

    public ProductType(int id_product, String name, double price, int quantity, int id_type, int name_type) { // show list/info product
        this.id_product = id_product;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id_type = id_type;
        this.name_type = name_type;
    }

    public ProductType(int id_type, int name_type) { // show list type when add new product, update info
        this.id_type = id_type;
        this.name_type = name_type;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id_product=" + id_product +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", id_type=" + id_type +
                ", name_type=" + name_type +
                '}';
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public int getName_type() {
        return name_type;
    }

    public void setName_type(int name_type) {
        this.name_type = name_type;
    }
}
