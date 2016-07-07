package pl.psi.wildfly_performance_testing.model.big;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ftrela on 2016-07-05.
 */
@Entity
@Table
public class B implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<E> eList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<F> fList = new ArrayList<>();

    @Column
    private double NumberAttribute1;
    @Column
    private int NumberAttribute2;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<E> geteList() {
        return eList;
    }

    public void seteList(List<E> eList) {
        this.eList = eList;
    }

    public List<F> getfList() {
        return fList;
    }

    public void setfList(List<F> fList) {
        this.fList = fList;
    }

    public double getDoubleAttribute1() {
        return NumberAttribute1;
    }

    public void setDoubleAttribute1(double numberAttribute1) {
        NumberAttribute1 = numberAttribute1;
    }

    public int getNumberAttribute2() {
        return NumberAttribute2;
    }

    public void setNumberAttribute2(int numberAttribute2) {
        NumberAttribute2 = numberAttribute2;
    }
}
