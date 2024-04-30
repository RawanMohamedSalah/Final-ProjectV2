package core;

import java.util.List;
public class PropertyTypesProxy implements PropertyTypesInterface{
	private PropertyTypes propertyTypes;
    private List<String> cachedTypes;

    @Override
    public List<String> getPropertyTypes() {
        // Lazy initialization: Load property types only when needed
        if (cachedTypes == null) {
            propertyTypes = new PropertyTypes();
            cachedTypes = propertyTypes.getPropertyTypes();
        }
        return cachedTypes;
    }
}