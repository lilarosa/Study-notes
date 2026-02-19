package ihk.lagerverwaltung.service;

import ihk.lagerverwaltung.model.Customer;
import ihk.lagerverwaltung.model.OrderItem;
import ihk.lagerverwaltung.model.SalesOrder;

import java.util.concurrent.atomic.AtomicInteger;

public class OrderService {
    private final InventoryService inventoryService;
    private final AtomicInteger sequence = new AtomicInteger(1000);

    public OrderService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public SalesOrder createOrder(Customer customer) {
        return new SalesOrder("SO-" + sequence.incrementAndGet(), customer);
    }

    public void addItem(SalesOrder order, String sku, int quantity) {
        inventoryService.reserve(sku, quantity);
        order.addItem(new OrderItem(inventoryService.findBySku(sku), quantity));
    }

    public void confirm(SalesOrder order) {
        order.confirm();
    }
}
