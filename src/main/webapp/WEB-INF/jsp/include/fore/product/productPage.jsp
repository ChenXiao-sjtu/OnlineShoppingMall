<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<title>网上商城 ${p.name}</title>
<div class="categoryPictureInProductPageDiv">
	<img class="categoryPictureInProductPage" src="img/category/${p.category.id}.jpg">
</div>

<div class="productPageDiv">

	<%@include file="imgAndInfo.jsp" %>

	<%@include file="productDetail.jsp" %>
</div>