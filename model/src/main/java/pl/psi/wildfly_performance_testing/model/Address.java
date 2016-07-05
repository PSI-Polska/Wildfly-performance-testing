package pl.psi.wildfly_performance_testing.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mblaszyk on 2016-07-05.
 */
public class Address implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String Country;

    @Column
    private String City;


}
