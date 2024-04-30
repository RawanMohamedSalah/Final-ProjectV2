package core;

public class PropertyDocument extends Documents{
	// Additional properties specific to property documents
    private String propertyType;

    // Getter and setter methods for propertyType
    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }
}