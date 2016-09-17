package ru.kpfu.itis.gunkin.entities;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workers", schema = "public")
public class Worker {
    private int id;
    private String firstName;
    private String lastName;
    private String info;
    private String jobTitle;
    private List<School> schools = new ArrayList<School>();

    public Worker() {
    }

    public Worker(String firstName, String lastName, String info, String jobTitle, List<School> schools) {
        this(firstName, lastName, info, jobTitle);
        this.schools = schools;
    }

    public Worker(String firstName, String lastName, String info, String jobTitle, School school) {
        this(firstName, lastName, info, jobTitle);
        schools.add(school);
    }

    public Worker(String firstName, String lastName, String info, String jobTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.info = info;
    }

    public Worker(int id, String firstName, String lastName, String info, String jobTitle) {
        this(firstName, lastName, info, jobTitle);
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "worker_id_seq")
    @SequenceGenerator(name = "worker_id_seq", sequenceName = "worker_id_seq", allocationSize = 1)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    @Basic
    @Column(name = "info")
    public String getInfo() {
        return info;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "worker", targetEntity = School.class)
    @JsonBackReference
    public List<School> getSchools() {
        return schools;
    }


    public String fullName() {
        return firstName + " " + lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object obj) {
        return id == ((Worker) obj).getId();
    }
}
