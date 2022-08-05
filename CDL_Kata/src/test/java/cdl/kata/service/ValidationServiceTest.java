package cdl.kata.service;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.fail;

public class ValidationServiceTest {

    @Test
    void validationTest() {
        ValidationService validationService = new ValidationService();
        String itemName = "A";
        validationService.validateItem(itemName);
        if(!itemName.matches("[A-D]"))
            fail("Invalid Item Name");
    }
}