/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhp.service;

import com.dhp.pojo.Auction;
import com.dhp.pojo.Comment;
import com.dhp.pojo.Post;
import com.dhp.pojo.User;
import com.dhp.pojo.Userwinner;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LAPTOP MSI
 */
public interface PostService{
    List<Post> getPost(Map<String, String> params, int page);
    Post getPostById(int id);
    Post addPost(String content, String image, String topic, User  UserID);
    boolean deletePost(Post post);
    List<Post> getPostByUserId(int id);
    int countPost();
    List<Comment> getComments(int postId);
    Comment addComment(String comment, int postId, User user);
     
    List<Auction> getAuctions(int postId);
    List<Auction> getAuctionsForGuest(int postId, int userId);
    Auction addAuction(String price, int postId, User user); 
    
    List<Userwinner> getAuctionWinner(int postId);
    List<Userwinner> getUserwinnerPyPostId(int id);
    Userwinner addAuctionWinner(String price, int postId, User user); 
    
    List<Object[]> countPostByUser();
    List<Object[]> postStats(Date fromDate, Date toDate);
}
