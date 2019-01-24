package main.lab.model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Points {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private float x;

    @Column(nullable = false)
    private float y;

    @Column(nullable = false)
    private float r;

    @Column(nullable = false)
    private int check;

    @Column(nullable = false)
    private String user;

    public Points(){}

    public Points(float x, float y, float r, int check, String user) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.check = check;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public int isChecking() {
        return check;
    }

    public void setChecking(int check) {
        this.check = check;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
