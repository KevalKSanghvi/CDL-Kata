package cdl.kata.service;

import cdl.kata.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Checkout service.
 */
@Service
public class CheckoutService {

    @Autowired
    ProductService productService;

    public HashMap<String, Integer> itemList = new HashMap<String, Integer>();

    /**
     * Add item to cart.
     *
     * @param item     the item
     * @param quantity the quantity
     */
    @PostConstruct
    public void addItemToCart(String item, Integer quantity) {
        if (!itemList.containsKey(item))
            itemList.put(item, quantity);
        else
            itemList.put(item, quantity + itemList.get(item));
    }

    /**
     * Apply offer price.
     *
     * @param entry the entry
     * @return the double
     */
    @PostConstruct
    public double applyOfferPrice(Map.Entry<String, Integer> entry) {
        Product offer = productService.itemOffer.get(entry.getKey());
        double discountedPrice = (entry.getValue() % offer.getProductQuantity()) * productService.itemPrice.get(entry.getKey())
                + (entry.getValue() / offer.getProductQuantity()) * offer.getProductOfferPrice();
        return discountedPrice;
    }

    /**
     * Review cart.
     */
    @PostConstruct
    public void reviewCart(){
        try{
            itemList.isEmpty();
        }catch (Exception e) {
            System.out.println("Your Cart is Empty");
        }

        System.out.println("\nCart :");
        System.out.println("Item" + "\tQuantity" + "\tItem Price" + "\tItemTotalPrice" + "\tSpecialOffer Price");

        for (Map.Entry<String, Integer> entry : itemList.entrySet()) {
            System.out.println(" " + entry.getKey() + " \t\t   " + entry.getValue() + "  \t\t  "
                    + productService.itemPrice.get(entry.getKey()) + "p \t\t "
                    + (productService.itemPrice.get(entry.getKey()) * entry.getValue()) + "p\t\t\t"
                    + applyOfferPrice(entry)+"p");
        }
    }

    /**
     * Calculate checkout price.
     *
     * @param itemList the item list
     * @return the double
     */
    @PostConstruct
    public double calculateCheckoutPrice(Map<String, Integer> itemList) {
        double total = 0.0;

        for (Map.Entry<String, Integer> entry : itemList.entrySet()) {
            if (productService.itemOffer.containsKey(entry.getKey())) {
                total += applyOfferPrice(entry);
            } else {
                total += (entry.getValue()) * productService.itemPrice.get(entry.getKey());
            }

        }
        return total;
    }
}
