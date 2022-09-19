<%-- 
    Document   : header
    Created on : Aug 11, 2022, 1:19:49 PM
    Author     : LAPTOP MSI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/api/notification/${currentUser.id}" var="endpointNotification" />
<nav class="navbar navbar-expand-sm navbar-dark bg-dark sticky-top">
    <div class="container">
        <a title="" href="<c:url value="/"/>"><img style="width: 45px" src="https://images.glints.com/unsafe/glints-dashboard.s3.amazonaws.com/company-logo/b1d593fdcf588342410959c159177dc4.jpg" alt=""></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto" style="align-items: baseline">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/"/>">Trang chu</a>
                </li>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="<c:url value="/login"/>">Đăng nhập</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="<c:url value="/register"/>">Đăng ký</a>
                    </li>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="<c:url value="/profile/${currentUser.id}"/>">
                            <img src="${currentUser.avatar}" alt="avatar"
                                 style="
                                 width: 37px;
                                 height: 37px;
                                 border-radius: 50%;
                                 "
                                 />
                            ${currentUser.firstName} ${currentUser.lastName}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="<c:url value="/logout"/>">Đăng xuất</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="<c:url value="/profile/${currentUser.id}/chatting"/>">Tin nhắn</a>
                    </li>
                    <li class="nav-item" style="cursor: pointer">
                        <a class="nav-link text-danger" onclick="showNoti();">Thông Báo</a>
                        <div class="notiBox" id="notificationBox">
                            <ul id="notiBox-box">
                            </ul>
                        </div>
                    </li>
                </c:if>
            </ul>
            <c:url value="/" var="action"/>
            <form method="get" action="${action}" class="d-flex">
                <input class="form-control me-2" type="text" name="kw" placeholder="Search">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<script>
    function showNoti() {
        var popup = document.getElementById("notificationBox");
        popup.classList.toggle("show");
        if(popup.classList.contains("show"))
          loadNotification('${endpointNotification}');
    }
</script>