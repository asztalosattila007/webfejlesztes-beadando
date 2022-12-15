package com.example.beadando.Entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nev", nullable = false)
    private String nev;

    @Column(name = "marka", nullable = false)
    private String marka;

    @Column(name = "tipus", nullable = false)
    private String tipus;

    @Column(name = "ar", nullable = false)
    private int ar;

    public ProductEntity() {
    }

    public ProductEntity(String nev, String marka, String tipus, int ar) {
        this.nev = nev;
        this.marka = marka;
        this.tipus = tipus;
        this.ar = ar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }
}
