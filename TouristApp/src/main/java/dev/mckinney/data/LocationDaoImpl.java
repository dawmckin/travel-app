package dev.mckinney.data;

import dev.mckinney.model.Country;
import dev.mckinney.model.Location;
import dev.mckinney.service.SessionService;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class LocationDaoImpl implements LocationDao{

    private static SessionFactory sf = SessionService.getSessionFactory();

    @Override
    public List<Location> getAllLocations() {
        Session session = sf.openSession();
        String hql = "from Location";
        Query query = session.createQuery(hql);
        return query.list();
    }

    @Override
    public List<Location> getLocationsByCountry(Country country) {
        Session session = sf.openSession();
        String hql = "from Location where country_id = :country";
        Query query = session.createQuery(hql);
        query.setParameter("country", country.getCountryId());
        return query.list();
    }

    @Override
    public Location getLocationById(int locationId) {
        Session session = sf.openSession();
        return (Location) session.get(Location.class, locationId);
    }

    @Override
    public Location getLocationByName(String name) {
        Session session = sf.openSession();
        Criteria criteria = session.createCriteria(Location.class)
                .add(Restrictions.eq("location_name", name));
        return (Location) criteria.list().get(0);
    }

    @Override
    public void deleteLocation(Location location) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        tx.commit();
        session.delete(location);
    }

    @Override
    public Location createLocation(Location location) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(location);
        tx.commit();
        return location;
    }

    @Override
    public Location updateLocation(Location location) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.update(location);
        tx.commit();
        return location;
    }
}
