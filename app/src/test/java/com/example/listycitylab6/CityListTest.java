package com.example.listycitylab6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        // This line checks if the first city in the cityList
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = new CityList();
        City edmonton = new City("Edmonton", "Alberta");
        City toronto = new City("Toronto", "Ontario");

        cityList.add(edmonton);

        // Check if Edmonton exists
        assertTrue(cityList.hasCity(edmonton));

        // Check that Toronto does not exist
        assertFalse(cityList.hasCity(toronto));
    }

    @Test
    void testDelete() {
        CityList cityList = new CityList();
        City edmonton = new City("Edmonton", "Alberta");
        City calgary = new City("Calgary", "Alberta");

        cityList.add(edmonton);
        cityList.add(calgary);

        // Ensure both cities are in the list
        assertEquals(2, cityList.countCities());

        // Delete Edmonton and verify removal
        cityList.delete(edmonton);
        assertEquals(1, cityList.countCities());
        assertFalse(cityList.hasCity(edmonton));

        // Try deleting a city that doesn't exist — should throw exception
        City vancouver = new City("Vancouver", "British Columbia");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(vancouver);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        City edmonton = new City("Edmonton", "Alberta");
        City calgary = new City("Calgary", "Alberta");

        // Initially empty
        assertEquals(0, cityList.countCities());

        // Add first city
        cityList.add(edmonton);
        assertEquals(1, cityList.countCities());

        // Add second city
        cityList.add(calgary);
        assertEquals(2, cityList.countCities());

        // Delete one city
        cityList.delete(edmonton);
        assertEquals(1, cityList.countCities());
    }
}
