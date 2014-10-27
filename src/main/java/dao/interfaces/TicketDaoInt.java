package dao.interfaces;

import dao.interfaces.GenericDAO;
import com.academysmart.aviamodel.Ticket;
import exception.TicketException;

public interface TicketDaoInt extends GenericDAO<Ticket> {
    public String validateTicket(Ticket t) throws TicketException;
}
