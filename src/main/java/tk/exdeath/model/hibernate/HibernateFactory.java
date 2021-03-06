package tk.exdeath.model.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import tk.exdeath.model.TimeTable;

public class HibernateFactory {

    private HibernateFactory() {
    }

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration config = new Configuration().configure().addAnnotatedClass(TimeTable.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
                sessionFactory = config.buildSessionFactory(builder.build());
            } catch (Exception ex) {
                System.out.println("Exception!" + ex);
            }
        }
        return sessionFactory;
    }

}
