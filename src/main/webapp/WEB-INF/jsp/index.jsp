<%-- 
    Document   : index
    Created on : Aug 11, 2022, 12:59:09 PM
    Author     : LAPTOP MSI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                        <li><i class="ti-mouse-alt"></i><a href="inbox.html" title="">Inbox</a></li>
                                        <li><i class="ti-files"></i><a href="fav-page.html" title="">My pages</a></li>
                                        <li><i class="ti-user"></i><a href="timeline-friends.html" title="">friends</a></li>
                                        <li><i class="ti-image"></i><a href="timeline-photos.html" title="">images</a></li>
                                        <li><i class="ti-video-camera"></i><a href="timeline-videos.html" title="">videos</a></li>
                                        <li><i class="ti-comments-smiley"></i><a href="messages.html" title="">Messages</a></li>
                                        <li><i class="ti-bell"></i><a href="notifications.html" title="">Notifications</a></li>
                                        <li><i class="ti-share"></i><a href="people-nearby.html" title="">People Nearby</a></li>
                                        <li><i class="fa fa-bar-chart-o"></i><a href="insights.html" title="">insights</a></li>
                                        <li><i class="ti-power-off"></i><a href="landing.html" title="">Logout</a></li>
                                    </ul>
                                </div><!-- Shortcuts -->
                            </aside>
                        </div><!-- sidebar -->
                        <div class="col-lg-6">
                            <div class="central-meta">
                                <div class="new-postbox">
                                    <figure>
                                        <img src="images/resources/admin2.jpg" alt="">
                                    </figure>
                                    <div class="newpst-input">
                                        <form method="post">
                                             <a class="nav-link text-danger" href="<c:url value="/post"/>">Them bai dang</a>
                                        </form>
                                    </div>
                                </div>
                            </div><!-- add post new box -->
                            <div class="loadMore">
                                <c:forEach items="${post}" var="p">
                                    <div class="central-meta item">
                                        <div class="user-post">
                                            <div class="friend-info">
                                                <figure>
                                                    <img src="${p.userId.avatar}" style="height: 45px"  alt="">
                                                </figure>
                                                <div class="friend-name">
                                                    <ins><a href="<c:url value="/profile/${p.userId.id}"/>" title="">${p.userId.firstName} ${p.userId.lastName}</a></ins>
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
                            <div>
                                <ul class="pagination">
                                    <c:forEach begin="1" end="${Math.ceil(postCounter/pageSize)}" var ="i">
                                        <c:url value="/" var="u">
                                            <c:param name="page" value="${i}" />
                                        </c:url>
                                        <li class="page-item"><a class="page-link" href="${u}">${i}</a></li>
                                        </c:forEach>
                                </ul>
                            </div>
                        </div><!-- centerl meta -->
                        <div class="col-lg-3">
                            <aside class="sidebar static">
                                <div class="widget">
                                    <h4 class="widget-title">Your page</h4>	
                                    <div class="your-page">
                                        <figure>
                                            <a href="#" title=""><img src="images/resources/friend-avatar9.jpg" alt=""></a>
                                        </figure>
                                        <div class="page-meta">
                                            <a href="#" title="" class="underline">My page</a>
                                            <span><i class="ti-comment"></i><a href="insight.html" title="">Messages <em>9</em></a></span>
                                            <span><i class="ti-bell"></i><a href="insight.html" title="">Notifications <em>2</em></a></span>
                                        </div>
                                        <div class="page-likes">
                                            <ul class="nav nav-tabs likes-btn">
                                                <li class="nav-item"><a class="active" href="#link1" data-toggle="tab">likes</a></li>
                                                <li class="nav-item"><a class="" href="#link2" data-toggle="tab">views</a></li>
                                            </ul>
                                            <!-- Tab panes -->
                                            <div class="tab-content">
                                                <div class="tab-pane active fade show " id="link1" >
                                                    <span><i class="ti-heart"></i>884</span>
                                                    <a href="#" title="weekly-likes">35 new likes this week</a>
                                                    <div class="users-thumb-list">
                                                        <a href="#" title="Anderw" data-toggle="tooltip">
                                                            <img src="images/resources/userlist-1.jpg" alt="">  
                                                        </a>
                                                        <a href="#" title="frank" data-toggle="tooltip">
                                                            <img src="images/resources/userlist-2.jpg" alt="">  
                                                        </a>
                                                        <a href="#" title="Sara" data-toggle="tooltip">
                                                            <img src="images/resources/userlist-3.jpg" alt="">  
                                                        </a>
                                                        <a href="#" title="Amy" data-toggle="tooltip">
                                                            <img src="images/resources/userlist-4.jpg" alt="">  
                                                        </a>
                                                        <a href="#" title="Ema" data-toggle="tooltip">
                                                            <img src="images/resources/userlist-5.jpg" alt="">  
                                                        </a>
                                                        <a href="#" title="Sophie" data-toggle="tooltip">
                                                            <img src="images/resources/userlist-6.jpg" alt="">  
                                                        </a>
                                                        <a href="#" title="Maria" data-toggle="tooltip">
                                                            <img src="images/resources/userlist-7.jpg" alt="">  
                                                        </a>  
                                                    </div>
                                                </div>
                                                <div class="tab-pane fade" id="link2" >
                                                    <span><i class="ti-eye"></i>440</span>
                                                    <a href="#" title="weekly-likes">440 new views this week</a>
                                                    <div class="users-thumb-list">
                                                        <a href="#" title="Anderw" data-toggle="tooltip">
                                                            <img src="images/resources/userlist-1.jpg" alt="">  
                                                        </a>
                                                        <a href="#" title="frank" data-toggle="tooltip">
                                                            <img src="images/resources/userlist-2.jpg" alt="">  
                                                        </a>
                                                        <a href="#" title="Sara" data-toggle="tooltip">
                                                            <img src="images/resources/userlist-3.jpg" alt="">  
                                                        </a>
                                                        <a href="#" title="Amy" data-toggle="tooltip">
                                                            <img src="images/resources/userlist-4.jpg" alt="">  
                                                        </a>
                                                        <a href="#" title="Ema" data-toggle="tooltip">
                                                            <img src="images/resources/userlist-5.jpg" alt="">  
                                                        </a>
                                                        <a href="#" title="Sophie" data-toggle="tooltip">
                                                            <img src="images/resources/userlist-6.jpg" alt="">  
                                                        </a>
                                                        <a href="#" title="Maria" data-toggle="tooltip">
                                                            <img src="images/resources/userlist-7.jpg" alt="">  
                                                        </a>  
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div><!-- page like widget -->

                            </aside>
                        </div><!-- sidebar -->
                    </div>	
                </div>
            </div>
        </div>
    </div>	
</section>
