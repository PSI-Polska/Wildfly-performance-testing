package pl.psi.wildfly_performance_testing.model.big;

import javax.persistence.*;
import java.io.Serializable;
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

    @OneToMany
    private List<C> cList;

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
}
