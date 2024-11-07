package onlineStore;

import onlineStore.serializer.JsonSerializer;
import onlineStore.serializer.XmlSerializer;
import onlineStore.serializer.YamlSerializer;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("John", "Doe", "john.doe@example.com", "123-456-7890");
        Product product1 = new Product.Builder("Laptop", "A powerful gaming laptop", 1200.99, 10).build();
        Product product2 = new Product.Builder("Headphones", "Noise-cancelling headphones", 150.49, 5).build();

        Order order = new Order.Builder()
                .orderNumber("ORD12345")
                .customer(customer)
                .addProduct(product1)
                .addProduct(product2)
                .orderDate("2024-11-07")
                .build();

        // Створення файлів для виведення
        File jsonFile = new File("order.json");
        File xmlFile = new File("order.xml");
        File yamlFile = new File("order.yaml");

        // Використовуємо серіалізатори
        JsonSerializer<Order> jsonSerializer = new JsonSerializer<>();
        XmlSerializer<Order> xmlSerializer = new XmlSerializer<>();
        YamlSerializer<Order> yamlSerializer = new YamlSerializer<>();

        try {
            // Серіалізація в JSON і запис у файл
            String json = jsonSerializer.serialize(order);
            jsonSerializer.writeToFile(order, jsonFile);
            System.out.println("Serialized to JSON:\n" + json);

            // Серіалізація в XML і запис у файл
            String xml = xmlSerializer.serialize(order);
            xmlSerializer.writeToFile(order, xmlFile);
            System.out.println("Serialized to XML:\n" + xml);

            // Серіалізація в YAML і запис у файл
            String yaml = yamlSerializer.serialize(order);
            yamlSerializer.writeToFile(order, yamlFile);
            System.out.println("Serialized to YAML:\n" + yaml);

            // Десеріалізація з JSON
            Order deserializedOrderJson = jsonSerializer.readFromFile(jsonFile, Order.class);
            System.out.println("Deserialized from JSON:\n" + deserializedOrderJson);

            // Десеріалізація з XML
            Order deserializedOrderXml = xmlSerializer.readFromFile(xmlFile, Order.class);
            System.out.println("Deserialized from XML:\n" + deserializedOrderXml);

            // Десеріалізація з YAML
            Order deserializedOrderYaml = yamlSerializer.readFromFile(yamlFile, Order.class);
            System.out.println("Deserialized from YAML:\n" + deserializedOrderYaml);

        } catch (IOException e) {
            System.err.println("Error during serialization/deserialization: " + e.getMessage());
        }
    }
}
