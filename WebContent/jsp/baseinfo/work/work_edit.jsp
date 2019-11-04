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
							办公用品管理
							<small>
								<i class="icon-double-angle-right"></i>
								修改办公用品信息
							</small>
						</h1>
					</div><!--/.page-header-->

					<form id="validation-form" class="form-horizontal" action="${ctx}/workController/edit.do" method="post">
						<div style="border-bottom:1px dotted #e2e2e2; padding-bottom:13px; margin-bottom:13px;">
							<button class="btn btn-small" type="button" onclick="javascript:location.href='${ctx}/workController/list.do';">
								<i class="icon-undo"></i>
								返回
							</button>

							<input type="hidden" name="id" value="${work.id}"/>
							<button class="btn btn-small btn-primary" type="submit">
								<i class="icon-save"></i>
								保存
							</button>
						</div>
							
						<div class="row-fluid">
							<div></div>

							
							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">办公用品名称</label>
	
									<div class="controls controls-m">
										<input type="text" name="workname" value="${work.workname}"/>
									</div>
								</div>	
							</div><!--/span-->
	
							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">办公用品耗材</label>
	
									<div class="controls controls-m">
										<input type="text" name="workcost" value="${work.workcost}"/>
									</div>
								</div>	
							</div><!--/span-->
	
							
						</div><!--/.row-fluid-->
	
						<div class="row-fluid">
							<div></div>
							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">办公用品尺寸</label>
	
									<div class="controls controls-m">
										<input type="text" name="worksize" value="${work.worksize}"/>
									</div>
								</div>	
							</div><!--/span-->
							
							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">办公用品具体种类</label>
	
									<div class="controls controls-m">
										<input type="text" name="workkind" value="${work.workkind}"/>
									</div>
								</div>		
							</div><!--/span-->
	

						</div><!--/.row-fluid-->

						<div class="row-fluid">
							<div></div>
							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">办公用品价格</label>
	
									<div class="controls controls-m">
										<input type="text" name="workpri" value="${work.workpri}"/>
									</div>
								</div>		
							</div><!--/span-->

							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">办公用品租用情况</label>
	
									<div class="controls controls-m">
										<input type="text" name="workcon" value="${work.workcon}"/>
									</div>
								</div>		
							</div><!--/span-->
							
			</div>				
			<div class="row-fluid">
							<div></div>
							<div class="span5">
								<div class="control-group control-group-m">
									<label class="control-label control-label-l">办公用品数目</label>
	
									<div class="controls controls-m">
										<input type="text" name="worknum" value="${work.worknum}"/>
									</div>
								</div>	
							</div><!--/span-->
				
				<div class="span5">		
						<div class="control-group control-group-m">
									<label class="control-label control-label-l">采购状态</label>
	
									<div class="controls controls-m">
										<select class="chzn-select" data-placeholder="-请选择-" name="worktempcon" >											
											<option value="准备采购" />准备采购
											<option value="采购中" />采购中	
											<option value="采购完成" />采购完成										
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
				   	  	workname:{
				   	  		required:true,
				   	  		maxlength:20
				   	  	},
				   	  	worksize:{
				   	  		required:true,
				   	  		number:true
				   	  	},
				   	  	workpri:{
				   	  		required:true,
				   	  		number:true
				   	  	},
				   	  	workloc:{
				   	  		required:true,
				   	  		maxlength:50
				   	  	},
				   	  	workcon:{
				   	  		required:true,
				   	  		maxlength:50
				   	  	},
				   	  	worknum:{
				   	  		required:true,
				   	  		maxlength:50
				   	  	},
				   	  	workcost:{
				   	  		required:true,
				   	  		maxlength:50
				   	  	},
				   	 worktempcon:"requuired",
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
