package address;

import java.util.Objects;


/**
 * Typical "data" class with only getters and setters.
 */
public class Address {
    private String country;
    private String city;
    private String street;
    private String houseNr;
    private String postalCode;

    public Address() {
    }

    public Address(String country, String city, String street, String houseNr, String postalCode){
        setCity(city);
        setCountry(country);
        setHouseNr(houseNr);
        setPostalCode(postalCode);
        setStreet(street);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(String houseNr) {
        this.houseNr = houseNr;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNr='" + houseNr + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(country, address.country) &&
                Objects.equals(city, address.city) &&
                Objects.equals(street, address.street) &&
                Objects.equals(houseNr, address.houseNr) &&
                Objects.equals(postalCode, address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, street, houseNr, postalCode);
    }
}
