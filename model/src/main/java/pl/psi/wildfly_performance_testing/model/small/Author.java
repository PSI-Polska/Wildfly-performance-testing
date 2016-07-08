package pl.psi.wildfly_performance_testing.model.small;


import com.fasterxml.jackson.annotation.JsonRootName;
import pl.psi.wildfly_performance_testing.model.WithK;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mblaszyk on 2016-07-05.
 */
@JsonRootName(value = "Author")
@Entity
@Table
public class Author implements Serializable,WithK {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade=CascadeType.ALL,orphanRemoval = true)
    List<Book> books = new ArrayList<>();

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }



}
