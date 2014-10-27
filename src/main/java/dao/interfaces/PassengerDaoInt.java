package dao.interfaces;

import com.academysmart.aviamodel.Passenger;
import exception.PassengerException;

public interface PassengerDaoInt extends GenericDAO<Passenger> {
    public String validatePassenger(Passenger p) throws PassengerException;
}
