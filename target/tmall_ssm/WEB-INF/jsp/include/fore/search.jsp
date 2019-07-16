<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>

<a href="${contextPath}">
	<img id="logo" src="img/site/logo.png" class="logo">
</a>

<form action="foresearch" method="post" >
	<div class="searchDiv">
		<input name="keyword" type="text" value="${param.keyword}" placeholder="时尚男鞋  太阳镜 ">
		<button  type="submit" class="searchButton">搜索</button>
	</div>
</form>
