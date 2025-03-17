package payment;

import java.util.Scanner;

public class PaymentFactory {
    public static PaymentMethod getPaymentMethod(String type) {
        switch (type.toLowerCase()) {
            case "creditcard":
                return new CreditCardPayment();
            case "paypal":
                System.out.println("Введите email для PayPal:");
                Scanner scanner = new Scanner(System.in);
                String email = scanner.nextLine();
                return new PayPalAdapter(email);
            case "crypto":
                return new CryptoPayment();
            default:
                throw new IllegalArgumentException("Неверный метод оплаты!");
        }
    }
}