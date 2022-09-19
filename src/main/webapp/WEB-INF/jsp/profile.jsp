<%-- 
    Document   : profile
    Created on : Aug 15, 2022, 3:38:45 PM
    Author     : LAPTOP MSI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
    <div>
        <figure><img style="width: 100%; height: 470px" src="https://res.cloudinary.com/dj5vdnbai/image/upload/v1661077859/wia8g98x15zjhzpuyclz.jpg"></figure>
        <div class="container-fluid">
            <div class="row merged">
                <div class="col-lg-3 col-sm-3">


                    <div class="user-avatar">
                        <figure>
                            <img style="width: 100%" src="${user.avatar}" alt="">
                        </figure>
                    </div>
                </div>
                <div class="col-lg-7 col-sm-9">
                    <div class="timeline-info">
                        <ul>
                            <li class="admin-name">
                                <h5>${user.firstName} ${user.lastName}</h5>
                            </li>
                            <li>
                                <a class="active" href="<c:url value="/page404"/>" title="" data-ripple="">Page</a>
                                <a class="" href="<c:url value="/report"/>" title="" data-ripple="">Notifications</a>
                                <a class="" href="inbox.html" title="" data-ripple="">inbox</a>
                                <a class="" href="insights.html" title="" data-ripple="">insights</a>
                                <a class="" href="fav-page.html" title="" data-ripple="">posts</a>
                                <a class="" href="<c:url value="/profile/${user.id}/reports"/>" title="" data-ripple="">Report</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<section>
    <div class="gap gray-bg">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <div class="row" id="page-contents">
                        <div class="col-lg-3">
                            <aside class="sidebar static">
                                <div class="widget">
                                    <h4 class="widget-title">Shortcuts</h4>
                                    <ul class="naves">
                                        <li><i class="ti-clipboard"></i><a href="newsfeed.html" title="">News feed</a></li>
                                    </ul>
                                </div>
                            </aside>
                        </div><!-- sidebar -->
                        <div class="col-lg-6">
                            <div class="loadMore">
                                <c:forEach items="${post}" var="p">
                                    <div class="central-meta item">
                                        <div class="user-post">
                                            <div class="friend-info">
                                                <figure>
                                                    <img src="${p.userId.avatar}" style="height: 45px"  alt="">
                                                </figure>
                                                <div class="friend-name">
                                                    <ins><a href="time-line.html" title="">${p.userId.firstName} ${p.userId.lastName}</a></ins>
                                                    <span>published: ${p.createdDate}</span>
                                                </div>
                                                <div class="post-meta">
                                                    <h2>${p.topic}</h2>
                                                    <img class="card-img-top" clas="img-fluid" src="${p.image}" height="315" alt="Card image">

                                                    <div class="description">
                                                        <p>
                                                            ${p.content}
                                                        </p>
                                                    </div>
                                                    <div class="row">  
                                                        <div class="col">
                                                            <i class="fa fa-heart"></i>
                                                            Like
                                                        </div>
                                                        <div class="col">
                                                            <i class="fa fa-comment"></i>
                                                            Comments
                                                        </div>
                                                        <div class="col">
                                                            <i class="fa fa-share"></i>
                                                            Share
                                                        </div>
                                                    </div>
                                                    <div class="we-video-info">
                                                        <a href="<c:url value="/post/${p.id}"/>" class="btn btn-primary">Xem chi tiet</a>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div><!-- centerl meta -->
                        <div class="col-lg-3">
                            <aside class="sidebar static">
                                <div class="widget">
                                    <h4 class="widget-title">Invite friends</h4>
                                    <ul class="invition">
                                        <li>
                                            <figure><img src="images/resources/friend-avatar8.jpg" alt=""></figure>
                                            <div class="friend-meta">
                                                <h4><a href="time-line.html" class="underline" title="">Sophia hayat</a></h4>
                                                <a href="#" title="" class="invite" data-ripple="">invite</a>
                                            </div>
                                        </li>
                                        <li>
                                            <figure><img src="images/resources/friend-avatar4.jpg" alt=""></figure>
                                            <div class="friend-meta">
                                                <h4><a href="time-line.html" class="underline" title="">Issabel kaif</a></h4>
                                                <a href="#" title="" class="invite" data-ripple="">invite</a>
                                            </div>
                                        </li>
                                        <li>
                                            <figure><img src="images/resources/friend-avatar2.jpg" alt=""></figure>
                                            <div class="friend-meta">
                                                <h4><a href="time-line.html" class="underline" title="">Kelly Bill</a></h4>
                                                <a href="#" title="" class="invite" data-ripple="">invite</a>
                                            </div>
                                        </li>
                                        <li>
                                            <figure><img src="images/resources/friend-avatar3.jpg" alt=""></figure>
                                            <div class="friend-meta">
                                                <h4><a href="time-line.html" class="underline" title="">Allen jhon</a></h4>
                                                <a href="#" title="" class="invite" data-ripple="">invite</a>
                                            </div>
                                        </li>
                                        <li>
                                            <figure><img src="images/resources/friend-avatar6.jpg" alt=""></figure>
                                            <div class="friend-meta">
                                                <h4><a href="time-line.html" class="underline" title="">tom Andrew</a></h4>
                                                <a href="#" title="" class="invite" data-ripple="">invite</a>
                                            </div>
                                        </li>
                                    </ul>
                                </div><!-- invite for page  -->
                            </aside>
                        </div><!-- sidebar -->
                    </div>	
                </div>
            </div>
        </div>
    </div>
</section>