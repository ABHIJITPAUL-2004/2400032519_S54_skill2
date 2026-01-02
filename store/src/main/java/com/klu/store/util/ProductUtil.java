package com.klu.store.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductUtil {

    private static SessionFactory sf;

    static {
        try {
            sf = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    // Get SessionFactory
    public static SessionFactory getSessionFactory() {
        return sf;
    }

    // Close SessionFactory
    public static void shutdown() {
        if (sf != null) {
            sf.close();
        }
    }
}
