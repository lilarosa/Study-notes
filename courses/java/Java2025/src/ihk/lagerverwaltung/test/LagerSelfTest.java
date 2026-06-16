package ihk.lagerverwaltung.test;

import ihk.lagerverwaltung.model.Customer;
import ihk.lagerverwaltung.model.Product;
import ihk.lagerverwaltung.model.SalesOrder;
import ihk.lagerverwaltung.service.InventoryService;
import ihk.lagerverwaltung.service.OrderService;

public class LagerSelfTest {
    public static void main(String[] args) {
        InventoryService inventory = new InventoryService();
        OrderService orders = new OrderService(inventory);

        inventory.addProduct(new Product("P-1", "Notebook", 10.0, 10));
        Customer customer = new Customer("C-1", "Test User", "test@example.de");
        SalesOrder order = orders.createOrder(customer);

        orders.addItem(order, "P-1", 3);
        orders.confirm(order);

        assertEquals(7, inventory.findBySku("P-1").getQuantityInStock(), "stock after reservation");
        assertEquals(30.0, order.getTotal(), "order total");

        System.out.println("All self-tests passed.");
    }

    private static void assertEquals(double expected, double actual, String label) {
        if (Math.abs(expected - actual) > 0.0001) {
            throw new IllegalStateException("Assertion failed: " + label + ", expected=" + expected + ", actual=" + actual);
        }
    }
}
