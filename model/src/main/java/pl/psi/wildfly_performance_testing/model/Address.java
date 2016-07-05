package pl.psi.wildfly_performance_testing.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mblaszyk on 2016-07-05.
 */
public class Address implements Serializable{
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Column
    private String Country;

    @Column
    private String City;


}
