package pl.psi.wildfly_performance_testing.model.small;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import pl.psi.wildfly_performance_testing.model.WithK;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by mblaszyk on 2016-07-05.
 */
@JsonRootName(value = "Book")
@Entity
@Table
public class Book implements Serializable,WithK {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = {CascadeType.ALL},orphanRemoval = true)
    List<Chapter> chapters;

    @ManyToOne(cascade ={CascadeType.ALL})
    private Author author;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private int chapterCount;

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    @JsonIgnore
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getChapterCount() {
        return chapterCount;
    }

    public void setChapterCount(int chapterCount) {
        this.chapterCount = chapterCount;
    }

    @Column
    private Date releaseDate;



}
