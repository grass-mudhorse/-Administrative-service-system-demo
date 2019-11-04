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
							客户管理
							<small>
								<i class="icon-double-angle-right"></i>
								修改客户信息
							</small>
						</h1>
					</div><!--/.page-header-->

					<form id="validation-form" class="form-horizontal" action="${ctx}/clientController/edit.do" method="post">
						<div style="border-bottom:1px dotted #e2e2e2; padding-bottom:13px; margin-bottom:13px;">
							<button class="btn btn-small" type="button" onclick="javascript:location.href='${ctx}/clientController/list.do';">
								<i class="icon-undo"></i>
								返回
							</button>

							<input type="hidden" name="id" value="${client.id}"/>
							<button class="btn btn-small btn-primary" type="submit">
								<i class="icon-save"></i>
								保存
							</button>
						</div>
							
						<div class="row-fluid">
							<div></div>
							
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">客户账号</label>
	
									<div class="controls controls-m">
										<input type="text" name="account" value="${client.account}"/>
									</div>
								</div>	
							</div><!--/span-->
	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">姓名</label>
	
									<div class="controls controls-m">
										<input type="text" name="name" value="${client.name}"/>
									</div>
								</div>	
							</div><!--/span-->
	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">性别</label>
	
									<div class="controls controls-m">
										<input type="text" name="gender" value="${client.gender}"/>
									</div>
								</div>	
							</div><!--/span-->
						</div><!--/.row-fluid-->
	
						<div class="row-fluid">
							<div></div>
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">客户密码</label>
	
									<div class="controls controls-m">
										<input type="text" name="password" value="${client.password}"/>
									</div>
								</div>		
							</div><!--/span-->
	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">身份证号</label>
	
									<div class="controls controls-m">
										<input type="text" name="idcard" value="${client.idcard}"/>
									</div>
								</div>	
							</div><!--/span-->
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">邮箱</label>
	
									<div class="controls controls-m">
										<input type="text" name="email" value="${client.email}"/>
									</div>
								</div>	
							</div><!--/span-->
						</div><!--/.row-fluid-->
						<div class="row-fluid">
						<div></div>
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">手机号</label>
	
									<div class="controls controls-m">
										<input type="text" name="phonenumber1" value="${client.phonenumber1}"/>
									</div>
								</div>	
							</div><!--/span-->
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">家庭电话</label>
	
									<div class="controls controls-m">
										<input type="text" name="phonenumber2" value="${client.phonenumber2}"/>
									</div>
								</div>	
							</div><!--/span-->
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">公司</label>
	
									<div class="controls controls-m">
										<input type="text" name="company" value="${client.company}"/>
									</div>
								</div>	
							</div><!--/span-->

						</div>

						<div class="row-fluid">
						<div></div>
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">职位</label>
	
									<div class="controls controls-m">
										<input type="text" name="position" value="${client.position}"/>
									</div>
								</div>	
							</div><!--/span-->


						</div>

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
				    	name:{
				   	  		required:true,
				   	  		minlength:3,
				   	  		maxlength:20
				   	  	},
			    	account:{
			   	  		required:true,
			   	  		minlength:3,
			   	  		maxlength:20
			   	  	},
			   	  	gender:{
			   	  		required:true,
			   	  		
			   	  	},
			   	  	phonenumber1:{
			   	  		required:true,
						phone:true
			   	  	},
			   	 phonenumber2:{
			   	  		required:true,
			   	  		tel:true
			   	  	},
			   	  	password:{
			   	  		required:true,
			   	  		passCode:true,
			   	  		minlength:7,
			   	  		maxlength:16
			   	  	},
			   	  	email:"email",
			   	 	
			   	 idcard:{
			   	  		required:true,
						idcard:true
			   	  	},
			   	 	company:"required",
			   		position:"required",
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
