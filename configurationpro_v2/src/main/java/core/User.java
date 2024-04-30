package core;

public class User {
	 private int user_id;
	    private String username;
	    private String email;
	    private String password;
	    private String registration_date;
	    private String phone_number; // Optional attribute
	    private String address; // Optional attribute

	    // Private constructor to prevent direct instantiation
	    private User(Builder builder) {
	        this.user_id = builder.user_id;
	        this.username = builder.username;
	        this.email = builder.email;
	        this.password = builder.password;
	        this.registration_date = builder.registration_date;
	        this.phone_number = builder.phone_number;
	        this.address = builder.address;
	    }

	    // Builder class
	    public static class Builder {
	        private int user_id;
	        private String username;
	        private String email;
	        private String password;
	        private String registration_date;
	        private String phone_number; // Optional attribute
	        private String address; // Optional attribute

	        public Builder(int user_id, String username, String email, String password, String registration_date) {
	            this.user_id = user_id;
	            this.username = username;
	            this.email = email;
	            this.password = password;
	            this.registration_date = registration_date;
	        }

	        public Builder phone_number(String phone_number) {
	            this.phone_number = phone_number;
	            return this;
	        }

	        public Builder address(String address) {
	            this.address = address;
	            return this;
	        }

	        public User build() {
	            return new User(this);
	        }
	    }

	    // Getter methods
	    public int getUserId() {
	        return user_id;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public String getRegistrationDate() {
	        return registration_date;
	    }

	    public String getPhoneNumber() {
	        return phone_number;
	    }

	    public String getAddress() {
	        return address;
	    }
}