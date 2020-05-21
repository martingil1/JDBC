package org.example.models;

import javafx.util.Builder;

public class Product {

    private Integer id;
    private String name;
    private Double price;
    private String brand;
    private Integer unit;
    private Integer quantity;
    private Double discount;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getUnit() {
        return unit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getDiscount() {
        return discount;
    }

    public static class Builder {

        private String name;
        private Double price;
        private String brand;
        private Integer unit;
        private Integer quantity;
        private Double discount;



        public Builder name(String n) {
            this.name = n;
            return this;
        }

        public Builder brand(String b){
            this.brand = b;
            return this;
        }

        public Builder price(Double p) {
            this.price = p;
            return this;
        }

        public Builder unit(Integer u) {
            this.unit = u;
            return this;
        }

        public Builder quantity(Integer q) {
            this.quantity = q;
            return this;
        }

        public Builder discount(Double d) {
            this.discount = d;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    private Product (Builder b) {
        this.name = b.name;
        this.brand = b.brand;
        this.price = b.price;
        this.unit = b.unit;
        this.quantity = b.quantity;
        this.discount = b.discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", unit=" + unit +
                ", quantity=" + quantity +
                ", discount=" + discount +
                '}';
    }
}
