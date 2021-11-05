package com.mckinney.data;

import com.mckinney.models.Country;
import com.mckinney.services.SessionService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class CountryDaoHibernate implements CountryDao{

    private static SessionFactory sf = SessionService.getSessionFactory();

    @Override
    public Country getCountryByName(String name) {

        Session sess = sf.openSession();

        String hql = "from Country as c where c.countryName = :name";
        Query query = sess.createQuery(hql);
        query.setParameter("name", name);

        return (Country) query.list().get(0);

    }
}
