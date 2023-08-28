package Model;
// Location class having attributes of a location

abstract public class Location {
    // Location attributes
    private String city;
    private String country;

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCityName(String city) {
        this.city = city;
    }

    public String getCityName() {
        return this.city;
    }

    abstract public double calculatePassengerDensity(int passengers,double airportArea);
}
