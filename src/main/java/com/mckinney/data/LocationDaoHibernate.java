package com.mckinney.data;

import com.mckinney.models.Country;
import com.mckinney.models.Location;
import com.mckinney.services.SessionService;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class LocationDaoHibernate implements LocationDao{

    private static SessionFactory sf = SessionService.getSessionFactory();

    @Override
    public List<Location> getLocationsByCountry(Country country) {

        Session sess = sf.openSession();

        String hql = "from Location where country = :countryParam";
        Query query = sess.createQuery(hql);
        query.setParameter("countryParam", country);

        return query.list();
    }

    @Override
    public Location getLocationById(int locationId) {
        Session sess = sf.openSession();
        return (Location) sess.get(Location.class, locationId);
    }

    @Override
    public Location getLocationByName(String name) {
        Session sess = sf.openSession();
        Criteria crit = sess.createCriteria(Location.class)
                .add(Restrictions.eq("name", name));
        return (Location) crit.list().get(0);
    }

    @Override
    public void deleteLocation(Location location) {
        Session sess = sf.openSession();
        sess.delete(location);
    }

    @Override
    public Location createLocation(Location location) {
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        sess.save(location);
        tx.commit();
        return location;
    }

    @Override
    public Location updateLocation(Location location) {
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        sess.update(location);
        tx.commit();
        return location;
    }
}
