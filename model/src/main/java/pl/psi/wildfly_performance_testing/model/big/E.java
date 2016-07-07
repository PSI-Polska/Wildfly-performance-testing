package pl.psi.wildfly_performance_testing.model.big;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ftrela on 2016-07-05.
 */
@Entity
@Table
public class E implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private H h;

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

    public H getH() {
        return h;
    }

    public void setH(H h) {
        this.h = h;
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
