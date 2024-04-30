package core;

public class FixedAmountOffer implements OfferType {
	private double amount;

    public FixedAmountOffer(double amount) {
        this.amount = amount;
    }

    @Override
    public String applyOffer(double originalPrice) {
        double discountedPrice = originalPrice - amount;
        return String.format("$%.2f off: $%.2f", amount, discountedPrice);
    }
}