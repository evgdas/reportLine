package com.soyuz.reportsLine3.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "MES_EndProduct", schema = "", catalog = "")
public class ReportsProduct {
    @Id
    @GeneratedValue
    @Column(name = "id")

    private long id;

    @Column(name = "Datum/Zeit")
    private LocalDateTime date;
    @Column(name = "Rezept")
    private String product;
    @Column(name = "IstGewicht")
    private float weight;
    @Column(name = "FuellerNr")
    private int line;
    @Column(name = "Waage")

    private int waage;

    public int getWaage() {
        return waage;
    }

    public void setWaage(int waage) {
        this.waage = waage;
    }
    protected ReportsProduct() {
    }

    public ReportsProduct(long id, LocalDateTime date, String product, float weight, int line) {
        this.id = id;
        this.date = date;
        this.product = product;
        this.weight = weight;
        this.line=line;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "ReportsProduct{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", product='" + product + '\'' +
                ", weight=" + weight +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
