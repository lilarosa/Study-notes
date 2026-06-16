package ihk.lagerverwaltung.model;

public class Customer {
    private final String customerId;
    private final String name;
    private final String email;

    public Customer(String customerId, String name, String email) {
        if (customerId == null || customerId.isBlank()) throw new IllegalArgumentException("customerId is required");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name is required");
        if (email == null || email.isBlank()) throw new IllegalArgumentException("email is required");
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}
