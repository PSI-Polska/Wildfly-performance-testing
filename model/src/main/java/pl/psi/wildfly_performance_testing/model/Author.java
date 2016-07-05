package pl.psi.wildfly_performance_testing.model;

import com.sun.org.apache.xpath.internal.operations.String;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by mblaszyk on 2016-07-05.
 */
public class Author implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany()
    List<Book> books;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private Date dateOfBirth;

    @Column
    private Date dateOfDeath;

    @OneToOne
    private Address address;

}
