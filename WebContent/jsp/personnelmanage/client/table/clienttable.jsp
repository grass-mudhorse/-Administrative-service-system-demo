<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:forEach items="${clients}" var="item">
	<tr class="rowTr">
		<td>${item.account}</td>
		<td>${item.name}</td>
		<td>${item.gender}</td>
		<td>${item.password}</td>
		<td>${item.idcard}</td>
		<td>${item.email}</td>
		<td>${item.phonenumber1}</td>
		<td>${item.phonenumber2}</td>
		<td>${item.company}</td>
		<td>${item.position}</td>
		<td>
			<a class="btn btn-link btn-edit" href="javascript:location.href='${ctx}/clientController/toedit.do?id=${item.id}';">修改</a>
			<a class="btn btn-link btn-delete" href="javascript:;" onclick="deleteclient('${item.id}')">删除</a>
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