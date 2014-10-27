package com.academysmart.aviamodel;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
public class ConcreteRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_concrete_route_gen")
    @SequenceGenerator(name = "id_concrete_route_gen", sequenceName = "id_concrete_route_seq")
    private long concreteRouteId;
    private String flightDate;
    private int avLuxSits;
    private int avBSits;
    private int avCSits;
    @SuppressWarnings("JpaDataSourceORMInspection")
    @OneToOne(targetEntity = Route.class)
    @JoinColumn(name = "route_id")
    private Route route;


    public String getFlightDate() {
        return this.flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public Route getRoute() {
        return this.route;
    }

    public long getConcreteRouteId() {
        return this.concreteRouteId;
    }

    public int getAvLuxSits() {
        return this.avLuxSits;
    }

    public int getAvBSits() {
        return this.avBSits;
    }

    public int getAvCSits() {
        return this.avCSits;
    }

    public void setAvCSits() {
        this.avCSits = 0;
        for (Map.Entry<Integer, Boolean> pair : this.route.getlSits().entrySet()) {
            if (!pair.getValue()) {
                continue;
            }
            this.avCSits++;
        }
    }

    public void setAvBSits() {
        this.avBSits = 0;
        for (Map.Entry<Integer,Boolean> pair : this.route.getbSits().entrySet()){
            if (!pair.getValue()) {
                continue;
            }
            this.avBSits++;
        }
    }

    public void setAvLuxSits() {
        this.avLuxSits = 0;
        for (Map.Entry<Integer,Boolean> pair : this.route.getlSits().entrySet()) {
            if (!pair.getValue()) {
                continue;
            }
            this.avCSits++;
        }
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}

