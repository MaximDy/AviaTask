package dao.implementation;

import dao.interfaces.TicketDaoInt;
import com.academysmart.aviamodel.Ticket;
import exception.TicketException;
public class TicketDao extends AbsDao<Ticket> implements TicketDaoInt {

    public String validateTicket (Ticket t) throws TicketException {
        if (!t.getMatureType() && t.getFlightClass().equals("Lux"))
        {
            throw new TicketException("Cannot buy child ticket for lux class");
        }
        return null;//later change to return id
    }
}
