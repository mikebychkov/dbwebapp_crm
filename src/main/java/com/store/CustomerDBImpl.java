package com.store;

import com.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDBImpl implements CustomerDB {

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
            Query<Customer> q = session.createQuery("FROM Customer", Customer.class);
            return q.list();
        }
    }
}
