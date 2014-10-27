package com.academysmart.aviamodel;

import javax.persistence.*;

@Entity
public class Ticket {
    @OneToOne(targetEntity = ConcreteRoute.class)
    private ConcreteRoute cRoute;
    @ManyToOne
    private Passenger passenger;
    private int cTicketPrice;
    private String flightClass;
    private int baggage;
    private boolean matureType;
    private int place;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_ticket_gen")
    @SequenceGenerator(name = "id_ticket_gen", sequenceName = "id_ticket_seq")
    private long ticketId;

    public long getTicketId() {
        return this.ticketId;
    }

    public int getCTicketPrice() {
        return this.cTicketPrice;
    }

    public String getFlightClass() {
        return this.flightClass;
    }

    public int getBaggage() {
        return this.baggage;
    }

    public boolean getMatureType() {
        return this.matureType;
    }

    public int getPlace() {
        return this.place;
    }

    public String getDate() {
        return this.cRoute.getFlightDate();
    }

    public String getRouteName() {
        return (this.cRoute.getRoute().getFrom() + "-" + this.cRoute.getRoute().getWhere());
    }

    public Passenger getPassenger() {
        return this.passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setPlace(int place) {
        this.place = place;
        this.cRoute.getRoute().getSitsByClass(this.flightClass).put(this.place, false);
    }

    public void setMatureType(boolean matureType) {
        this.matureType = matureType;
    }

    public void setBaggage(int baggage) {
        this.baggage = baggage;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public void setcTicketPrice() {
        if (this.matureType)
        {
            this.cTicketPrice = this.cRoute.getRoute().getRoutePrice() + this.baggage*40;
        }
        else
        {
            this.cTicketPrice = (int)(this.cRoute.getRoute().getRoutePrice()*0.8) + this.baggage*40;
        }
    }

    public void setcRoute(ConcreteRoute cRoute) {
        this.cRoute = cRoute;
    }
}
