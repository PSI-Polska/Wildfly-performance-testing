package pl.psi.wildfly_performance_testing.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ftrela on 2016-07-05.
 */
@Entity
@Table
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @OneToMany()
    private List<Account> accounts;


    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Column
    private String email;


    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
