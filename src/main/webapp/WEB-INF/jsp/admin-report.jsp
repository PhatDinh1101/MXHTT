<%-- 
    Document   : report
    Created on : Sep 6, 2022, 9:55:14 PM
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
    <main>
        <div class="head-title">
            <div class="table-data">
                <div class="order">
                    <div class="head">
                        <h3>Danh sách người dùng bị report</h3>
                        <i class='bx bx-search' ></i>
                        <i class='bx bx-filter' ></i>
                    </div>
                    <table class="table">
                        <tr>
                            <th>Người dùng</th>
                            <th>Nội dung</th>
                            <th>Ngày đăng</th>
                            <th>Bởi người dùng</th>

                        </tr>
                        <c:forEach items="${report}" var="r">
                            <tr>
                                <td>
                                    <img src="${r.userReport.avatar}">
                                    <p>${r.userReport.firstName}</p>
                                </td>
                                <td>${r.content}</td>
                                <td>${r.createdDate}</td>
                                <td>
                                    ${r.userId.firstName}
                                </td>
                            </tr>
                        </c:forEach>

                    </table>
                    <div class="col-md-6 col-xs-12">
                        <canvas id="myChart"></canvas>
                    </div>
                </div>

            </div>
    </main>
</section>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>