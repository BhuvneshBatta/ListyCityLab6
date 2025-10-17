package com.example.listycitylab6;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * This constructs a city object
     * @param city
     * The name of the city
     * @param province
     * The name of the province
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * This gets the city name
     * @return
     * Return the city name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * This gets the province name
     * @return
     * Return the province name
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Compare cities by their names
     * @param city
     * The city to compare to
     * @return
     * A positive number if this city is greater, negative if smaller, 0 if equal
     */
    @Override
    public int compareTo(City city) {
        return this.city.compareTo(city.getCityName());
    }
}
