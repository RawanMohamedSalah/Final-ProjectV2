package core;

import java.util.ArrayList;
import java.util.List;

public class PropertyReviews {
	   private String reviewerName;
	    private int rating;
	    private String comment;
	    private List<PropertyReviewObserver> observers;
	    private List<PropertyReviews> reviews;

	    public PropertyReviews(String reviewerName, int rating, String comment) {
	        this.reviewerName = reviewerName;
	        this.rating = rating;
	        this.comment = comment;
	        this.observers = new ArrayList<>();
	        this.reviews = new ArrayList<>();
	    }

	    // Getter and setter methods for reviewerName
	    public String getReviewerName() {
	        return reviewerName;
	    }

	    public void setReviewerName(String reviewerName) {
	        this.reviewerName = reviewerName;
	    }

	    // Getter and setter methods for rating
	    public int getRating() {
	        return rating;
	    }

	    public void setRating(int rating) {
	        this.rating = rating;
	    }

	    // Getter and setter methods for comment
	    public String getComment() {
	        return comment;
	    }

	    public void setComment(String comment) {
	        this.comment = comment;
	    }

	    // Method to add a review
	    public void addReview(PropertyReviews review) {
	        reviews.add(review);
	        notifyObservers(review);
	    }

	    // Method to register observers
	    public void addObserver(PropertyReviewObserver observer) {
	        observers.add(observer);
	    }

	    // Method to notify observers
	    private void notifyObservers(PropertyReviews review) {
	        for (PropertyReviewObserver observer : observers) {
	            observer.update(review);
	        }
	    }

	    // Getter and setter methods for reviews
	    public List<PropertyReviews> getReviews() {
	        return reviews;
	    }

	    public void setReviews(List<PropertyReviews> reviews) {
	        this.reviews = reviews;
	    }
	}

	// PropertyReviewObserver.java
	interface PropertyReviewObserver {
	    void update(PropertyReviews review);
	}