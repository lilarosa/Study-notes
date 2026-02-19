package ihk.lagerverwaltung.model;

public class Product {
    private final String sku;
    private final String name;
    private final double unitPrice;
    private int quantityInStock;

    public Product(String sku, String name, double unitPrice, int quantityInStock) {
        if (sku == null || sku.isBlank()) throw new IllegalArgumentException("sku is required");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name is required");
        if (unitPrice < 0) throw new IllegalArgumentException("unitPrice must be >= 0");
        if (quantityInStock < 0) throw new IllegalArgumentException("quantityInStock must be >= 0");
        this.sku = sku;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
    }

    public String getSku() { return sku; }
    public String getName() { return name; }
    public double getUnitPrice() { return unitPrice; }
    public int getQuantityInStock() { return quantityInStock; }

    public void increaseStock(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("amount must be > 0");
        quantityInStock += amount;
    }

    public void decreaseStock(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("amount must be > 0");
        if (amount > quantityInStock) throw new IllegalStateException("not enough stock");
        quantityInStock -= amount;
    }
}
