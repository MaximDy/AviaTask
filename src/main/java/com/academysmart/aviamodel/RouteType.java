package com.academysmart.aviamodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
public class RouteType {
    @Id
    private String planeClass;
    private int luxCSits;
    private int businessCSits;
    private int charterCSits;

    public String getPlaneClass() {
        return this.planeClass;
    }

    public int getLuxCSits() {
        return this.luxCSits;
    }

    public int getBusinessCSits() {
        return this.businessCSits;
    }

    public int getCharterCSits() {
        return this.charterCSits;
    }

    public void setPlaneClass(String planeClass) {
        this.planeClass = planeClass;
    }

    public void setLuxCSits(int luxCSits) {
        this.luxCSits = luxCSits;
    }

    public void setBusinessCSits(int businessCSits) {
        this.businessCSits = businessCSits;
    }

    public void setCharterCSits(int charterCSits) {
        this.charterCSits = charterCSits;
    }
}
