package com.store;

import com.model.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDBImpl implements CustomerDB {

    private static final Logger logger = LogManager.getLogger(CustomerDBImpl.class);

    private SessionFactory sf;

    @Autowired
    public CustomerDBImpl(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public Customer getCustomer(int id) {
        try (Session session = sf.openSession()) {
            return session.get(Customer.class, id);
        }
    }

    @Override
    public List<Customer> getCustomers() {
        try (Session session = sf.openSession()) {
            Query<Customer> q = session.createQuery("FROM Customer ORDER BY lastName", Customer.class);
            return q.list();
        }
    }

    @Override
    public Customer save(Customer customer) {
        try (Session session = sf.openSession()) {
            session.save(customer);
        }
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.update(customer);
            session.getTransaction().commit();
        }
        return customer;
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
        Session currSession = sf.getCurrentSession();
        currSession.saveOrUpdate(customer);
        return customer;
    }

    @Override
    public void delete(Customer customer) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.delete(customer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteWithACurrentSession(Customer customer) {
        Session currSession = sf.getCurrentSession();
        currSession.delete(customer);
    }

    @Override
    public void deleteWithACurrentSession(int id) {
        Session currSession = sf.getCurrentSession();
        //currSession.delete(currSession.get(Customer.class, id));
        Query<Customer> q = currSession.createQuery("DELETE FROM Customer WHERE id=:id");
        q.setParameter("id", id);
        q.executeUpdate();
    }
}
