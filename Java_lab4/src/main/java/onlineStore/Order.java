package onlineStore;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderNumber;
    private Customer customer;
    private List<Product> products = new ArrayList<>();
    private double totalAmount;
    private String orderDate;

    public Order() {
        products = new ArrayList<>();
    }

    // Конструктор через Builder
    public static class Builder {
        private String orderNumber;
        private Customer customer;
        private List<Product> products = new ArrayList<>();
        private double totalAmount;
        private String orderDate;

        public Builder() {
        }

        // Метод для додавання продуктів
        public Builder addProduct(Product product) {
            if (product == null) {
                throw new IllegalArgumentException("Product cannot be null");
            }
            products.add(product);
            return this;
        }

        public Builder orderNumber(String orderNumber) {
            if (orderNumber == null || orderNumber.isEmpty()) {
                throw new IllegalArgumentException("Order number cannot be null or empty");
            }
            this.orderNumber = orderNumber;
            return this;
        }

        public Builder customer(Customer customer) {
            if (customer == null) {
                throw new IllegalArgumentException("Customer cannot be null");
            }
            this.customer = customer;
            return this;
        }

        public Builder orderDate(String orderDate) {
            if (orderDate == null || orderDate.isEmpty()) {
                throw new IllegalArgumentException("Order date cannot be null or empty");
            }
            this.orderDate = orderDate;
            return this;
        }

        public Order build() {
            if (products.isEmpty()) {
                throw new IllegalArgumentException("Order must have at least one product");
            }

            // Підрахунок загальної суми
            totalAmount = products.stream().mapToDouble(product -> product.getPrice()).sum();

            return new Order(orderNumber, customer, products, totalAmount, orderDate);
        }
    }

    // Конструктор з параметрами
    private Order(String orderNumber, Customer customer, List<Product> products, double totalAmount, String orderDate) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.products = products;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    // Геттери та сеттери для полів
    public String getOrderNumber() {
        return orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", customer=" + customer +
                ", products=" + products +
                ", totalAmount=" + totalAmount +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }
}
