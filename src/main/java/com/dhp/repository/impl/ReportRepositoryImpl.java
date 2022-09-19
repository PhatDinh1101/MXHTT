/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhp.repository.impl;

import com.dhp.pojo.Comment;
import com.dhp.pojo.Report;
import com.dhp.pojo.User;
import com.dhp.pojo.Userwinner;
import com.dhp.repository.ReportRepository;
import com.dhp.repository.UserRepository;
import java.util.HashSet;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LAPTOP MSI
 */
@Repository
@Transactional
public class ReportRepositoryImpl implements ReportRepository{
    @Autowired
    private UserRepository userReponsitory;
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Report> getReports(int userId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Report> q = b.createQuery(Report.class);
        Root root = q.from(Report.class);
        q.select(root);
        
        q.where(b.equal(root.get("userReport"), userId));
        
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Report addReport(String report, int userWinnerId,User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Report c = new Report();
        c.setContent(report);
        c.setUserReport(this.userReponsitory.getUserById(userWinnerId));
        c.setUserId(user);
        session.save(c);
        return c;
    }

    @Override
    public Userwinner getUserwinner(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Userwinner.class, id);
    }

    @Override
    public List<Report> getListReports() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Report");
        return q.getResultList();
    }

   
    
    
}
