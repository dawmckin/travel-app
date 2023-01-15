package dev.mckinney.data;

import dev.mckinney.model.Country;
import dev.mckinney.service.SessionService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;

import java.util.List;

public class CountryDaoImpl implements CountryDao {

    private static SessionFactory sf = SessionService.getSessionFactory();

    @Override
    public Country getCountryByName(String countryName) {

        Session session = sf.openSession();
        String hql = "from Country as c where c.countryName = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", countryName);
        return (Country) query.list().get(0);
    }

    @Override
    public List<Country> getAllCountries() {

        Session session = sf.openSession();
        Query query = session.createQuery("from Country");
        return query.list();
    }

    @Override
    public Country createCountry(Country country) {

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        int id = (int) session.save(country);
        country.setCountryId(id);
        System.out.println("Inserted Country: " + country);
        tx.commit();
        session.close();
        return country;
    }
}
