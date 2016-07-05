package pl.psi.wildfly_performance_testing.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by mblaszyk on 2016-07-05.
 */
@Entity
@Table
public class Book implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany()
    List<Chapter> chapters;

    @ManyToOne
    private Author author;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private int chapterCount;

    @Column
    private Date releaseDate;



}
