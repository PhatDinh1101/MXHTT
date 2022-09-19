<%-- 
    Document   : adminleft
    Created on : Aug 24, 2022, 8:08:19 PM
    Author     : LAPTOP MSI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="sidebar">
    <a href="#" class="brand">
        <i class='bx bxs-smile'></i>
        <span class="text">AdminHub</span>
    </a>
    <ul class="side-menu top">
        <li class="active">
            <a href="<c:url value="/admin/manager"/>">
                <i class='bx bxs-dashboard' ></i>
                <span class="text">Người dùng</span>
            </a>
        </li>
        <li>
            <a href="<c:url value="/admin/stats"/>">
                <i class='bx bxs-shopping-bag-alt' ></i>
                <span class="text">Thống kê số lượng bài viết</span>
            </a>
        </li>
        <li>
            <a href="<c:url value="/admin/postStats"/>">
                <i class='bx bxs-doughnut-chart' ></i>
                <span class="text">Thống kê bài viết theo ngày</span>
            </a>
        </li>
        <li>
            <a href="<c:url value="/admin/reports"/>">
                <i class='bx bxs-message-dots' ></i>
                <span class="text">Report</span>
            </a>
        </li>
        <li>
            <a href="#">
                <i class='bx bxs-group' ></i>
                <span class="text">Team</span>
            </a>
        </li>
    </ul>
    <ul class="side-menu">
        <li>
            <a href="#">
                <i class='bx bxs-cog' ></i>
                <span class="text">Settings</span>
            </a>
        </li>
        <li>
            <a href="#" class="logout">
                <i class='bx bxs-log-out-circle' ></i>
                <span class="text">Logout</span>
            </a>
        </li>
    </ul>
</section>


