<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<%@include file="../../common/quote.jsp" %>
		<%@include file="../../common/list-btn-limit.jsp" %>
	</head>

	<body>
		<div class="main-container container-fluid">			

			<div class="main-content">
				

				<div class="page-content">
					<div class="page-header position-relative">
						<h1>
							评价管理
							<input id="gritter-light" checked="" type="checkbox" class="ace-switch ace-switch-5" />
						</h1>
					</div><!--/.page-header-->
					
					<div class="nav-search" id="nav-search" style="margin-top:5px;">
						<form class="form-search" />
							<span class="input-icon">
								<input type="text" placeholder="搜索..." class="input-small nav-search-input" id="nav-search-input" autocomplete="off" onkeyup="search()" />
								<i class="icon-search nav-search-icon"></i>
							</span>
						</form>
					</div><!--#nav-search-->
						
						
					
					
					<div style="border-bottom:1px dotted #e2e2e2; margin-bottom:10px;"></div>	

					<table class="table" style="overflow:auto;">
						<thead>
							<tr style="background:#fff;">
								<th>项目ID</th>
								<th>项目名称</th>
								<th>客户账号</th>
								<th>客户评价</th>
								<th>评价日期</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="datas">
							
						</tbody>			
					</table>
					<%@include file="../../common/pagingmenu.jsp" %>
				</div><!--/.page-content-->
			</div><!--/.main-content-->
		</div><!--/.main-container-->
		
		<!-- 参数化,应用在custom_pageload.js -->
		<script type="text/javascript">					
			var ctx = "${ctx}";
			var controller = "/clientcommentController";
			var sumrow;
			var currentpage;
		</script>

		<!--inline scripts related to this page-->

		<script type="text/javascript">
			$(function(){
				find(1);
				//提交返回信息
				if("${resulttext}" == "add"){
					hint("新增成功！");
				}else if("${resulttext}" == "edit"){
					hint("修改成功！");
				}
			});
			
			//跳转页数
			function find(page){
				gettable(page);
			}
			
		  	//查询
		  	function gettable(page){
		  		//获取数据
		  		$.post(ctx + controller + "/datalist.do",
					{contant:$("#nav-search-input").val(),
					 pagesize:$("#pagesize").val(), 
					 currentpage:page},
					function(data){
		  				$("#datas").html(data);
					});
		  	}
		  	
		  	//搜索
		  	function search(){
		  		find(1);
		  	}
		  	
		  	//删除确认提示
		  	function deleteclientcomment(id){
		  		swal({
				  	title: "是否删除?",
				  	text: "",
				  	type: "warning",
				  	showCancelButton: true,
				  	cancelButtonText: "否",
				  	confirmButtonClass: "btn-danger",
				  	confirmButtonColor: "#b74635",
				  	confirmButtonText: "是",
				  	closeOnConfirm: true
				},
				function(){
					$.post(ctx + controller + "/delete.do",
					{id:id},
					function(data){
		  				hint(data.msg);
		  				search();
					});
				});
		  	}
		  	
		  	 function checkData(){  
	                var fileDir = $("#upfile").val();  
	                var suffix = fileDir.substr(fileDir.lastIndexOf("."));  
	                if("" == fileDir){  
	                    alert("选择需要导入的Excel文件！");  
	                    return false;  
	                }  
	                if(".xls" != suffix && ".xlsx" != suffix ){  
	                    alert("选择Excel格式的文件导入！");  
	                    return false;  
	                }  
	                return true;  
	             }  
		</script>
	</body>
</html>
