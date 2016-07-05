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

    @OneToOne
    private H h;

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
}
