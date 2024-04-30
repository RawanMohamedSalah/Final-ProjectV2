package core;

public interface OfferType {
	String applyOffer(double originalPrice);

	String getOfferTypeId();

	String getOfferTypeName();

	String getDiscountPercentage();
}