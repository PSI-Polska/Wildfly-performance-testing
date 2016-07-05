package pl.psi.wildfly_performance_testing.model.big;

import javax.persistence.*;
import java.io.Serializable;
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

    @OneToMany
    private List<D> dList;

    @OneToOne
    private G g;

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
}
