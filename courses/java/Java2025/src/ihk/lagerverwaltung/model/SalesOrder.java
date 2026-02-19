package ihk.lagerverwaltung.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SalesOrder {
    private final String orderId;
    private final Customer customer;
    private final List<OrderItem> items = new ArrayList<>();
    private OrderStatus status = OrderStatus.DRAFT;

    public SalesOrder(String orderId, Customer customer) {
        if (orderId == null || orderId.isBlank()) throw new IllegalArgumentException("orderId is required");
        if (customer == null) throw new IllegalArgumentException("customer is required");
        this.orderId = orderId;
        this.customer = customer;
    }

    public String getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public OrderStatus getStatus() { return status; }
    public List<OrderItem> getItems() { return Collections.unmodifiableList(items); }

    public void addItem(OrderItem item) {
        if (status != OrderStatus.DRAFT) throw new IllegalStateException("only DRAFT orders can be changed");
        items.add(item);
    }

    public void confirm() {
        if (items.isEmpty()) throw new IllegalStateException("order must contain at least one item");
        status = OrderStatus.CONFIRMED;
    }

    public double getTotal() {
        return items.stream().mapToDouble(OrderItem::getLineTotal).sum();
    }
}
