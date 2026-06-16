package ihk.lagerverwaltung.service;

import ihk.lagerverwaltung.model.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private final Map<String, Product> productsBySku = new HashMap<>();

    public void addProduct(Product product) {
        if (productsBySku.containsKey(product.getSku())) {
            throw new IllegalArgumentException("SKU already exists: " + product.getSku());
        }
        productsBySku.put(product.getSku(), product);
    }

    public Product findBySku(String sku) {
        Product p = productsBySku.get(sku);
        if (p == null) throw new IllegalArgumentException("Unknown SKU: " + sku);
        return p;
    }

    public void restock(String sku, int amount) {
        findBySku(sku).increaseStock(amount);
    }

    public void reserve(String sku, int amount) {
        findBySku(sku).decreaseStock(amount);
    }

    public Collection<Product> findAll() {
        return productsBySku.values();
    }
}
