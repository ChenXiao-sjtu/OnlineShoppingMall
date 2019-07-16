<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminWebNavigator.jsp"%>

<script>
</script>

<title>用户管理</title>


<div class="workingArea">
    <h1 class="label label-info" >用户管理</h1>

    <br>
    <br>

    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>用户名称</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${seller}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td><a deleteLink="true" href="admin_seller_delete?id=${s.id}"><span class="   glyphicon glyphicon-trash"></span></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp" %>
    </div>


</div>

<%@include file="../include/admin/adminFooter.jsp"%>
