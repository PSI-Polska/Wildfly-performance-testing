package pl.psi.wildfly_performance_testing.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mblaszyk on 2016-07-05.
 */
public class Chapter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Book book;

    @Column
    private int number;

    @Column
    private String title;

    @Column
    private String content;

}
