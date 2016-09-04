package ru.kpfu.itis.gunkin.entities;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "comments", schema = "public", catalog = "music_school")
public class Comment {
    private int id;
    private Date date;
    private String сontent;
    private User user;
    private News news;

    public Comment(String сontent, User user, News news, Date date) {
        this.date = date;
        this.сontent = сontent;
        this.user = user;
        this.news = news;
    }

    public Comment() {
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonManagedReference
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(targetEntity = News.class)
    @JoinColumn(name = "news_id")
    @JsonBackReference
    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "comment_id_seq")
    @SequenceGenerator(name = "comment_id_seq", sequenceName = "comment_id_seq", allocationSize = 1)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int cId) {
        this.id = cId;
    }

    @Basic
    @Column(name = "publish_date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "content")
    public String getСontent() {
        return сontent;
    }

    public void setСontent(String cContent) {
        this.сontent = cContent;
    }

    public String prettyDate(){
        return new SimpleDateFormat("dd-MM-yyyy  HH:mm").format(date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment that = (Comment) o;

        if (id != that.id) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (сontent != null ? !сontent.equals(that.сontent) : that.сontent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (сontent != null ? сontent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", pubDate='" + date + '\'' +
                ", сontent='" + сontent + '\'' +
                ", user=" + user +
                ", news=" + news +
                '}';
    }
}
