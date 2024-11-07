package onlineStore;

import java.util.Objects;

public class Product implements Comparable<Product> {
    private String name;
    private String description;
    private double price;
    private int stockQuantity;

    public Product() {}

    // Використовуємо Builder для ініціалізації
    public static class Builder {
        private String name;
        private String description;
        private double price;
        private int stockQuantity;

        private static final double MIN_PRICE = 0.01;
        private static final double MAX_PRICE = 10000.00;
        private static final int MIN_STOCK_QUANTITY = 1;
        private static final int MAX_STOCK_QUANTITY = 1000;

        public Builder(String name, String description, double price, int stockQuantity) {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Product name cannot be null or empty");
            }
            if (description == null || description.isEmpty()) {
                throw new IllegalArgumentException("Product description cannot be null or empty");
            }
            if (price < MIN_PRICE || price > MAX_PRICE) {
                throw new IllegalArgumentException("Price must be between " + MIN_PRICE + " and " + MAX_PRICE);
            }
            if (stockQuantity < MIN_STOCK_QUANTITY || stockQuantity > MAX_STOCK_QUANTITY) {
                throw new IllegalArgumentException("Stock quantity must be between " + MIN_STOCK_QUANTITY + " and " + MAX_STOCK_QUANTITY);
            }
            this.name = name;
            this.description = description;
            this.price = price;
            this.stockQuantity = stockQuantity;
        }

        public Product build() {
            return new Product(name, description, price, stockQuantity);
        }
    }

    // Конструктор з параметрами
    private Product(String name, String description, double price, int stockQuantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }


    // Геттери та сеттери
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getStockQuantity() {
        return stockQuantity;
    }
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                stockQuantity == product.stockQuantity &&
                name.equals(product.name) &&
                description.equals(product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price, stockQuantity);
    }

    @Override
    public int compareTo(Product o) {
        return Double.compare(this.price, o.price);
    }

}