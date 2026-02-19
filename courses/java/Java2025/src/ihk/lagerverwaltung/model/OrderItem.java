package ihk.lagerverwaltung.model;

public class OrderItem {
    private final Product product;
    private final int quantity;
    private final double unitPriceAtOrder;

    public OrderItem(Product product, int quantity) {
        if (product == null) throw new IllegalArgumentException("product is required");
        if (quantity <= 0) throw new IllegalArgumentException("quantity must be > 0");
        this.product = product;
        this.quantity = quantity;
        this.unitPriceAtOrder = product.getUnitPrice();
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getUnitPriceAtOrder() { return unitPriceAtOrder; }
    public double getLineTotal() { return unitPriceAtOrder * quantity; }
}
