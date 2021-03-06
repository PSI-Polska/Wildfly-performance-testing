package pl.psi.wildfly_performance_testing.model.big;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ftrela on 2016-07-05.
 */
@Entity
@Table
public class F implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<C> cList = new ArrayList<>();

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

    public List<C> getcList() {
        return cList;
    }

    public void setcList(List<C> cList) {
        this.cList = cList;
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
