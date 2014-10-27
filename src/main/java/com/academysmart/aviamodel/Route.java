package com.academysmart.aviamodel;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@NamedQuery(name = "selectAll", query = "SELECT a FROM Route a")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "idr_gen")
    @SequenceGenerator(name = "idr_gen", sequenceName = "idr_seq")
    private long id_r;
    private String wherel;
    private String froml;
    @SuppressWarnings("JpaDataSourceORMInspection")
    @ElementCollection
    @CollectionTable(name = "Lux_Sits")
    @MapKeyColumn(name = "id")
    private Map<Integer,Boolean> lSits = new HashMap<>();
    @SuppressWarnings("JpaDataSourceORMInspection")
    @ElementCollection
    @CollectionTable(name = "Business_Sits")
    @MapKeyColumn(name = "id")
    private Map<Integer,Boolean> bSits = new HashMap<>();
    @SuppressWarnings("JpaDataSourceORMInspection")
    @ElementCollection
    @CollectionTable(name = "Charter_Sits")
    @MapKeyColumn(name = "id")
    private Map<Integer,Boolean> cSits = new HashMap<>();
    private int routePrice;
    @SuppressWarnings("JpaDataSourceORMInspection")
    @OneToOne(targetEntity = RouteType.class)
    @JoinColumn(name = "routeType")
    private RouteType routeType;
    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne(targetEntity = Airport.class)
    @JoinColumn(name = "airport")
    private Airport airport;

    public long getId() {
        return this.id_r;
    }

    public void setId(long id) {
        this.id_r = id;
    }

    public String getWhere() {
        return this.wherel;
    }

    public void setWhere(String where) {
        this.wherel = where;
    }

    public String getFrom() {
        return this.froml;
    }

    public void setFrom(String from) {
        this.froml = from;
    }

    public void setRoutePrice(int routePrice) {
        this.routePrice = routePrice;
    }

    public int getRoutePrice() {
        return this.routePrice;
    }

   public RouteType getRouteType() {
        return this.routeType;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    public Airport getAirport() {
        return this.airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public void setLSits() {
        for (int i=1; i<=this.routeType.getLuxCSits(); i++) {
            this.lSits.put(i, true);
        }
    }

    public void setBSits() {
        for (int i=1; i<=this.routeType.getBusinessCSits(); i++) {
            this.bSits.put(i, true);
        }
    }

    public void setCSits() {
        for (int i=1; i<=this.routeType.getCharterCSits(); i++) {
            this.cSits.put(i, true);
        }
    }

    public Map<Integer, Boolean> getlSits() {
        return this.lSits;
    }

    public Map<Integer, Boolean> getbSits() {
        return this.bSits;
    }

    public Map<Integer, Boolean> getcSits() {
        return this.cSits;
    }

    public Map<Integer, Boolean> getSitsByClass(String c) {
        switch(c){
            case "Lux":
                return this.lSits;
            case "Business":
                return this.bSits;
            case "Charter":
                return this.cSits;
            default:
                return null;
        }
    }
}
