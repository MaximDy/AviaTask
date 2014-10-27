package dao.implementation;

import dao.interfaces.PassengerDaoInt;
import com.academysmart.aviamodel.Passenger;
import exception.PassengerException;

public class PassengerDao extends AbsDao<Passenger> implements PassengerDaoInt {
    public String validatePassenger (Passenger p) throws PassengerException {
        if (p.getFirstName() == null || p.getSecondName() == null || p.getPatronymic() == null || p.getPhoneNumber() == null)
        {
            throw new PassengerException("One of the fields is empty");
        }
        return null;//later change to return id
    }
}
