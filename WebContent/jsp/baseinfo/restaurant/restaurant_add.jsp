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
							餐厅管理
							<small>
								<i class="icon-double-angle-right"></i>
								新增餐厅类别
							</small>
						</h1>
					</div><!--/.page-header-->

					<form id="validation-form" class="form-horizontal" action="${ctx}/restaurantController/add.do" method="post">
						<div style="border-bottom:1px dotted #e2e2e2; padding-bottom:13px; margin-bottom:13px;">
							<button class="btn btn-small" type="button" onclick="javascript:location.href='${ctx}/restaurantController/list.do';">
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

	
							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">餐厅名称</label>
	
									<div class="controls controls-m">
										<input type="text" name="restaurantname"/>
									</div>
								</div>	
							</div><!--/span-->
	
							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">餐厅可选种类</label>
	
									<div class="controls controls-m">
										<input type="text" name="restaurantsize"/>
									</div>
								</div>	
							</div><!--/span-->
						</div><!--/.row-fluid-->
	
						<div class="row-fluid">
							<div></div>
							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">餐厅可选位置个数</label>
	
									<div class="controls controls-m">
										<input type="text" name="restaurantnum"/>
									</div>
								</div>		
							</div><!--/span-->
	
							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">餐厅位置</label>
	
									<div class="controls controls-m">
										<input type="text" name="restaurantloc"/>
									</div>
								</div>	
							</div><!--/span-->
						</div><!--/.row-fluid-->
						<div class="row-fluid">
							<div></div>
							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">餐厅消费水平/人均</label>
	
									<div class="controls controls-m">
										<input type="text" name="restaurantpri"/>
									</div>
								</div>		
							</div><!--/span-->

							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">餐厅租用情况</label>
	
									<div class="controls controls-m">
										<input type="text" name="restaurantcon"/>
									</div>
								</div>	
							</div><!--/span-->
														
				<div class="span5">		
						<div class="control-group control-group-m">
									<label class="control-label control-label-l">餐厅状态</label>
	
									<div class="controls controls-m">
										<select class="chzn-select" data-placeholder="-请选择-" name="restauranttempcon" >											
											<option value="已出租" />已出租
											<option value="维修中" />维修中	
											<option value="可用" />可用	
											<option value="不可用" />不可用													
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
				   	  	restaurantname:{
				   	  		required:true,
				   	  		maxlength:20
				   	  	},
				   	  	restaurantsize:{
				   	  		required:true,
				   	  		number:true
				   	  	},
				   	  	restaurantpri:{
				   	  		required:true,
				   	  		number:true
				   	  	},
				   	  	restaurantloc:{
				   	  		required:true,
				   	  		maxlength:50
				   	  	},
				   	  	restaurantcon:{
				   	  		required:true,
				   	  		maxlength:50
				   	  	},
				   	 restauranttempcon:"required",
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
