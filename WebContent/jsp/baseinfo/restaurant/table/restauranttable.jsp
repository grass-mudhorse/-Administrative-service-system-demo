<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:forEach items="${restaurants}" var="item">
	<tr class="rowTr">
		<td>${item.id}</td>
		<td>${item.restaurantname}</td>
		<td>${item.restaurantsize}</td>
		<td>${item.restaurantnum}</td>
		<td>${item.restaurantloc}</td>
		<td>${item.restaurantpri}</td>
		<td>${item.restaurantcon}</td>
		<td>${item.restauranttempcon}</td>
		<td>
			<a class="btn btn-link btn-edit" href="javascript:location.href='${ctx}/restaurantController/toedit.do?id=${item.id}';">修改</a>
			<a class="btn btn-link btn-delete" href="javascript:;" onclick="deleterestaurant('${item.id}')">删除</a>
		</td>
	</tr>
</c:forEach>

<%@include file="../../../common/table-btn-limit.jsp" %>
<script type="text/javascript">
	$(function(){
		$(".rowTr").click(function(){
			$(".rowTr").removeClass("xz");
			$(".rowTr").css("color","#000");
			$(this).addClass("xz");
			$(this).css("color","#fff");
		});
		
		//赋值总行数和当前页，应用在custom_pageload.js，js文件不可用el表达式
		sumrow = ${pagingVo.sumrow};
		currentpage = ${pagingVo.currentpage};
		//调用加载分页信息的方法，方法体在custom_pageload.js里
		loadfunction();
	});	
</script>