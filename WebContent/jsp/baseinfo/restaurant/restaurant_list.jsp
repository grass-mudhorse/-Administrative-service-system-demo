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
							餐厅管理
							<input id="gritter-light" checked="" type="checkbox" class="ace-switch ace-switch-5" />
						</h1>
					</div><!--/.page-header-->
					
					<div class="nav-search" id="nav-search" style="margin-top:5px;">
						<form class="form-search" />
							<span class="input-icon">
								<input type="text" restaurantholder="搜索..." class="input-small nav-search-input" id="nav-search-input" autocomplete="off" onkeyup="search()" />
								<i class="icon-search nav-search-icon"></i>
							</span>
						</form>
					</div><!--#nav-search-->
					
					<div class="row-fluid">					
						<div class="span4">
							<div class="control-group control-group-m">
								<div class="controls controls-l">
									<button class="btn btn-small btn-success btn-add" onclick="javascript:location.href='${ctx}/restaurantController/toadd.do';">
										<i class="icon-share-alt"></i>
										新增
									</button>
									<button class="btn btn-small btn-success btn-add" onclick="javascript:location.href='${ctx}/restaurantController/export.do';">
										<i class="icon-share-alt"></i>
										导出
									</button>
								</div>
							</div>
						</div><!--/span-->
				<form method="POST"  enctype="multipart/form-data" id="form1" action="${ctx}/restaurantController/impotr.do">
				
						<div class="span4">
							<div class="control-group control-group-m">
								<div class="controls controls-l">
									<input value= "选择文件" id="upfile" type="file" name="upfile"/>										
								</div>
							</div>
						</div><!--/span--> 				
						
						<div class="span4">
							<div class="control-group control-group-m">
								<div class="controls controls-l">
									<button class="btn btn-small btn-primary" type="submit" onclick= "return checkData()">
										<i class="icon-save"></i>
										批量导入
									</button>
								</div>
							</div>
						</div><!--/span-->
				</form>	
					</div><!--/.row-fluid-->
					
					<div style="border-bottom:1px dotted #e2e2e2; margin-bottom:10px;"></div>	

					<table class="table" style="overflow:auto;">
						<thead>
							<tr style="background:#fff;">
								<th>餐厅ID</th>
								<th>餐厅名称</th>
								<th>餐厅可选位置种类</th>
								<th>餐厅可选位置个数</th>
								<th>餐厅位置</th>
								<th>餐厅消费水平/人均</th>
								<th>餐厅租用情况</th>
								<th>餐厅状态</th>	
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
			var controller = "/restaurantController";
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
		  	function deleterestaurant(id){
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
		</script>
	</body>
</html>