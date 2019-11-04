<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<%@include file="../../common/quote.jsp" %>
	</head>

	<body>
		<div class="main-container container-fluid">
			<div class="main-content">
				<div class="page-content">
					<div class="page-header position-relative">
						<h1>
							评价管理
							<small>
								<i class="icon-double-angle-right"></i>
								修改评价信息
							</small>
						</h1>
					</div><!--/.page-header-->

					<form id="validation-form" class="form-horizontal" action="${ctx}/hmcommentController/edit.do" method="post">
						<div style="border-bottom:1px dotted #e2e2e2; padding-bottom:13px; margin-bottom:13px;">
							<button class="btn btn-small" type="button" onclick="javascript:location.href='${ctx}/hmcommentController/list.do';">
								<i class="icon-undo"></i>
								返回
							</button>

							<input type="hidden" name="id" value="${hmcomment.id}"/>
							<button class="btn btn-small btn-primary" type="submit">
								<i class="icon-save"></i>
								保存
							</button>
						</div>
							
						<div class="row-fluid">
							<div></div>
	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">项目ID</label>
	
									<div class="controls controls-m">
										<input type="text" name="projectid" value="${hmcomment.projectid}"/>
									</div>
								</div>	
							</div><!--/span-->
	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">项目名称</label>
	
									<div class="controls controls-m">
										<input type="text" name="projectname" value="${hmcomment.projectname}"/>
									</div>
								</div>	
							</div><!--/span-->
						</div><!--/.row-fluid-->
						
						
	
							
						<div class="row-fluid">
							<div></div>
	
							
	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">客户账户</label>
	
									<div class="controls controls-m">
										<input type="text" name="projectname" value="${hmcomment.clientaccount}"/>
									</div>
								</div>	
							</div><!--/span-->
						</div><!--/.row-fluid-->
	
						

											

					</form><!-- /.form -->
				</div><!--/.page-content-->
			</div><!--/.main-content-->
		</div><!--/.main-container-->

		<script type="text/javascript">
			$(function(){
				//开启表单验证
				formValidate();
			});
			
			//表单验证
			function formValidate(){
				$("#validation-form").validate({
					errorElement: 'label',
					errorClass: 'help-inline',
					focusInvalid: false,
				    rules: {
				  	  	hmcommentname:{
				   	  		required:true,
				   	  		maxlength:20
				   	  		},
				   	  	
				   	    hmcommentcol:{
				   	    	required:true,
				   	    	maxlength:20
				   	    },
				   	 	hmcommenttime:{
				   	 	required:true,
			   	  		number:true
				   	 	},
				   	    hmcommentpri:{
				   	  		required:true,
				   	  		number:true
				   	  	},
				   	  	hmcommentcon:{
				   	  	required:true,
				   	 	maxlength:100
				   	  	},
				   	  	hmcommenttempcon:"required",
				   	  	
				    },
				    
				    highlight: function (e) {
						$(e).closest('.control-group').removeClass('info').addClass('error');
					},
			
					success: function (e) {
						$(e).closest('.control-group').removeClass('error').addClass('info');
						$(e).remove();
					}
			    });
			}
			
			//表单提交
			function formSubmit(){
				swal({
				  	title: "是否保存?",
				  	text: "",
				  	type: "warning",
				  	showCancelButton: true,
				  	cancelButtonText: "否",
				  	confirmButtonClass: "btn-danger",
				  	confirmButtonText: "是",
				  	closeOnConfirm: true
				},
				function(){
					document.forms[0].submit();
				});
			}
		</script>
	</body>
</html>
