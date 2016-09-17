package ru.kpfu.itis.gunkin.entities;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.map.annotate.JacksonInject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "news", schema = "public")
public class News {
    private long id;
    private String title;
    private String content;
    private Date pubDate;
    private List<Comment> comments = new ArrayList<Comment>();

    public News() {
    }

    public News(String title, String content, Date pubDate) {
        this.title = title;
        this.content = content;
        this.pubDate = pubDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    @Basic
    @Column(name = "pub_date")
    public Date getPubDate() {
        return pubDate;
    }


    @OneToMany(fetch = FetchType.EAGER, targetEntity = Comment.class, cascade =  CascadeType.ALL, mappedBy = "news")
    @JsonBackReference
    public List<Comment> getComments() {
        return comments;
    }

    public String shortContent() {
        if (content.length() > 300)
            return content.substring(0, 300);
        else
            return content;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setId(long nId) {
        this.id = nId;
    }

    public void setTitle(String nTitle) {
        this.title = nTitle;
    }

    public void setContent(String nCont) {
        this.content = nCont;
    }

    public void setPubDate(Date nPubDate) {
        this.pubDate = nPubDate;
    }

    @Override
    public boolean equals(Object o) {
        return id == ((News) o).getId();
    }

    @Override
    public int hashCode() {
        long result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (pubDate != null ? pubDate.hashCode() : 0);
        return (int)result;
    }
}
