/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhp.repository.impl;

import com.dhp.pojo.Auction;
import com.dhp.pojo.Comment;
import com.dhp.pojo.Post;
import com.dhp.pojo.User;
import com.dhp.pojo.Userwinner;
import com.dhp.repository.PostRepository;
import com.dhp.repository.UserRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LAPTOP MSI
 */
@Repository
@Transactional
@PropertySource("classpath:messages.properties")
public class PostRepositoryImpl implements PostRepository {

    @Autowired
    private UserRepository userRepostitory;
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public List<Post> getPost(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Post> q = b.createQuery(Post.class);
        Root root = q.from(Post.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("content").as(String.class), String.format("%%%s%%", kw));
                predicates.add(p);
            }

            q.where(predicates.toArray(Predicate[]::new));
        }
        q.orderBy(b.desc(root.get("id")));

        Query query = session.createQuery(q);

        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }

    @Override
    public Post addPost(Post post) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(post);
            return post;

        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean deletePost(Post post) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int countPost() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT COUNT(*) From Post");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public Post getPostById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Post.class, id);
    }

    @Override
    public List<Comment> getComments(int postId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Comment> q = b.createQuery(Comment.class);
        Root root = q.from(Comment.class);
        q.select(root);

        q.where(b.equal(root.get("postId"), postId));
        q.orderBy(b.desc(root.get("id")));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Comment addComment(String comment, int postId, User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Comment c = new Comment();
        c.setComment(comment);
        c.setPostId(this.getPostById(postId));
        c.setUserId(user);
        session.save(c);
        return c;
    }

    @Override
    public List<Auction> getAuctions(int postId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Auction> q = b.createQuery(Auction.class);
        Root root = q.from(Auction.class);
        q.select(root);

        q.where(b.equal(root.get("postId"), postId));
        q.orderBy(b.desc(root.get("price")));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Auction addAuction(String price, int postId, User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Auction a = new Auction();
        a.setPrice(price);
        a.setPostId(this.getPostById(postId));
        a.setUserId(user);
        session.save(a);
        return a;
    }

    @Override
    public List<Auction> getAuctionsForGuest(int postId, int userId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Auction> q = b.createQuery(Auction.class);
        Root root = q.from(Auction.class);
        q.select(root);

        q.where(b.equal(root.get("postId"), postId), b.equal(root.get("userId"), userId));
        q.orderBy(b.desc(root.get("price")));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Userwinner> getAuctionWinner(int postId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Userwinner> q = b.createQuery(Userwinner.class);
        Root root = q.from(Userwinner.class);
        q.select(root);

        q.where(b.equal(root.get("postID"), postId));
        q.orderBy(b.desc(root.get("price")));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Userwinner addAuctionWinner(String price, int postId, User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Userwinner a = new Userwinner();
        a.setPrice(price);
        a.setPostID(this.getPostById(postId));
        a.setUserID(user);
        session.save(a);
        return a;
    }

    @Override
    public List<Userwinner> getUserwinnerPyPostId(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Userwinner> q = b.createQuery(Userwinner.class);
        Root root = q.from(Userwinner.class);
        q.select(root);

        q.where(b.equal(root.get("postID"), id));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Post> getPostByUserId(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Post> q = b.createQuery(Post.class);
        Root root = q.from(Post.class);
        q.select(root);
        q.where(b.equal(root.get("userId"), id));
        q.orderBy(b.desc(root.get("id")));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> countPostByUser() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rP = q.from(Post.class);
        Root rU = q.from(User.class);

        q.where(b.equal(rP.get("userId"), rU.get("id")));
        q.multiselect(rU.get("id"), rU.get("firstName"), b.count(rP.get("id")));
        q.groupBy(rU.get("id"));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> postStats(Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rP = q.from(Post.class);
        Root rU = q.from(User.class);

        List<Predicate> predicates = new ArrayList<>();
        q.multiselect(rU.get("id"), rU.get("firstName"), b.count(rP.get("id")));
        
        predicates.add(b.equal(rP.get("userId"), rU.get("id")));
        if (fromDate != null ) {
            predicates.add(b.greaterThanOrEqualTo(rP.get("createdDate"), fromDate));
        }

        if (toDate != null) {
            predicates.add(b.lessThanOrEqualTo(rP.get("createdDate"), toDate));
        }
        q.where(predicates.toArray(new Predicate[]{}));
        q.groupBy(rU.get("id"));
       
        Query query = session.createQuery(q);
        return query.getResultList();
    }

}
