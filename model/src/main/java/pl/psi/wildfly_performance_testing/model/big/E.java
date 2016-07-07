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
    private double NumberAttribute1;
    @Column
    private int NumberAttribute2;

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
