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
							会场管理
							<small>
								<i class="icon-double-angle-right"></i>
								修改会场信息
							</small>
						</h1>
					</div><!--/.page-header-->

					<form id="validation-form" class="form-horizontal" action="${ctx}/placeController/edit.do" method="post">
						<div style="border-bottom:1px dotted #e2e2e2; padding-bottom:13px; margin-bottom:13px;">
							<button class="btn btn-small" type="button" onclick="javascript:location.href='${ctx}/placeController/list.do';">
								<i class="icon-undo"></i>
								返回
							</button>

							<input type="hidden" name="id" value="${place.id}"/>
							<button class="btn btn-small btn-primary" type="submit">
								<i class="icon-save"></i>
								保存
							</button>
						</div>
							
						<div class="row-fluid">
							<div></div>

	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">会场名称</label>
	
									<div class="controls controls-m">
										<input type="text" name="placename" value="${place.placename}"/>
									</div>
								</div>	
							</div><!--/span-->
	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">会场规模</label>
	
									<div class="controls controls-m">
										<input type="text" name="placesize" value="${place.placesize}"/>
									</div>
								</div>	
							</div><!--/span-->
						</div><!--/.row-fluid-->
	
						<div class="row-fluid">
							<div></div>
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">会场位置</label>
	
									<div class="controls controls-m">
										<input type="text" name="placeloc" value="${place.placeloc}"/>
									</div>
								</div>		
							</div><!--/span-->
	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">会场价格</label>
	
									<div class="controls controls-m">
										<input type="text" name="placepri" value="${place.placepri}"/>
									</div>
								</div>	
							</div><!--/span-->
						</div><!--/.row-fluid-->

						<div class="row-fluid">
							<div></div>
	
							<div class="span4">
								<div class="control-group control-group-m">
									<label class="control-label control-label-m">租用情况</label>
	
									<div class="controls controls-m">
										<input type="text" name="placecon" value="${place.placecon}"/>
									</div>
								</div>	
							</div><!--/span-->
				
				<div class="span4">		
						<div class="control-group control-group-m">
									<label class="control-label control-label-m">会场状态</label>
	
									<div class="controls controls-m">
										<select class="chzn-select" data-placeholder="-请选择-" name="placetempcon" >											
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
				   	  	placename:{
				   	  		required:true,
				   	  		maxlength:20
				   	  	},
				   	  	placesize:{
				   	  		required:true,
				   	  		number:true
				   	  	},
				   	  	placepri:{
				   	  		required:true,
				   	  		number:true
				   	  	},
				   	  	placeloc:{
				   	  		required:true,
				   	  		maxlength:50
				   	  	},
				   	  	placecon:{
				   	  		required:true,
				   	  		maxlength:50
				   	  	},
				   	 placetempcon:"required",
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
