<%-- 
    Document   : admin
    Created on : Aug 24, 2022, 8:13:21 PM
    Author     : LAPTOP MSI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="content">
    <!-- NAVBAR -->
    <nav>
        <i class='bx bx-menu' ></i>
        <a href="#" class="nav-link">Categories</a>
        <form action="#">
            <div class="form-input">
                <input type="search" placeholder="Search...">
                <button type="submit" class="search-btn"><i class='bx bx-search' ></i></button>
            </div>
        </form>
        <input type="checkbox" id="switch-mode" hidden>
        <label for="switch-mode" class="switch-mode"></label>
        <a href="#" class="notification">
            <i class='bx bxs-bell' ></i>
            <span class="num">8</span>
        </a>
        <a href="#" class="profile">
             <img src="${currentUser.avatar}" alt="avatar">
        </a>
    </nav>
    <!-- NAVBAR -->

    <!-- MAIN -->
    <main>
        <div class="head-title">
            <div class="left">
                <h1>Dashboard</h1>
                <ul class="breadcrumb">
                    <li>
                        <a href="#">Dashboard</a>
                    </li>
                    <li><i class='bx bx-chevron-right' ></i></li>
                    <li>
                        <a class="active" href="#">Home</a>
                    </li>
                </ul>
            </div>
            <a href="#" class="btn-download">
                <i class='bx bxs-cloud-download' ></i>
                <span class="text">Download PDF</span>
            </a>
        </div>

        <ul class="box-info">
            <li>
                <i class='bx bxs-calendar-check' ></i>
                <span class="text">
                    <h3>${countUser}</h3>
                    <p>Người dùng</p>
                </span>
            </li>
            <li>
                <i class='bx bxs-group' ></i>
                <span class="text">
                    <h3>${postCounter}</h3>
                    <p>Số lượng bài viết</p>
                </span>
            </li>
            <li>
                <i class='bx bxs-dollar-circle' ></i>
                <span class="text">
                    <h3>$2543</h3>
                    <p>Total Sales</p>
                </span>
            </li>
        </ul>


        <div class="table-data">
            <div class="order">
                <div class="head">
                    <h3>Recent Orders</h3>
                    <i class='bx bx-search' ></i>
                    <i class='bx bx-filter' ></i>
                </div>
                <table class="table">
                    <tr>
                        <th>User</th>
                        <th>Role</th>
                        <th>Status</th>
                    </tr>
                    <tbody>
                        <c:forEach items="${user}" var="u">
                            <tr>
                                <td>
                                    <img src="${u.avatar}">
                                    <p>${u.username}</p>
                                </td>
                                <td>${u.userRole}</td>
                                <td><span class="status completed">Active</span></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <ul class="pagination">
                    <c:forEach begin="1" end="${Math.ceil(countUser/pageSize)}" var ="i">
                        <c:url value="/admin/manager" var="u">
                            <c:param name="page" value="${i}" />
                        </c:url>
                        <li class="page-item"><a class="page-link" href="${u}">${i}</a></li>
                        </c:forEach>
                </ul>
            </div>

        </div>
    </main>
    <!-- MAIN -->
</section>