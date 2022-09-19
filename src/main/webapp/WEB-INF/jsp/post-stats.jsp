<%-- 
    Document   : post-stats
    Created on : Sep 3, 2022, 9:08:27 PM
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
                        <h3>Thong ke bao cao</h3>
                        <i class='bx bx-search' ></i>
                        <i class='bx bx-filter' ></i>
                    </div>
                    <form action="<c:url value="/admin/postStats"/>">
                        <div class="form-group">
                            <label>Tu thoi diem</label>
                            <input type="date" name="fromDate" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>Den thoi diem</label>
                            <input type="date" name="toDate" class="form-control"/>
                        </div>
                        <input type="submit" value="Bao Cao" class="btn btn-success"/>
                    </form>
                    <table class="table">
                        <tr>
                            <th>Id</th>
                            <th>User</th>
                            <th>So bai viet</th>
                        </tr>
                        <c:forEach items="${postStatsByDay}" var="p">
                            <tr>
                                <td>${p[0]}</td>
                                <td>${p[1]}</td>
                                <td>${p[2]}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div class="col-md-6 col-xs-12">
                        <canvas id="myChart2"></canvas>
                    </div>
                </div>

            </div>
    </main>
</section>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value = "/js/stats.js"/>"></script>
<script>
    window.onload = function () {
        let data1 = [];
        let labels1 = [];
    <c:forEach items="${postStatsByDay}" var="p">
        data1.push(${p[2]});
        labels1.push("${p[1]}");
    </c:forEach>
        postStatsByDay(labels1, data1);
    }
</script>