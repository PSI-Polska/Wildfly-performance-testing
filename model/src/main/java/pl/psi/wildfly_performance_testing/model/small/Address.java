package pl.psi.wildfly_performance_testing.model.small;

import com.fasterxml.jackson.annotation.JsonRootName;
import pl.psi.wildfly_performance_testing.model.WithK;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mblaszyk on 2016-07-05.
 */
@JsonRootName(value = "Address")
@Entity
@Table
public class Address implements Serializable,WithK {
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


    @Column
    private int dummyAtrib1;
    @Column
    private int dummyAtrib2;
    @Column
    private int dummyAtrib3;
    @Column
    private String dummyAtrib4;



    @Column
    private String dummyAtrib5;

    public int getDummyAtrib1() {
        return dummyAtrib1;
    }

    public void setDummyAtrib1(int dummyAtrib1) {
        this.dummyAtrib1 = dummyAtrib1;
    }

    public int getDummyAtrib2() {
        return dummyAtrib2;
    }

    public void setDummyAtrib2(int dummyAtrib2) {
        this.dummyAtrib2 = dummyAtrib2;
    }

    public int getDummyAtrib3() {
        return dummyAtrib3;
    }

    public void setDummyAtrib3(int dummyAtrib3) {
        this.dummyAtrib3 = dummyAtrib3;
    }

    public String getDummyAtrib4() {
        return dummyAtrib4;
    }

    public void setDummyAtrib4(String dummyAtrib4) {
        this.dummyAtrib4 = dummyAtrib4;
    }

    public String getDummyAtrib5() {
        return dummyAtrib5;
    }

    public void setDummyAtrib5(String dummyAtrib5) {
        this.dummyAtrib5 = dummyAtrib5;
    }

}
