package cdl.kata.model;

import lombok.*;
import org.springframework.stereotype.Component;


/**
 * The type Product.
 * Uses @Data (Lombok) to generate constructors and getters and setters
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    private String productName;
    private int productQuantity;
    private double productOfferPrice;
}
