public class ExternalPayPalAPI {
    public boolean makeTransaction(String email, double amount) {
        System.out.println("Connecting to PayPal API...");
        System.out.println("Processing payment for " + email + " of $" + amount);
        return true;
    }
}

