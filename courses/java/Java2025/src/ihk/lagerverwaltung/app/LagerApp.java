package ihk.lagerverwaltung.app;

import ihk.lagerverwaltung.model.Customer;
import ihk.lagerverwaltung.model.Product;
import ihk.lagerverwaltung.model.SalesOrder;
import ihk.lagerverwaltung.service.InventoryService;
import ihk.lagerverwaltung.service.OrderService;

public class LagerApp {
    public static void main(String[] args) {
        InventoryService inventory = new InventoryService();
        OrderService orders = new OrderService(inventory);

        inventory.addProduct(new Product("P-100", "Laptop", 1299.99, 5));
        inventory.addProduct(new Product("P-200", "Mouse", 25.50, 50));

        Customer customer = new Customer("C-1", "Mia Weber", "mia.weber@example.de");
        SalesOrder order = orders.createOrder(customer);

        orders.addItem(order, "P-100", 1);
        orders.addItem(order, "P-200", 2);
        orders.confirm(order);

        System.out.println("Order: " + order.getOrderId());
        System.out.println("Status: " + order.getStatus());
        System.out.println("Total: " + order.getTotal());
    }
}
