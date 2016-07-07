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
public class D implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<D> dList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private G g;

    @Column
    private double doubleAttribute1;
    @Column
    private double doubleAttribute2;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<D> getdList() {
        return dList;
    }

    public void setdList(List<D> dList) {
        this.dList = dList;
    }

    public G getG() {
        return g;
    }

    public void setG(G g) {
        this.g = g;
    }

    public double getDoubleAttribute1() {
        return doubleAttribute1;
    }

    public void setDoubleAttribute1(double doubleAttribute1) {
        this.doubleAttribute1 = doubleAttribute1;
    }

    public double getDoubleAttribute2() {
        return doubleAttribute2;
    }

    public void setDoubleAttribute2(double doubleAttribute2) {
        this.doubleAttribute2 = doubleAttribute2;
    }
}
