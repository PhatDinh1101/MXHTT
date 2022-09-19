/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhp.service.impl;

import com.dhp.pojo.Auction;
import com.dhp.pojo.Comment;
import com.dhp.pojo.Post;
import com.dhp.pojo.User;
import com.dhp.pojo.Userwinner;
import com.dhp.repository.PostRepository;
import com.dhp.service.PostService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hoang
 */

@Service
public class PostServiceImpl implements PostService{
    
    @Autowired
    private PostRepository postReponsitory;
    

    @Override
    public List<Post> getPost(Map<String, String> params, int page) {
        return this.postReponsitory.getPost(params, page);
    }

    @Override
    public Post addPost(String content, String image, String topic, User UserID) {
        
        Post p = new Post();
        p.setContent(content);
        p.setImage(image);
        p.setTopic(topic);
        p.setUserId(UserID);
        p.setCreatedDate(new Date());
        Date d =new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        p.setUpdatedDate(dateFormat.format(d));
        
        return this.postReponsitory.addPost(p);
        
    }

    @Override
    public boolean deletePost(Post post) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int countPost() {
        return this.postReponsitory.countPost();
    }

    @Override
    public Post getPostById(int id) {
        return this.postReponsitory.getPostById(id);
    }

    @Override
    public List<Comment> getComments(int postId) {
        return this.postReponsitory.getComments(postId);
    }

    @Override
    public Comment addComment(String comment, int postId, User user) {
        return this.postReponsitory.addComment(comment, postId, user);
    }

    @Override
    public List<Auction> getAuctions(int postId) {
        return this.postReponsitory.getAuctions(postId);
    }

    @Override
    public Auction addAuction(String price, int postId, User user) {
        return this.postReponsitory.addAuction(price, postId, user);
    }

    @Override
    public List<Auction> getAuctionsForGuest(int postId, int userId) {
        return this.postReponsitory.getAuctionsForGuest(postId, userId);
    }

    @Override
    public List<Userwinner> getAuctionWinner(int postId) {
        return this.postReponsitory.getAuctionWinner(postId);
    }

    @Override
    public Userwinner addAuctionWinner(String price, int postId, User user) {
        return this.postReponsitory.addAuctionWinner(price, postId, user);
    }

    @Override
    public List<Userwinner> getUserwinnerPyPostId(int id) {
        return this.postReponsitory.getUserwinnerPyPostId(id);
    }

    @Override
    public List<Post> getPostByUserId(int id) {
        return this.postReponsitory.getPostByUserId(id);
    }

    @Override
    public List<Object[]> countPostByUser() {
        return this.postReponsitory.countPostByUser();
    }

    @Override
    public List<Object[]> postStats(Date fromDate, Date toDate) {
        return this.postReponsitory.postStats(fromDate, toDate);
    }
    
}
