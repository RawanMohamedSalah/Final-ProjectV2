package core;

import java.util.List;

public interface CityDao {
    List<City> getAllCities();

    City getCity(int cityId);

    void saveCity(City city);

    void updateCity(City city);

    void deleteCity(int cityId);
}
