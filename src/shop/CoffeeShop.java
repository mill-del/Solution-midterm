package shop;

import java.util.Scanner;

public class CoffeeShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Coffee Shop!");
        System.out.println("Choose a coffee type: Espresso, Cappuccino, Latte");
        String coffeeType = scanner.nextLine().toLowerCase();

        Coffee coffee;
        try {
            coffee = CoffeeFactory.createCoffee(coffeeType);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid coffee type. Exiting...");
            return;
        }

        boolean addingToppings = true;
        while (addingToppings) {
            System.out.println("Add toppings: Milk, Chocolate, Whipped Cream, then type 'done' to finish.");
            String topping = scanner.nextLine().toLowerCase();

            switch (topping) {
                case "milk":
                    coffee = new MilkDecorator(coffee);
                    break;
                case "chocolate":
                    coffee = new ChocolateDecorator(coffee);
                    break;
                case "whipped cream":
                    coffee = new WhippedCreamDecorator(coffee);
                    break;
                case "done":
                    addingToppings = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        System.out.println("Your order: " + coffee.getDescription());
        System.out.printf("Total cost: $%.2f%n", coffee.getCost());

        scanner.close();
    }
}
