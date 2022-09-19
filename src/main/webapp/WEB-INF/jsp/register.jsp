<%-- 
    Document   : register
    Created on : Aug 11, 2022, 7:50:16 PM
    Author     : LAPTOP MSI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/register" var="action"/>

<c:if test="${param.error !=null}">
    <div class="alert alert-danger">
        Da co loi
    </div>
</c:if>
<section class="gradient-custom">
    <div class="container py-5 h-100">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col-12 col-lg-8 col-xl-12">
                <div class="card bg-dark" style="border-radius: 15px;">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>
                        <form:form class="mx-1 mx-md-4" method="post" action="${action}" modelAttribute="user" enctype ="multipart/form-data">
                            <div class="row">
                                <div class="col-md-6 mb-4">
                                    <div class="form-outline">
                                        <form:input type="text" id="firstname" path="firstName" class="form-control form-control-lg" />
                                        <label class="form-label" for="firstName">First Name</label>
                                    </div>
                                </div>
                                <div class="col-md-6 mb-4">
                                    <div class="form-outline">
                                        <form:input type="text" id="lastname" path="lastName" class="form-control form-control-lg"  />
                                        <label class="form-label" for="lastname">Last Name</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-4 d-flex align-items-center">
                                    <div class="form-outline datepicker w-100">
                                        <form:input type="text" id="username" path="username" class="form-control form-control-lg" />
                                        <label class="form-label" for="username">Username: </label>
                                    </div>
                                </div>
                                <div class="col-md-6 mb-4 d-flex align-items-center">
                                    <div class="form-outline datepicker w-100">
                                        <form:input type="text" id="sex" path="sex" class="form-control form-control-lg" />
                                        <label class="form-label" for="sex">Sex</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-4 d-flex align-items-center">
                                    <div class="form-outline datepicker w-100">
                                        <form:input type="password" id="password" path="password" class="form-control form-control-lg" />
                                        <label class="form-label" for="password">Password</label>
                                    </div>
                                </div>
                                <div class="col-md-6 mb-4 d-flex align-items-center">
                                    <div class="form-outline datepicker w-100">
                                        <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control form-control-lg"/>
                                        <label class="form-label" for="confirm-password">Confirm Password</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-4 pb-2">
                                    <div class="form-outline">
                                        <form:input type="email" id="email" path="email" class="form-control form-control-lg" />
                                        <label class="form-label" for="email">Email</label>
                                    </div>
                                </div>
                                <div class="col-md-6 mb-4 pb-2">
                                    <div class="form-outline">
                                        <form:input type="text" id="phone" path="phone" class="form-control form-control-lg"/>
                                        <label class="form-label" for="phone">Phone</label>
                                    </div>
                                </div>
                            </div>
                            <div class="d-flex flex-row align-items-center mb-4">
                                <div class="form-outline flex-fill mb-0">
                                    <form:input type="date" id="dateBirth" path="dateBirth" class="form-control" />
                                    <label class="form-label" for="datebirth">Date of birth</label>
                                </div>
                            </div>
                            <div class="d-flex flex-row align-items-center mb-4">
                                <div class="form-outline flex-fill mb-0">
                                    <form:input type="file" id="avatar" path="file" class="form-control" />
                                    <label class="form-label" for="avatar">Avatar</label>
                                </div>
                            </div>
                            <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                <input type="submit" value="Đăng Ký"/> 
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>