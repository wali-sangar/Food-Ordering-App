/**
 * This class implements a restaurant food ordering system that allows users to
 * select dishes from a menu, specify the number of servings, and calculate the
 * total cost including tax and an optional tip. The system displays a menu,
 * processes user input, and outputs the order details.
 *
 * @author Sardar Wali Sangar
 * @version 1.0
 * @since March 1, 2023
 */
import java.util.Scanner;

public class FoodSangar {
    /**
     * The main method runs the restaurant food ordering system. It displays a menu
     * of available dishes, prompts the user to select dishes and specify servings,
     * calculates the subtotal, adds tax, and includes an optional tip based on user
     * input. Finally, it displays the order details and confirms the order placement.
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display the menu
        System.out.println("Food Menu");
        System.out.printf("%6s %32s \n", "Item", "Price(in dollars)");
        System.out.printf("%d %s %11.2f \n", 1, "Chicken Curry", 10.69);
        System.out.printf("%d %s %12.2f \n", 2, "Shrimp Curry", 14.25);
        System.out.printf("%d %s %19.2f \n", 3, "Naan", 3.59);
        System.out.printf("%d %s %19.2f \n", 4, "Chai", 2.45);
        System.out.printf("%d %s %18.2f \n", 5, "Crabs", 7.24);
        System.out.printf("%d %s %11.2f \n", 6, "Lamb Biriyani", 15.59);
        System.out.printf("%d %s %12.2f \n", 7, "Veg Biriyani", 11.27);
        System.out.printf("%d %s %9.2f \n", 8, "Gobi Manchurian", 10.35);
        System.out.printf("%d %s %11.2f \n", 9, "Chana Masala", 9.45);
        System.out.printf("%d %s %17.2f \n", 10, "Kheer", 4.99);

        // Prompt the user to enter the number of dishes they want to order
        System.out.print("\nHow many different dishes would you like to order today? ");
        int numDishes = scanner.nextInt();
        scanner.nextLine();
        double price = 0.0;

        // Loop through each dish and ask for the number of servings
        for (int i = 1; i <= numDishes; i++) {
            System.out.print("\nEnter dish " + i + " [1-10]: ");
            int dishNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.print("How many servings of dish " + dishNumber + " would you like to order? ");
            int numServings = scanner.nextInt();
            scanner.nextLine();

            // Calculate the price of the dish and add it to the total price
            switch (dishNumber) {
                case 1:
                    price += numServings * 10.69;
                    break;
                case 2:
                    price += numServings * 14.25;
                    break;
                case 3:
                    price += numServings * 3.59;
                    break;
                case 4:
                    price += numServings * 2.45;
                    break;
                case 5:
                    price += numServings * 7.24;
                    break;
                case 6:
                    price += numServings * 15.59;
                    break;
                case 7:
                    price += numServings * 11.27;
                    break;
                case 8:
                    price += numServings * 10.35;
                    break;
                case 9:
                    price += numServings * 9.45;
                    break;
                case 10:
                    price += numServings * 4.99;
                    break;
                default:
                    System.out.println("Invalid dish number. Please try again.");
                    i--;
                    break;
            }
        }

        // Prompt the user to enter the tax percentage
        System.out.print("\nEnter the tax %: ");
        double taxPercent = scanner.nextDouble();

        // Calculate the tax amount
        double taxAmount = (taxPercent / 100.0) * price;

        // Ask if the user wants to add a tip
        System.out.print("\nDo you want to add tip? ['y' - yes or 'n' - no] ");
        char addTip = scanner.next().charAt(0);

        double tipAmount = 0;
        double tipPercent = 0;
        if (addTip == 'y') {
            // Prompt the user to enter the tip percentage
            System.out.print("\nEnter tip % [0-100]: ");
            tipPercent = scanner.nextDouble();
            // Calculate the tip amount
            tipAmount = (tipPercent / 100.0) * price;
        }

        // Calculate the total amount
        double totalAmount = price + taxAmount + tipAmount;

        // Print the order details
        System.out.printf("Price: $ %.2f\n", price);
        System.out.printf("Tax (%.1f%%): $%.2f\n", taxPercent, taxAmount);
        System.out.printf("Tip (%.1f%%): $%.2f\n", tipPercent, tipAmount);
        System.out.println("----------------------------------------");
        System.out.printf("Total Amount: $ %.2f\n", totalAmount);

        System.out.println("\nYour order has been placed and will be delivered soon!");

        // Close the scanner
        scanner.close();
    }
}
