package com.mckinney.services;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class SessionService {

    private static SessionFactory sf;

    static {
        Configuration configuration = new Configuration().configure();

        String url = System.getenv("TravelDB_URL");
        String username = System.getenv("TravelDB_Username");
        String password = System.getenv("TravelDB_Password");

        configuration.setProperty("hibernate.connection.url", url);
        configuration.setProperty("hibernate.connection.username", username);
        configuration.setProperty("hibernate.connection.password", password);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        sf = configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        return sf;
    }

}
