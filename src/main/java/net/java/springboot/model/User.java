package net.java.springboot.model;

/**
 * Data Transfer Object representing a User for Kafka message payloads.
 * This POJO is serialized to JSON before being sent to the Kafka broker.
 */
public class User {
    private int id;
    private String firstName;
    private String lastName;

    // Standard getters and setters used by Jackson for JSON (de)serialization.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
