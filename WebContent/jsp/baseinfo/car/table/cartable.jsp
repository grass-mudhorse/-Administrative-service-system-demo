<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:forEach items="${cars}" var="item">
	<tr class="rowTr">
		<td>${item.id}</td>
		<td>${item.carname}</td>
		<td>${item.carcol}</td>
		<td>${item.cartime}</td>
		<td>${item.carpri}</td>
		<td>${item.carcon}</td>
		<td>${item.cartempcon}</td>
		<td>
			<a class="btn btn-link btn-edit" href="javascript:location.href='${ctx}/carController/toedit.do?id=${item.id}';">修改</a>
			<a class="btn btn-link btn-delete" href="javascript:;" onclick="deletecar('${item.id}')">删除</a>
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