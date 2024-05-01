package core;

public class Offer {
    // Default values for the attributes
    private static final int DEFAULT_OFFER_ID = 0;
    private static final String DEFAULT_OFFER_DESCRIPTION = "No Description";

    // Attributes
    private int offerId; // Primary key
    private String offerDescription; // Can be nullable, corresponds to VARCHAR(45)

    // Default constructor
    public Offer() {
        this(DEFAULT_OFFER_ID, DEFAULT_OFFER_DESCRIPTION);
    }

    // Parameterized constructor
    public Offer(int offerId, String offerDescription) {
        this.offerId = offerId;
        this.offerDescription = (offerDescription == null) ? DEFAULT_OFFER_DESCRIPTION : offerDescription;
    }

    // Getters and setters for the fields
    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = (offerDescription == null) ? DEFAULT_OFFER_DESCRIPTION : offerDescription;
    }
}