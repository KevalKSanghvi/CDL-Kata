package cdl.kata.service;

import cdl.kata.model.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductServiceTest {
    Product product = new Product();
    ProductService productService = new ProductService();

    @Test
    public void checkItem() {
        assertTrue("Expected Catalog to Contain Item 'A'",productService.itemPrice.containsKey("A"));
        assertTrue("Expected Catalog to Contain Item 'B'",productService.itemPrice.containsKey("B"));
        assertTrue("Expected Catalog to Contain Item 'C'",productService.itemPrice.containsKey("C"));
        assertTrue("Expected Catalog to Contain Item 'D'",productService.itemPrice.containsKey("D"));
    }

    @Test
    public void checkOffer() {
        assertEquals("130.0",productService.itemPrice.containsValue("130.0"));
    }
}