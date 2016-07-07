package pl.psi.wildfly_performance_testing.model.big;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ftrela on 2016-07-05.
 */
@Entity
@Table
public class A implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<B> bList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<C> cList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private D d;

    @Column
    private Date date;
    @Column
    private String TextAttribute1;
    @Column
    private String TextAttribute2;
    @Column
    private String TextAttribute3;
    @Column
    private double NumberAttribute1;
    @Column
    private int NumberAttribute2;
    @Column
    private int NumberAttribute3;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<B> getbList() {
        return bList;
    }

    public void setbList(List<B> bList) {
        this.bList = bList;
    }

    public List<C> getcList() {
        return cList;
    }

    public void setcList(List<C> cList) {
        this.cList = cList;
    }

    public D getD() {
        return d;
    }

    public void setD(D d) {
        this.d = d;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTextAttribute1() {
        return TextAttribute1;
    }

    public void setTextAttribute1(String textAttribute1) {
        TextAttribute1 = textAttribute1;
    }

    public String getTextAttribute2() {
        return TextAttribute2;
    }

    public void setTextAttribute2(String textAttribute2) {
        TextAttribute2 = textAttribute2;
    }

    public String getTextAttribute3() {
        return TextAttribute3;
    }

    public void setTextAttribute3(String textAttribute3) {
        TextAttribute3 = textAttribute3;
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

    public int getNumberAttribute3() {
        return NumberAttribute3;
    }

    public void setNumberAttribute3(int numberAttribute3) {
        NumberAttribute3 = numberAttribute3;
    }
}
