package ru.kpfu.itis.gunkin.entities;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "schools", schema = "public", catalog = "music_school")
public class School {
    private int id;
    private int cost;
    private boolean enable = true;
    private String name;
    private String info;
    private Worker worker;
    private List<User> users = new ArrayList<User>();

    public School() {
    }

    public School(int id, int cost, String name, String info) {
        this.id = id;
        this.cost = cost;
        this.name = name;
        this.info = info;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "school_id_seq")
    @SequenceGenerator(name = "school_id_seq", sequenceName = "school_id_seq", allocationSize = 1)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Basic
    @Column(name = "info")
    public String getInfo() {
        return info;
    }

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_school",
            joinColumns = @JoinColumn(name = "school_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
    public List<User> getUsers() {
        return users;
    }

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE}, targetEntity = Worker.class)
    @JoinColumn(name = "worker_id", nullable = false)
    public Worker getWorker() {
        return worker;
    }

    public int usersCount() {
        return users.size();
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    @Basic
    @Column(name = "cost")
    public int getCost() {
        return cost;
    }

    @Basic
    @Column(name = "enable")
    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        return id == ((School) obj).getId();
    }

    @Override
    public int hashCode() {
        long result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        return (int)result;
    }

    @Override
    public String toString() {
        return name;
    }
}
