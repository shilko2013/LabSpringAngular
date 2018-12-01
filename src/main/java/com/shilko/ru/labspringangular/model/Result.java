package com.shilko.ru.labspringangular.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private double x;

    @Column(nullable = false)
    private double y;

    @Column(nullable = false)
    private double r;

    @Column(nullable = false)
    private boolean checking;

    @Column(nullable = false)
    private String sessionID;

    public Result(){}

    public Result(double x, double y, double r, boolean checking, String sessionID) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.checking = checking;
        this.sessionID = sessionID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public boolean isChecking() {
        return checking;
    }

    public void setChecking(boolean checking) {
        this.checking = checking;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
}
