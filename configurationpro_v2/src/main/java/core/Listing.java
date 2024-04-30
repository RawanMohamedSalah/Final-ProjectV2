package core;

public class Listing {
	private int listingId;
    private int cityId;
    private int categoryId;
    private int agentId;
    private int bedrooms;
    private int bathrooms;
    private double squareFootage;
    private double price;

    // Constructor
    public Listing(int listingId, int cityId, int categoryId, int agentId, int bedrooms, int bathrooms, double squareFootage, double price) {
        this.listingId = listingId;
        this.cityId = cityId;
        this.categoryId = categoryId;
        this.agentId = agentId;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.squareFootage = squareFootage;
        this.price = price;
    }

    // Getters and Setters
    public int getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
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

    public double getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}