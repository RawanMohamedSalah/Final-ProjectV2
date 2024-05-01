package core;

public class Listing {
    private int listing_id;
    private int city_id;
    private int category_id;
    private int agent_id;
    private int offer_id;
    private int property_type_id;
    private int documents_id;
    private int bedrooms;
    private int bathrooms;
    private double square_footage;
    private double price;

    // Private constructor to enforce object creation via builder
    private Listing(Builder builder) {
        this.listing_id = builder.listing_id;
        this.city_id = builder.city_id;
        this.category_id = builder.category_id;
        this.agent_id = builder.agent_id;
        this.offer_id = builder.offer_id;
        this.property_type_id = builder.property_type_id;
        this.documents_id = builder.documents_id;
        this.bedrooms = builder.bedrooms;
        this.bathrooms = builder.bathrooms;
        this.square_footage = builder.square_footage;
        this.price = builder.price;
    }

    // Builder class for Listing
    public static class Builder {
        // Required parameters
        private int listing_id;
        private int city_id;
        private int category_id;
        private int agent_id;

        // Optional parameters with default values
        private int offer_id = 0;
        private int property_type_id = 0;
        private int documents_id = 0;
        private int bedrooms = 0;
        private int bathrooms = 0;
        private double square_footage = 0.0;
        private double price = 0.0;

        public Builder(int listing_id, int city_id, int category_id, int agent_id) {
            this.listing_id = listing_id;
            this.city_id = city_id;
            this.category_id = category_id;
            this.agent_id = agent_id;
        }

        public Builder offerId(int offer_id) {
            this.offer_id = offer_id;
            return this;
        }

        public Builder propertyTypeId(int property_type_id) {
            this.property_type_id = property_type_id;
            return this;
        }

        public Builder documentsId(int documents_id) {
            this.documents_id = documents_id;
            return this;
        }

        public Builder bedrooms(int bedrooms) {
            this.bedrooms = bedrooms;
            return this;
        }

        public Builder bathrooms(int bathrooms) {
            this.bathrooms = bathrooms;
            return this;
        }

        public Builder squareFootage(double square_footage) {
            this.square_footage = square_footage;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Listing build() {
            return new Listing(this);
        }
    }

    // Getters and setters for Listing attributes
    public int getListing_id() {
        return listing_id;
    }

    public void setListing_id(int listing_id) {
        this.listing_id = listing_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public int getProperty_type_id() {
        return property_type_id;
    }

    public void setProperty_type_id(int property_type_id) {
        this.property_type_id = property_type_id;
    }

    public int getDocuments_id() {
        return documents_id;
    }

    public void setDocuments_id(int documents_id) {
        this.documents_id = documents_id;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public double getSquare_footage() {
        return square_footage;
    }

    public void setSquare_footage(double square_footage) {
        this.square_footage = square_footage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}