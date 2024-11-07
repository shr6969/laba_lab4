package onlineStore;

import java.util.Objects;

public class Customer implements Comparable<Customer> {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phoneNumber;

    // Публічний конструктор без параметрів
    public Customer() {}


    public Customer(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Конструктор з параметрами для використання з Builder
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }

    @Override
    public String toString() {
        return "Customer:\n" +
                "  First Name: '" + firstName + "'\n" +
                "  Last Name: '" + lastName + "'\n" +
                "  Email: '" + email + "'\n" +
                "  Phone Number: '" + phoneNumber + "'";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        return firstName.equals(customer.firstName) &&
                lastName.equals(customer.lastName) &&
                email.equals(customer.email) &&
                phoneNumber.equals(customer.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phoneNumber);
    }

    @Override
    public int compareTo(Customer other) {
        return this.lastName.compareTo(other.lastName);
    }
}
