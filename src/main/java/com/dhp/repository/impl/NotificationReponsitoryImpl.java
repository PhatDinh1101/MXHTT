/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhp.repository.impl;

import com.dhp.pojo.Auction;
import com.dhp.pojo.Notifications;
import com.dhp.pojo.User;
import com.dhp.repository.NotificationReponsitory;
import com.dhp.repository.UserRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hoang
 */
@Repository
@Transactional
@PropertySource("classpath:messages.properties")
public class NotificationReponsitoryImpl implements NotificationReponsitory {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private UserRepository userReponsitory;

    @Override
    public Notifications addNoti(int userId, String msg) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Notifications n = new Notifications();
            n.setMessage(msg);
            User u = this.userReponsitory.getUserById(userId);
            n.setUserId(u);
            session.save(n);
            return n;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Notifications> getNoti(int userId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Notifications> q = b.createQuery(Notifications.class);
        Root root = q.from(Notifications.class);
        q.select(root);
        
        q.where(b.equal(root.get("userId"), userId));
        q.orderBy(b.asc(root.get("id")));
        
        Query query = session.createQuery(q);
        return query.getResultList();
    }

}
