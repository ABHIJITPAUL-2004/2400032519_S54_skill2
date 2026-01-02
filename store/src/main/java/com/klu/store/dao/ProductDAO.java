package com.klu.store.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.store.entity.Product;
import com.klu.store.util.ProductUtil;

public class ProductDAO {

    // CREATE
    public void saveProduct(Product p) {
        try (Session session = ProductUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(p);
            tx.commit();
        }
    }

    // READ - all products
    public List<Product> getProducts() {
        try (Session session = ProductUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Product", Product.class).list();
        }
    }

    // READ - by product ID
    public Product getByProductId(int pid) {
        try (Session session = ProductUtil.getSessionFactory().openSession()) {
            return session.get(Product.class, pid);
        }
    }

    // UPDATE
    public boolean updateProduct(Product p) {
        Transaction tx = null;
        try (Session session = ProductUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(p);   // merge also acceptable
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    // DELETE
    public boolean deleteProduct(int pid) {
        Transaction tx = null;
        try (Session session = ProductUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Product p = session.get(Product.class, pid);
            if (p != null) {
                session.delete(p);
            }
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
