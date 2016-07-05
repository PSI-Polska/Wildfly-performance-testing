package pl.psi.wildfly_performance_testing.model.big;

import javax.persistence.*;
import java.io.Serializable;
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

    @OneToMany
    private List<E> eList;

    @OneToMany
    private List<F> fList;

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
}
