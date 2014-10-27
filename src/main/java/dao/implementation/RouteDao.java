package dao.implementation;

import dao.interfaces.RouteDaoInt;
import com.academysmart.aviamodel.Route;

public class RouteDao extends AbsDao<Route> implements RouteDaoInt {
    public RouteDao() {
    }

    @Override
    public Route getRouteByName(String from, String where) {
        return (Route) entityManager
                .createQuery("FROM Route WHERE froml=:froml AND wherel= :wherel")
                .setParameter("froml", from)
                .setParameter("wherel", where)
                .getSingleResult();
    }
}
