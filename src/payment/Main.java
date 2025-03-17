package payment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a payment method: creditcard / paypal / crypto");
        String paymentType = scanner.nextLine();

        try {
            PaymentMethod paymentMethod = PaymentFactory.getPaymentMethod(paymentType);
            System.out.println("Enter the amount to be paid:");
            double amount = scanner.nextDouble();

            paymentMethod.processPayment(amount);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}