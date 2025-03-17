public class PayPalAdapter implements PaymentMethod {
    private ExternalPayPalAPI externalPayPalAPI;
    private String email;

    public PayPalAdapter(String email) {
        this.externalPayPalAPI = new ExternalPayPalAPI();
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        boolean success = externalPayPalAPI.makeTransaction(email, amount);
        if (success) {
            System.out.println("PayPal payment successful!");
        } else {
            System.out.println("PayPal payment failed.");
        }
    }
}
