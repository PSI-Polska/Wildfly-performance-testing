package pl.psi.wildfly_performance_testing.model.big;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ftrela on 2016-07-05.
 */
@Entity
@Table
public class C implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
