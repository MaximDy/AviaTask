package com.academysmart.aviamodel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Airport {
    @Id
    private String portName;
    @OneToMany (mappedBy = "airport")
    private List<Route> routes = new ArrayList<>();

    public String getPortName() {
        return this.portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public List<Route> getRoutes() {
        return this.routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}
