package com.academysmart.aviamodel;

import dao.implementation.PassengerDao;
import dao.implementation.RouteDao;
import dao.interfaces.PassengerDaoInt;
import dao.interfaces.RouteDaoInt;
import exception.PassengerException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ApIT {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2test");
    private EntityManager em;
    private EntityTransaction et;

    @Before
    public void setUp() throws Exception{
        em = emf.createEntityManager();
        et = em.getTransaction();

        RouteDaoInt routeDao = new RouteDao();
        routeDao.setEntityManager(em);
        List<Route> routes = routeDao.getAll();
        et.begin();
        for (Route r : routes) {
            r.setLSits();
            r.setBSits();
            r.setCSits();
            em.merge(r);
        }
        et.commit();

        ConcreteRoute cr = new ConcreteRoute();
        cr.setRoute(em.find(Route.class, 2L));
        cr.setAvBSits();cr.setAvCSits();cr.setAvLuxSits();

        Passenger p = new Passenger();
        p.setFirstName("name");
        p.setSecondName("secondname");
        p.setPatronymic("patronymic");
        p.setPhoneNumber("123446");

        et.begin();
        em.persist(cr);
        em.persist(p);
        et.commit();

        Ticket t = new Ticket();
        t.setPassenger(em.find(Passenger.class, 1L));
        t.setcRoute(em.find(ConcreteRoute.class, 1L));
        t.setBaggage(30);
        t.setMatureType(true);
        t.setcTicketPrice();
        t.setFlightClass("Charter");
        t.setPlace(2);

        et.begin();
        em.persist(t);
        et.commit();
    }

    @After
    public void tearDown() throws Exception{
        if (em != null) {
            em.clear();
        }
    }

    @Test
    public void findPlaneClass() throws Exception{
       RouteType rt = em.find(RouteType.class, "Lux");
       Assert.assertEquals(5, rt.getLuxCSits());
    }

    @Test
    public void findRouteClass() throws Exception{
        Route r = em.find(Route.class, 1L);
        Assert.assertEquals(600, r.getRoutePrice());
    }

    @Test
    public void createConcreteRoute() throws Exception{
        ConcreteRoute acr = em.find(ConcreteRoute.class, 1L);
        Assert.assertEquals("Донецк", acr.getRoute().getWhere());
    }

    @Test
    public void createPassenger() throws Exception{
        Assert.assertEquals("name", em.find(Passenger.class, 1L).getFirstName());
    }

    @Test
    public void createTicket() throws Exception{
        Assert.assertEquals(30, em.find(Ticket.class, 1L).getBaggage());
    }

    @Test
    public void createAirport() throws Exception{
        Airport a = new Airport();
        a.setPortName("portname");
        @SuppressWarnings("unchecked") List<Route> routes = em.createNamedQuery("selectAll").getResultList();
        a.setRoutes(routes);
        et.begin();
        for (Route r : routes)
        {
            r.setAirport(a);
            em.merge(r);
        }
        em.persist(a);
        et.commit();
        Assert.assertEquals("Донецк", em.find(Airport.class, "portname").getRoutes().get(1).getWhere().trim());
    }

    @Test
    public void testRouteDao() {
        RouteDaoInt routeDao = new RouteDao();
        routeDao.setEntityManager(em);
        List<Route> routes = routeDao.getAll();
        Assert.assertEquals(6, routes.size());
    }

    @Test(expected = PassengerException.class)
    public void checkPassenger() throws PassengerException{
        Passenger p = new Passenger();
        PassengerDaoInt pd = new PassengerDao();
        pd.setEntityManager(em);
        Assert.fail(pd.validatePassenger(p));
    }

    @Test
    public void checkSitRoute() {
        Route r = em.find(Route.class, 2L);
        Assert.assertEquals(false, r.getcSits().get(2));
        RouteDaoInt routeDao = new RouteDao();
        routeDao.setEntityManager(em);
        r = routeDao.getRouteByName("Киев", "Донецк");
        Assert.assertEquals(true, r.getcSits().get(54));
    }

}
