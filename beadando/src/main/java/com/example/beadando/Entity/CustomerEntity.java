package com.example.beadando.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vezeteknev", nullable = false)
    private String vezeteknev;

    @Column(name = "keresztnev", nullable = false)
    private String keresztnev;

    @Column(name = "email", nullable = false)
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "szuldatum", nullable = false)
    private Date szuldatum;

    public CustomerEntity() {
    }

    public CustomerEntity(String vezeteknev, String keresztnev, String email, Date szuldatum) {
        this.vezeteknev = vezeteknev;
        this.keresztnev = keresztnev;
        this.email = email;
        this.szuldatum = szuldatum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVezeteknev() {
        return vezeteknev;
    }

    public void setVezeteknev(String vezeteknev) {
        this.vezeteknev = vezeteknev;
    }

    public String getKeresztnev() {
        return keresztnev;
    }

    public void setKeresztnev(String keresztnev) {
        this.keresztnev = keresztnev;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getSzuldatum() {
        return szuldatum;
    }

    public void setSzuldatum(Date szuldatum) {
        this.szuldatum = szuldatum;
    }
}
