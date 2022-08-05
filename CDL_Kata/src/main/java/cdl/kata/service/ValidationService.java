package cdl.kata.service;

import cdl.kata.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Scanner;

/**
 * The type Validation service.
 */
@Service
public class ValidationService {

    @Autowired
    Product product;

    Scanner scanner = new Scanner(System.in);

    /**
     * Validate item string.
     *
     * @param itemName the item name
     * @return the string
     */
    @PostConstruct
    public String validateItem(String itemName) {
        if(itemName.matches("[A-D]")) {
            return itemName;
        }
        else {
            return "Not Valid";
        }
    }

}
