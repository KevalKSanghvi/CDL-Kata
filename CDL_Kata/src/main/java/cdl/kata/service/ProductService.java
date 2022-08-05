package cdl.kata.service;

import cdl.kata.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ProductService {

    static HashMap<String,Double> itemPrice = new HashMap<>();

    static  {
        itemPrice.put("A", 50.0);
        itemPrice.put("B", 30.0);
        itemPrice.put("C", 20.0);
        itemPrice.put("D", 15.0);
    }

    static HashMap<String, Product> itemOffer = new HashMap<>();

    static  {
        itemOffer.put("A", new Product("A", 3, 130.0));
        itemOffer.put("B", new Product("B", 2, 45.0));
        itemOffer.put("C", new Product("C", 1, 20.0));
        itemOffer.put("D", new Product("D", 1, 15.0));
    }

}
