<!-- 显示左侧的竖状分类导航 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	
<div class="categoryMenu">
		<c:forEach items="${cs}" var="c">
			<div cid="${c.id}" class="eachCategory">
				<a>${c.name}</a>
			</div>
		</c:forEach>
</div>