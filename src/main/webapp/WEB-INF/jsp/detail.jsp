<%-- 
    Document   : detail
    Created on : Aug 22, 2022, 5:22:43 PM
    Author     : LAPTOP MSI
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link rel="stylesheet" href="<c:url value="/css/listAuction.css"/>"/>
<c:url value="/api/notification/${post.userId.id}" var="endpointNotification" />
<h1>Đấu giá sản phẩm </h1>
<div class="card"> 
    <div class="container-fliud"> 
        <div class="wrapper row"> 
            <div class="preview col-md-6"> 
                <div class="preview-pic tab-content"> 
                    <div class="tab-pane active" id="pic-1"><img src="${post.image}" alt="">    </div> 
                </div> 
            </div> 
            <div class="details col-md-6"> 
                <h3 class="product-title">${post.topic}</h3> 
                <p class="product-description">${post.content}</p> 
                <h4 class="price">Giá khởi điểm: 2.000.000 vnđ</h4>
                <sec:authorize access="!isAuthenticated()">
                    <a href="<c:url value="/login" />"><button type="button" class="btn btn-outline-primary">Vui lòng đăng nhập để tham gia đấu giá</button></a>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <div class="action"> 
                        <c:if test="${post.userId.username != currentUser.username}">
                            <c:url value="/api/post/${post.id}/auctions/guest" var="endpointAuction" />
                            <c:url value="/api/post/${post.id}/auctionWinner" var="endpointAuctionWinner" />
                            <a href="#" class="btn btn-primary" id="auctionButton">
                                <button class="btn btn-primary" type="button">Đấu giá ngay</button>            
                            </a>
                            <span id="notiforAuctionWinner" style="display: none"><em>Buổi đấu giá đã hoàn thành!!!</em></span>
                        </c:if>

                        <div class="form-group" style="display: none" id="auctionForm">
                            <label for="usr"><strong>Mức giá đưa ra:</strong>:</label>
                            <input type="text" class="form-control" id="priceAuction">
                            <br>
                            <a href="#" class="btn btn-success" id="auctionButton2">
                                <button class="btn btn-success" type="button">Đấu giá</button>            
                            </a> 
                        </div>
                        <hr>
                        <div class="row">  
                            <div class="col">
                                <i class="fa fa-heart"></i>
                                Like
                            </div>
                            <div class="col">
                                <i class="fa fa-share"></i>
                                Share
                            </div>
                        </div> 
                        <c:if test="${post.userId.username == currentUser.username}">
                            <c:url value="/api/post/${post.id}/auctions" var="endpointAuction" />
                            <c:url value="/api/post/${post.id}/auctionWinner" var="endpointAuctionWinner" />
                        </c:if>
                        <strong>Người chiến thắng:</strong>
                        <div class="row border" style="width: 100%; margin-top: 20px">
                            <div class="col-sm-12" style="padding: 0px;">
                                <div class=" d-flex justify-content-center" style="max-height: 355px">
                                    <div class="list list-row card" id="sortable2" data-sortable-id="0" aria-dropeffect="move" style="margin: 0px; width: 100%;">
                                    </div>
                                </div> 
                            </div>     
                        </div> 
                        <strong>Danh sách người tham gia đấu giá:</strong>
                        <div class="row border" style="width: 100%; margin-top: 20px">
                            <div class="col-sm-12" style="padding: 0px; overflow-y: scroll">

                                <div class=" d-flex justify-content-center" style="max-height: 355px; min-height: 150px">
                                    <div class="list list-row card" id="sortable" data-sortable-id="0" aria-dropeffect="move" style="margin: 0px; width: 100%;">
                                    </div>
                                </div>
                            </div>     
                        </div> 
                    </div> 
                </sec:authorize>
            </div> 
        </div>
        <hr>
        <div class="wrapper row"> 

            <div class="preview col-md-6" style="padding-bottom: 10px">  Comments
                <br>

                <c:url value="/api/post/${post.id}/comments" var="endpoint" />
                <sec:authorize access="!isAuthenticated()">
                    <a href="<c:url value="/login" />"><button type="button" class="btn btn-outline-primary">Vui lòng đăng nhập để bình luận</button></a>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <div class="form-group">
                        <textarea class="form-control" id="commentId" placeholder="Nhap noi dung"></textarea>
                    </div>
                    <button class="btn btn-danger" onclick="addComment('${endpoint}', ${post.id})"">Them binh luan</button>
                </sec:authorize>
            </div>
            <ul id="comments">
                <li></li>
            </ul>

        </div>
    </div> 
</div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
<script src="<c:url value="/js/api.js" />"></script>


<script>
                        window.onload = async function () {
                            loadComment('${endpoint}');
                            await loadAuctions('${endpointAuction}', () => {
    <c:if test="${post.userId.username != currentUser.username}">
                                var boxesAuction = Array.from(document.getElementsByClassName("auctionWinner"));
                                boxesAuction.forEach(box => {
                                    box.remove();
                                });
                                var boxesAuction = Array.from(document.getElementsByClassName("edit"));
                                boxesAuction.forEach(box => {
                                    box.remove();
                                });
    </c:if>
                            });
                            await loadAuctionWinner('${endpointAuctionWinner}', () => {
    <c:if test="${not empty userWinner[0].userID.username}">
                                $("#auctionButton").css("display", "none");
                                $("#notiforAuctionWinner").css("display", "block");
                                var boxesAuction = Array.from(document.getElementsByClassName("auctionWinner"));
                                boxesAuction.forEach(box => {
                                    box.remove();
                                });
                                var boxesAuction = Array.from(document.getElementsByClassName("edit"));
                                boxesAuction.forEach(box => {
                                    box.remove();
                                });
    </c:if>
                            });


                            $("#auctionButton").click(function () {
                                $("#auctionButton").css("display", "none");
                                $("#auctionForm").css("display", "block");
                            });

                            $("#auctionButton2").click(function () {
                                var price = $("#priceAuction").val();
                                var notification = `${currentUser.firstName} ${currentUser.lastName} đã đấu giá bài viết ${post.topic} của bạn với giá ` + price;
                                addAuction('http://localhost:8080/BTL/api/post/' + '${post.id}/auctions', ${post.id}, price);
                                addNotification('${endpointNotification}',${post.userId.id},notification);
                            });
                        };
</script>


