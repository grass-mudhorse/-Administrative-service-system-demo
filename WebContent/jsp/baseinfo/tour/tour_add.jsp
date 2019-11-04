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
							观光导游管理
							<small>
								<i class="icon-double-angle-right"></i>
								新增导游信息
							</small>
						</h1>
					</div><!--/.page-header-->

					<form id="validation-form" class="form-horizontal" action="${ctx}/tourController/add.do" method="post">
						<div style="border-bottom:1px dotted #e2e2e2; padding-bottom:13px; margin-bottom:13px;">
							<button class="btn btn-small" type="button" onclick="javascript:location.href='${ctx}/tourController/list.do';">
								<i class="icon-undo"></i>
								返回
							</button>

							<button class="btn btn-small btn-primary" type="submit">
								<i class="icon-save"></i>
								保存
							</button>
						</div>
							
						<div class="row-fluid">
							<div></div>

	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">导游姓名</label>
	
									<div class="controls controls-m">
										<input type="text" name="tourname"/>
									</div>
								</div>	
							</div><!--/span-->
	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">导游年龄</label>
	
									<div class="controls controls-m">
										<input type="text" name="tourage"/>
									</div>
								</div>	
							</div><!--/span-->
						</div><!--/.row-fluid-->
	
						<div class="row-fluid">
							<div></div>
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">导游性别</label>
	
									<div class="controls controls-m">
										<input type="text" name="toursex"/>
									</div>
								</div>		
							</div><!--/span-->
	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">联系方式</label>
	
									<div class="controls controls-m">
										<input type="text" name="tourphone"/>
									</div>
								</div>	
							</div><!--/span-->
						</div><!--/.row-fluid-->
						<div class="row-fluid">
							<div></div>
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">预约情况</label>
	
									<div class="controls controls-m">
										<input type="text" name="tourcon"/>
									</div>
								</div>		
							</div><!--/span-->
				
				<div class="span4">		
						<div class="control-group control-group-m">
									<label class="control-label control-label-m">导游状态</label>
	
									<div class="controls controls-m">
										<select class="chzn-select" data-placeholder="-请选择-" name="tourtempcon" >											
											<option value="可预约" />可预约
											<option value="不可预约" />不可预约	
											<option value="已请假" />已请假										
										</select>
									</div>
						</div>
					</div>							
	
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
				   	  	tourname:{
				   	  		required:true,
				   	  		maxlength:20
				   	  	},
				   	  	tourage:{
				   	  		required:true,
				   	  		number:true
				   	  		
				   	  	},
				   	  	tourphone:{
				   	  		required:true,
				   	  		number:true,
				   	  		maxlength:11
				   	  	},
				   	  	tourcon:{
				   	  		required:true,
				   	  		maxlength:50
				   	  	},
				   	 tourtempcon:"required",
				    },
				    
				    highlight: function (e) {
						$(e).closest('.control-group').removeClass('info').addClass('error');
					},
			
					success: function (e) {
						$(e).closest('.control-group').removeClass('error').addClass('info');
						$(e).remove();
					},
					//重写提交方式
					submitHandler:function(){
						formSubmit();
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
