interface PaymentGateway {
    String pay(int amount);
}

// Adaptee classes
class PayPal {
    public String makePayment(int amount) {
        return "Paid " + amount + " using PayPal.";
    }
}

class Stripe {
    public String processPayment(int amount) {
        return "Processed " + amount + " with Stripe.";
    }
}

// Adapter classes
class PayPalAdapter implements PaymentGateway {
    private PayPal paypal;

    public PayPalAdapter(PayPal paypal) {
        this.paypal = paypal;
    }

    public String pay(int amount) {
        return paypal.makePayment(amount);
    }
}

class StripeAdapter implements PaymentGateway {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    public String pay(int amount) {
        return stripe.processPayment(amount);
    }
}

// Usage
public class Test6 {
    public static void main(String[] args) {
        PayPal paypal = new PayPal();
        PaymentGateway paypalAdapter = new PayPalAdapter(paypal);
        System.out.println(paypalAdapter.pay(100));

        Stripe stripe = new Stripe();
        PaymentGateway stripeAdapter = new StripeAdapter(stripe);
        System.out.println(stripeAdapter.pay(150));
    }
}