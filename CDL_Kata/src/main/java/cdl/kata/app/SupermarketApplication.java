package cdl.kata.app;

import cdl.kata.service.CheckoutService;
import cdl.kata.service.ValidationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

/**
 * The type Demo application.
 */
@SpringBootApplication
//@ComponentScan({"cdl.kata.model","cdl.kata.service"})
public class SupermarketApplication {

	private static final String CHECKOUT = "checkout";

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SupermarketApplication.class, args);

		CheckoutService checkoutService = new CheckoutService();
		ValidationService validationService = new ValidationService();
		try (Scanner scanner = new Scanner(System.in)) {

			String input = null;
			System.out.println("\nPlease enter product that you want to buy.");
			System.out.println("To checkout please type: " + CHECKOUT);

			while (!CHECKOUT.equalsIgnoreCase(input)) {
				String item = "";
				int quantity = 0;

				System.out.println("\nScan your items from list [A, B, C, D] : ");
				input = scanner.nextLine();
				input = input.toUpperCase();
				item = validationService.validateItem(input);

				if (item.matches("[A-D]")) {
					checkoutService.addItemToCart(item, 1);
					try {
						checkoutService.reviewCart();
					} catch (Exception error) {
						System.out.println(error.getLocalizedMessage());
					}
					System.out.println("\n------------------- Total Price : £ " + checkoutService.calculateCheckoutPrice(checkoutService.itemList) / 100 + " (" + checkoutService.calculateCheckoutPrice(checkoutService.itemList) + "p)" + " -------------------");
				} else if (!CHECKOUT.equalsIgnoreCase(input)) {
					System.out.println("INVALID ITEM, Please enter a valid item");
				} else {
					System.out.println("\nCheckout Price: £ " + checkoutService.calculateCheckoutPrice(checkoutService.itemList) / 100);
					System.out.println("Successfully Checkedout");
				}

			}

		}
	}
}
