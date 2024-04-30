package core;

public class Offer {
	private OfferType offerType;

    public Offer(OfferType offerType) {
        this.offerType = offerType;
    }

    public String applyOffer(double originalPrice) {
        return offerType.applyOffer(originalPrice);
    }
}