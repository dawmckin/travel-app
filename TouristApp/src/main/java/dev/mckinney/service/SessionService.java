package dev.mckinney.service;

import dev.mckinney.model.Country;
import dev.mckinney.model.Location;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionService {

    private static SessionFactory sf;

    static {
        Configuration configuration = new Configuration()
                .addPackage("dev.mckinney.data")
                .addAnnotatedClass(Location.class)
                .addAnnotatedClass(Country.class)
                .configure();
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "password";
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
