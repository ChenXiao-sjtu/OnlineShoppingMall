<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>

<div >
	<form action="foresearch" method="post" >
		<div class="simpleSearchDiv pull-right">
			<input type="text" placeholder="平衡车 原汁机"  value="${param.keyword}" name="keyword">
			<button class="searchButton" type="submit">搜索</button>
		</div>
	</form>
	<div style="clear:both"></div>
</div>