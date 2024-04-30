package core;
import java.util.Arrays;
import java.util.List;

public class PropertyTypes implements PropertyTypesInterface{
	private List<String> types;

    public PropertyTypes() {
        // Simulate loading property types from a database or other source
        types = Arrays.asList("Apartment", "House", "Villa", "Condo", "Townhouse", "Duplex");
    }

    @Override
    public List<String> getPropertyTypes() {
        return types;
    }
}