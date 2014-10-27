package dao.interfaces;

import com.academysmart.aviamodel.Route;

public interface RouteDaoInt extends GenericDAO<Route> {
    public Route getRouteByName(String from, String where);
}
